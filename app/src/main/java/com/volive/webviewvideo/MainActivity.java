package com.volive.webviewvideo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.volive.webviewvideo.R.drawable.ic_launcher_background;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private FrameLayout customViewContainer;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private View mCustomView;
    private myWebChromeClient mWebChromeClient;
    private myWebViewClient mWebViewClient;
    WebView web;
    TextView load_tv;
    final String offlineMessageHtml = "https://www.google.co.in/search?q=E%2FYouTube%3A+Error+in+sending+SendDeviceContextRequest.&oq=E%2FYouTube%3A+Error+in+sending+SendDeviceContextRequest.+&aqs=chrome..69i57j69i58.699j0j4&sourceid=chrome&ie=UTF-8";
    final String timeoutMessageHtml = "https://github.com/facebook/react-native/issues/10055";
    ProgressBar progressBar;
    boolean isPageError = false;
    TextView txtError;
    private Context c;
    ImageView imagesrc;
    private boolean isConnected = true;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customViewContainer = (FrameLayout) findViewById(R.id.customViewContainer);
        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        imagesrc=findViewById(R.id.imagesrc);
        mWebViewClient = new myWebViewClient();
        webView.setWebViewClient(mWebViewClient);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView.loadUrl("file:///android_asset/html.html");
            }
        });
        txtError = findViewById(R.id.txtError);
        load_tv = findViewById(R.id.load_tv);
        mWebChromeClient = new myWebChromeClient();
        webView.setWebChromeClient(mWebChromeClient);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.clearHistory();
        webView.clearFormData();

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSaveFormData(true);
//        webView.loadUrl("http://m.youtube.com");
//        webView.setWebChromeClient(new WebChromeClient());
        if (savedInstanceState == null) {
            webView.loadUrl("https://s3-eu-west-1.amazonaws.com/isochal-prod/cv/bbsCMvovMvGpJof2wbIcz23Pn7ze87znIE8pBSEs.mp4");
        }
//        webView.loadUrl("https://s3-eu-west-1.amazonaws.com/isochal-prod/cv/bbsCMvovMvGpJof2wbIcz23Pn7ze87znIE8pBSEs.mp4");
//
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                // TODO show you progress image
//                super.onPageStarted(view, url, favicon);
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                // TODO hide your progress image
//                super.onPageFinished(view, url);
//            }
//        });
//        try {
//            ConnectivityManager connectivityManager = (ConnectivityManager)
//                    c.getSystemService(Context.CONNECTIVITY_SERVICE);
//            if (connectivityManager != null) {
//                NetworkInfo ni = connectivityManager.getActiveNetworkInfo();
//                if (ni.getState() != NetworkInfo.State.CONNECTED) {
//                    // record the fact that there is not connection
//                    isConnected = false;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            // for example the width of a layout
            int width = 600;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;
//            WebView childLayout = (WebView) findViewById(R.id.webview);
//            childLayout.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
        webView.loadUrl("https://s3-eu-west-1.amazonaws.com/isochal-prod/cv/bbsCMvovMvGpJof2wbIcz23Pn7ze87znIE8pBSEs.mp4");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        webView.loadUrl("https://s3-eu-west-1.amazonaws.com/isochal-prod/cv/bbsCMvovMvGpJof2wbIcz23Pn7ze87znIE8pBSEs.mp4");
        webView.restoreState(savedInstanceState);
    }
    public boolean inCustomView()
    {
        return (mCustomView != null);
    }

    public void hideCustomView() {
        mWebChromeClient.onHideCustomView();
    }

    @Override
    protected void onPause() {
        super.onPause();    //To change body of overridden methods use File | Settings | File Templates.
        webView.onPause();


    }

    @Override
    protected void onResume() {
        super.onResume();    //To change body of overridden methods use File | Settings | File Templates.
        webView.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();    //To change body of overridden methods use File | Settings | File Templates.
        if (inCustomView()) {
            hideCustomView();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (inCustomView()) {
                hideCustomView();
                return true;
            }

            if ((mCustomView == null) && webView.canGoBack()) {
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    class myWebChromeClient extends WebChromeClient {
        private Bitmap mDefaultVideoPoster;
        private View mVideoProgressView;

        @Override
        public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
            onShowCustomView(view, callback);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void onShowCustomView(View view,CustomViewCallback callback) {

            // if a view already exists then immediately terminate the new one
            if (mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            mCustomView = view;
            webView.setVisibility(View.GONE);
            customViewContainer.setVisibility(View.VISIBLE);
            customViewContainer.addView(view);
            customViewCallback = callback;
        }

        @Override
        public View getVideoLoadingProgressView() {

            if (mVideoProgressView == null) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                mVideoProgressView = inflater.inflate(R.layout.video_progress, null);
            }
            return mVideoProgressView;
        }

        @Override
        public void onHideCustomView() {
            super.onHideCustomView();    //To change body of overridden methods use File | Settings | File Templates.
            if (mCustomView == null)
                return;

            webView.setVisibility(View.VISIBLE);
            customViewContainer.setVisibility(View.GONE);

            // Hide the custom view.
            mCustomView.setVisibility(View.GONE);

            // Remove the custom view from its container.
            customViewContainer.removeView(mCustomView);
            customViewCallback.onCustomViewHidden();

            mCustomView = null;
        }
    }

    class myWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            isPageError = false;
            webView.setVisibility(View.GONE);
            imagesrc.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            progressBar.setVisibility(View.VISIBLE);
            load_tv.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            webView.setVisibility(View.VISIBLE);
            load_tv.setVisibility(View.GONE);
            imagesrc.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            if (!isPageError) {
                webView.setVisibility(View.GONE);
                txtError.setVisibility(View.VISIBLE);
                txtError.setText("error message");
            }else {webView.setVisibility(View.VISIBLE);
            txtError.setVisibility(View.GONE);}
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
        {

            isPageError = true;
        }



        };

    }






