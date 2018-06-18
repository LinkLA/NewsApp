package com.news.newsapp.Dagger;

import android.content.Context;

import com.news.newsapp.Data.New;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseph on 6/17/2018.
 */

@Module
public class AppModule {
    private final NewsApplication app;

    public AppModule(NewsApplication app){
        this.app = app;
    }

    @Provides @Singleton
    NewsApplication provideNewsApplication(){
        return app;
    }


    @Provides
    public New proviANew(){
        return new New();
    }

    @Provides @Singleton
    public Context provideContext(){
        return app;
    }

}
