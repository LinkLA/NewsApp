package com.news.newsapp.Presenter;

import android.os.AsyncTask;

import com.news.newsapp.Contracts.Actions;
import com.news.newsapp.Constants.Data;
import com.news.newsapp.Data.NewDataController;
import com.news.newsapp.Data.New;
import com.news.newsapp.Contracts.NewsView;
import com.news.newsapp.Contracts.Repository;
import com.news.newsapp.RestRequest.OkHttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by joseph on 6/17/2018.
 */
public class NewListPresenter implements Actions {
    private final NewsView mView;
    private List<New> news = new ArrayList<>();

    @Inject
    Repository mRepository;

    public NewListPresenter(NewsView view){
        this.mView = view;

        mRepository = new NewDataController(Realm.getDefaultInstance());
    }

    @Override
    public void loadNewsFromUrl() {
        (new PostDownloadTask()).execute();
    }

    @Override
    public void loadFavoriteNews() {
        List<New> news = mRepository.getAllNews();

        if(news.size() > 0){
            mView.showFavoriteNews(news);
        }
    }

    @Override
    public New getNew(long id) {
        return mRepository.getNewById(id);
    }

    @Override
    public void addNew(New myNew) {
        mRepository.addNew(myNew);
    }

    @Override
    public void addNewToFavorites(long id) {

    }

    @Override
    public void onNewClicked(New myNew) {
        mView.showNewOnWebView(myNew);
    }

    public class PostDownloadTask extends AsyncTask<Void, Void, Boolean> {
        private JSONArray data;

        PostDownloadTask() {
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                String result = OkHttpRequest.GetNews(Data.serverUrl);
                if (result!= null && !result.equals("")) {

                    try {
                        JSONObject jsonData = new JSONObject(result);

                        if(jsonData.getString("status").equals(Data.serverResponseOk) && jsonData.optJSONArray("articles") != null){
                            data = jsonData.optJSONArray("articles");
                            return true;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if(success) {
                for(int i = 0; i<data.length() ; i++){
                    try {
                        news.add(new New(data.getJSONObject(i)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                if(news != null && news.size() > 0){
                    mView.showNewsFromUrl(news);
                }
            }
        }
    }

}
