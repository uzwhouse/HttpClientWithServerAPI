package uz.pdp.services;

import uz.pdp.utils.Result;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

import static uz.pdp.utils.Result.getResult;
import static uz.pdp.utils.Utils.request;

public class GetRequestExample {


    public static void currentTimeGetRequest(String uri) {
        request(getResult(uri));
    }

    public static void postsGetRequest(String uri) {
        request(getResult(uri));
    }

    public static void timeoutGetRequest(String uri) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .timeout(Duration.ofSeconds(1))
                .GET()
                .build();
        Result result = new Result(httpClient, request);
        request(result);
    }

    public static void fileUploadGetRequest(String uri) {
        postsGetRequest(uri);
    }
}
