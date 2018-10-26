package com.volive.webviewvideo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Full extends AppCompatActivity {

    WebView webview;
    RelativeLayout linear;
    FrameLayout mContentView,mCustomViewContainer;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        mContentView = (FrameLayout) findViewById(R.id.main_content);
        mWebView = (WebView) findViewById(R.id.webView);
        mCustomViewContainer = (FrameLayout) findViewById(R.id.fullscreen_custom_content);
    }
//    void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback)
//    {
//        // if a view already exists then immediately terminate the new one
//        if (mCustomView != null)
//        {
//            callback.onCustomViewHidden();
//            return;
//        }
//
//        // Add the custom view to its container.
//        mCustomViewContainer.addView(view, COVER_SCREEN_GRAVITY_CENTER);
//        mCustomView = view;
//        mCustomViewCallback = callback;
//
//        // hide main browser view
//        mContentView.setVisibility(View.GONE);
//
//        // Finally show the custom view container.
//        mCustomViewContainer.setVisibility(View.VISIBLE);
//        mCustomViewContainer.bringToFront();
//    }
//
//    void onHideCustomView()
//    {
//        if (mCustomView == null)
//            return;
//
//        // Hide the custom view.
//        mCustomView.setVisibility(View.GONE);
//        // Remove the custom view from its container.
//        mCustomViewContainer.removeView(mCustomView);
//        mCustomView = null;
//        mCustomViewContainer.setVisibility(View.GONE);
//        mCustomViewCallback.onCustomViewHidden();
//
//        // Show the content view.
//        mContentView.setVisibility(View.VISIBLE);
//    }
//
//    public Bitmap getDefaultVideoPoster()
//    {
//        if (mDefaultVideoPoster == null)
//        {
//            mDefaultVideoPoster = BitmapFactory.decodeResource(getResources(), R.drawable.default_video_poster);
//        }
//        return mDefaultVideoPoster;
//    }
//
//    public View getVideoLoadingProgressView()
//    {
//        if (mVideoProgressView == null)
//        {
//            LayoutInflater inflater = LayoutInflater.from(this);
//            mVideoProgressView = inflater.inflate(R.layout.video_loading_progress, null);
//        }
//        return mVideoProgressView;
//    }
}
