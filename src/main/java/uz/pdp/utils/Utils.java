package uz.pdp.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.models.Post;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static uz.pdp.utils.Result.getResult;

public class Utils {
    public static void request(Result result) {
        try {
            HttpResponse<String> httpResponse = result.httpClient().send(result.request(), HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);
            System.out.println(httpResponse.body() + "\n");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showPostList(String uri) {
        Result result = getResult(uri);
        try {
            HttpResponse<String> httpResponse = result.httpClient().send(result.request(), HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);
            Gson gson = new Gson();
            List<Post> postList = gson.fromJson(httpResponse.body(), new TypeToken<ArrayList<Post>>() {
            }.getType());
            postList.forEach(System.out::println);
            System.out.println();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
