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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.news.newsapp.Contracts.Actions;
import com.news.newsapp.Data.New;
import com.news.newsapp.Contracts.NewsView;
import com.news.newsapp.Presenter.NewListPresenter;
import com.news.newsapp.R;
import com.news.newsapp.Utils.CustomAdapter;
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
 * It uses our CustomAdapter @see {@link CustomAdapter} to deploy the news list, allowing the user to store their favorite news
 * inside the Realm database.
 */
public class NewsListFragment extends Fragment implements NewsView, CustomAdapter.OnListAdapterEventListener {
    private View mRootView;
    private Actions mPresenter;
    private ListView mListView;
    private Context mContext;

    public NewsListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.news_fragment, container, false);

        mContext = getActivity().getApplicationContext();

        mPresenter = new NewListPresenter(this);
        mListView = (ListView) mRootView.findViewById(R.id.news_listview);

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadNewsFromUrl();
    }

    @Override
    public void showNewsFromUrl(List<New> news) {
        prepareNewsAdapter(news);

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

        SimpleAdapter newsAdapter = new CustomAdapter(getActivity().getBaseContext(), items, R.layout.news_list_item,
                new String[]{"title"}, new int[]{R.id.new_title}){
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                ImageView favButton = (ImageView) view.findViewById(R.id.fav_button);

                favButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        New singleNew  = news.get(position);

                        mPresenter.addNew(singleNew);
                        Toast.makeText(mContext, "Added to favorites!", Toast.LENGTH_SHORT).show();
                    }
                });
                return view;
            }
        };

        mListView.setAdapter(newsAdapter);
    }

    @Override
    public void showFavoriteNews(List<New> favoriteNews) {
    }

    @Override
    public void showNewOnWebView(New item) {
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra("url", item.getUrl() );
        mContext.startActivity(intent);
    }

    @Override
    public void onItemButtonClick(View view, HashMap<String, String> item) {
    }
}
