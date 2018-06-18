package com.news.newsapp.Dagger;

import com.news.newsapp.Data.NewDataController;
import com.news.newsapp.Contracts.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by joseph on 6/17/2018.
 */

@Module
public class PersistenceModule {

    @Provides @Singleton
    public Repository providesNewRepository(Realm realm){
        return new NewDataController(realm);
    }
}
