package uz.pdp.services;

import static uz.pdp.utils.Result.deleteResult;
import static uz.pdp.utils.Utils.request;

public class DeleteRequestExample {
    public static void deletePostDeleteRequest(String uri) {
        request(deleteResult(uri));
    }
}
