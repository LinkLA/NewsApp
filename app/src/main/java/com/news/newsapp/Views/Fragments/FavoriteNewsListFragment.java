package com.news.newsapp.Views.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.news.newsapp.Contracts.Actions;
import com.news.newsapp.Data.New;
import com.news.newsapp.Contracts.NewsView;
import com.news.newsapp.Presenter.NewListPresenter;
import com.news.newsapp.R;
import com.news.newsapp.Views.WebViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by joseph on 6/17/2018.
 */

/**
 * Class that enables our news list to get deployed
 *
 * It uses a SimpleAdapter to deploy news that users previously got stored into the Realm database.
 */
public class FavoriteNewsListFragment extends Fragment implements NewsView {
    private View mRootView;
    private Actions mPresenter;
    private ListView mListView;
    private Context mContext;

    public FavoriteNewsListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.favorite_news_fragment, container, false);

        mContext = getActivity().getApplicationContext();
        mPresenter = new NewListPresenter(this);
        mListView = (ListView) mRootView.findViewById(R.id.fav_news_listview);

        LoadNews();

        return mRootView;
    }

    private void LoadNews() {
        mPresenter.loadFavoriteNews();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            LoadNews();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showNewsFromUrl(List<New> news) {

    }

    @Override
    public void showFavoriteNews(List<New> favoriteNews) {
        prepareNewsAdapter(favoriteNews);
    }

    @Override
    public void showNewOnWebView(New item) {

        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra("url", item.getUrl() );
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    private void prepareNewsAdapter(final List<New> news) {
        ArrayList<HashMap<String,String>> items = new ArrayList<>();

        for(int i = 0 ; i < news.size() ; i++){
            items.add(news.get(i).toHashMap());
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                New item = news.get(i);

                if(item.getUrl() != null) {
                    showNewOnWebView(item);
                }else{
                    Toast.makeText(mContext, "This article does not have a page", Toast.LENGTH_LONG).show();
                }
            }
        });

        SimpleAdapter newsAdapter = new SimpleAdapter(getActivity().getBaseContext(), items, R.layout.fav_news_list_item,
                new String[]{"title"}, new int[]{R.id.fav_new_title});

        mListView.setAdapter(newsAdapter);
    }
}
