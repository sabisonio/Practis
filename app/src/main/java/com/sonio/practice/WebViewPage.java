package com.sonio.practice;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by admin on 2016/11/27.
 */

public class WebViewPage extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewpage);
        WebView webView=(WebView)findViewById(R.id.webview);
        if (Build.VERSION.SDK_INT >= 14) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClientDemo());


        webView.loadUrl("http://www.baidu.com");
    }
    private class WebViewClientDemo extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
}
