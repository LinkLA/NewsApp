package com.news.newsapp.Contracts;

import com.news.newsapp.Data.New;

/**
 * Created by joseph on 6/17/2018.
 */

public interface Actions {
    void loadNewsFromUrl();
    void loadFavoriteNews();
    New getNew(long id);
    void addNew(New myNew);
    void addNewToFavorites(long id);
    void onNewClicked(New myNew);
}
