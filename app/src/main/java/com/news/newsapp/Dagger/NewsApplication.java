package com.news.newsapp.Dagger;

import android.app.Application;

/**
 * Created by joseph on 6/17/2018.
 */

public class NewsApplication extends Application {
    private static NewsApplication instance = new NewsApplication();
    private AppComponent appComponent;


    public static NewsApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public AppComponent getAppComponent(){
        if(appComponent == null){
            appComponent =  DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }

        return appComponent;
    }
}
