package com.news.newsapp.Views;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.news.newsapp.Dagger.NewsApplication;
import com.news.newsapp.Views.Fragments.FavoriteNewsListFragment;
import com.news.newsapp.Views.Fragments.NewsListFragment;
import com.news.newsapp.Data.New;
import com.news.newsapp.R;
import com.news.newsapp.Utils.ViewPagerAdapter;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Sets up general Views, tabs layouts and  its fragments.
 */
public class MainActivity extends AppCompatActivity {
    @Inject
    New myNew;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("news")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        ((NewsApplication) getApplication()).getAppComponent().inject(this);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_widget);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewsListFragment(), "News");
        adapter.addFragment(new FavoriteNewsListFragment(), "Favorite News");

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
