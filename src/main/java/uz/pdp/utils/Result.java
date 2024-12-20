package uz.pdp.utils;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Base64;

public record Result(HttpClient httpClient, HttpRequest request) {
    public static Result getResult(String uri) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        return new Result(httpClient, request);
    }

    public static Result postResult(String uri) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("""
                          {
                            "body": "Hic consequatur accusantium. Enim quae blanditiis. Qui voluptatibus saepe.",
                            "title": "Consequatur"
                          },
                        """))
                .build();
        return new Result(httpClient, request);
    }

    public static Result deleteResult(String uri) {
//        HttpClient httpClientBuilder = HttpClient.newBuilder()
//                .authenticator(new Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication("user", "password".toCharArray());
//                    }
//                })
//                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .headers("Authorization", "Basic " + Base64.getEncoder().encodeToString(("user:password").getBytes()))
                .DELETE()
                .build();
        return new Result(httpClient, request);
    }

    public static Result putResult(String uri, String id) {
        HttpClient httpClient = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("user", "password".toCharArray());
                    }
                })
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .PUT(HttpRequest.BodyPublishers.ofString("""
                          {
                            "id": "%s",
                            "body": "Hello PDP!",
                            "title": "Online PDP"
                          },
                        """.formatted(id)))
                .build();
        return new Result(httpClient, request);
    }

}
