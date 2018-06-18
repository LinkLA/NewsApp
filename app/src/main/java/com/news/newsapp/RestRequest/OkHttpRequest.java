package com.news.newsapp.RestRequest;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by joseph on 6/17/2018.
 */

public class OkHttpRequest {
    public static String GetNews(String server) throws Exception {
        Response response = null;

        try {
            OkHttpClient client = new OkHttpClient();
            client.newBuilder().connectTimeout(15, TimeUnit.SECONDS);

            HttpUrl.Builder urlBuilder = HttpUrl.parse(server).newBuilder();
            urlBuilder.addQueryParameter("country","us");
            urlBuilder.addQueryParameter("category","business");
            urlBuilder.addQueryParameter("apiKey","6ace8d6a0e0e43d39671fd4123ff0a4e");
            String url = urlBuilder.build().toString();

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();

        } catch (final java.net.SocketTimeoutException e) {
            return "{\"status\":false,\"error\":\"Connection error : "+e.getLocalizedMessage().toString().replace("\"", "\\\"")+"\"}";
        }
    }
}
