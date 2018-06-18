package com.news.newsapp.Contracts;

import com.news.newsapp.Data.New;

import java.util.List;

/**
 * Created by joseph on 6/17/2018.
 */

public interface NewsView {
    void showNewsFromUrl(List<New> news);
    void showFavoriteNews(List<New> favoriteNews);
    void showNewOnWebView(New item);
}
