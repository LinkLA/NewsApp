package com.news.newsapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.news.newsapp.R;

/**
 * Class that sets up a WebView to show a previously new that was clicked by the user.
 *
 * It will only receive the url via Intent to then use it in the WebView configuration.
 */
public class WebViewActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        SetWebView(url);
    }

    private void SetWebView(String url){
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setFocusable(true);
        webview.setFocusableInTouchMode(true);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setDatabaseEnabled(true);
        webview.getSettings().setAppCacheEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.loadUrl(url);
        webview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()  ){
            webview.goBack();
        }
        super.onBackPressed();
    }
}
