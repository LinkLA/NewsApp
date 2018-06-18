package com.news.newsapp.Contracts;

import android.widget.ListView;

import com.news.newsapp.Data.New;

import java.util.List;

/**
 * Created by joseph on 6/17/2018.
 */

public interface Repository {
    List<New> getAllNews();
    void showNews(ListView list, New myNew);
    void addNew(New myNew);
    void updateNew(New myNew);
    New getNewById(long id);
}
