package uz.pdp.services;

import static uz.pdp.utils.Result.putResult;
import static uz.pdp.utils.Utils.request;

public class PutRequestExample {
    public static void updatePostPutRequest(String uri, String id) {
        request(putResult(uri, id));
    }

}
