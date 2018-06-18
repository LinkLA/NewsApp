package com.news.newsapp;

import com.news.newsapp.Constants.Data;
import com.news.newsapp.RestRequest.OkHttpRequest;

import org.json.JSONObject;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by joseph on 6/17/2018.
 */
public class OkHttpRequestTest {

    @Test
    public void restRequestIsOk() throws Exception{
        String result = OkHttpRequest.GetNews(Data.serverUrl);

        JSONObject data = new JSONObject(result);

        assertEquals(Data.serverResponseOk, data.getString("status"));
    }
}
