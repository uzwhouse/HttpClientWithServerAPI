package uz.pdp.services;

import static uz.pdp.utils.Result.postResult;
import static uz.pdp.utils.Utils.request;

public class PostRequestExample {
    public static void postCreatePostRequest(String uri) {
        request(postResult(uri));
    }


}
