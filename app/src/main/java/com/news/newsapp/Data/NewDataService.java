package com.news.newsapp.Data;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by joseph on 6/17/2018.
 */

public class NewDataService {
    private Realm realm;

    public NewDataService(Realm realm){
        this.realm = realm;
    }

    public ArrayList<New> getAllNews(){
        RealmResults<New> results = realm.where(New.class).findAll();

        return new ArrayList<>(results);
    }

    public New getNewById(long id){
        return realm.where(New.class).equalTo("id",id).findFirst();
    }

    public void addNew(New myNew){
        realm.beginTransaction();

        New currentNew = realm.createObject(New.class, getNextKey());
        currentNew.setTitle(myNew.getTitle());
        currentNew.setDescription(myNew.getDescription());
        currentNew.setAuthor(myNew.getAuthor());
        currentNew.setUrl(myNew.getUrl());
        currentNew.setPublishedTime(myNew.getPublishedTime());
        currentNew.setUrlToImage(myNew.getUrlToImage());
        currentNew.setSource(myNew.getSource());

        realm.commitTransaction();
    }

    private int getNextKey() {
        try {
            Number number = realm.where(New.class).max("id");
            if (number != null) {
                return number.intValue() + 1;
            } else {
                return 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }
}
