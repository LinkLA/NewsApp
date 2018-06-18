package com.news.newsapp.Data;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by joseph on 6/17/2018.
 */
public class New extends RealmObject{

    @PrimaryKey
    private int id;

    private String author;
    private String title;
    private String description;
    private String url;
    private Date publishedTime;
    private String urlToImage;

    /** It is a Json Object **/
    private String source;

    public New(){

    }

    public New(JSONObject newData){
        title = newData.optString("title");
        description = newData.optString("description");
        author = newData.optString("author","Anonymous");
        url  = newData.optString("url");
        urlToImage = newData.optString("urlToImage");

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            publishedTime = formatter.parse(newData.opt("publishedAt").toString());

            source = newData.getString("source");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String,String> toHashMap(){
        HashMap<String, String> data = new HashMap<>();

        data.put("title", title);
        data.put("description", description);
        data.put("author", author);
        data.put("url", url);
        data.put("urlToImage", urlToImage);

        if(publishedTime == null){
            data.put("publishedAt","No date");
        }else{
            data.put("publishedAt", publishedTime.toString());
        }

        data.put("source", source);

        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
