package com.news.newsapp.Data;

import android.widget.ListView;

import com.news.newsapp.Contracts.Repository;

import java.util.List;

import io.realm.Realm;

/**
 * Created by joseph on 6/17/2018.
 */

public class NewDataController implements Repository {
    private NewDataService mNewDataService;

    public NewDataController(Realm realm){
        mNewDataService = new NewDataService(realm);
    }

    @Override
    public List<New> getAllNews() {
        return mNewDataService.getAllNews();
    }

    @Override
    public void showNews(ListView list, New myNew) {

    }

    @Override
    public void addNew(New myNew) {
        mNewDataService.addNew(myNew);
    }

    @Override
    public void updateNew(New myNew) {

    }

    @Override
    public New getNewById(long id) {
        return mNewDataService.getNewById(id);
    }
}
