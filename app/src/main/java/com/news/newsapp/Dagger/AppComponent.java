package com.news.newsapp.Dagger;

import com.news.newsapp.Views.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseph on 6/17/2018.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                PersistenceModule.class
        }
)

public interface AppComponent {
    void inject(MainActivity activity);
}
