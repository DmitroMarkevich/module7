package org.example;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class HttpStatusChecker {
    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();
    private static final String BASE_URL = "https://http.cat/";

    public String getStatusImage(int code) {
        String imageUrl = BASE_URL + code + ".jpg";

        try {
            Request request = new Request.Builder()
                    .url(imageUrl)
                    .build();

            Response response = OK_HTTP_CLIENT
                    .newCall(request)
                    .execute();

            if (response.code() == 404) {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageUrl;
    }
}
