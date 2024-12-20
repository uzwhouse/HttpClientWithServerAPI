package uz.pdp;


import static uz.pdp.services.GetRequestExample.currentTimeGetRequest;
import static uz.pdp.services.PutRequestExample.updatePostPutRequest;
import static uz.pdp.utils.Utils.showPostList;

public class App {
    public static void main(String[] args) {
        currentTimeGetRequest("http://localhost:8080/current-time");
//        postCreatePostRequest("http://localhost:8080/post/create/");
//        postsGetRequest("http://localhost:8080/posts/");
//        fileUploadGetRequest("http://localhost:8080/file/upload/?file=filename");
//        timeoutGetRequest("http://localhost:8080/timeout/request/");
        showPostList("http://localhost:8080/posts/");
//        deletePostDeleteRequest("http://localhost:8080/post/delete/4b2b7245-ae07-4f98-9e0c-faa6cce9280e");
//        showPostList("http://localhost:8080/posts/");
//        updatePostPutRequest("http://localhost:8080/post/update/", "id=1137c17e-1ca7-4fb6-b15f-da4fd9a720cd");
//        showPostList("http://localhost:8080/posts/");
    }


}
