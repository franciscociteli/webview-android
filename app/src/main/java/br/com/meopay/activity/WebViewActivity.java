package br.com.meopay.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import br.com.meopay.R;
import br.com.meopay.adapter.WebAppInterface;
import br.com.meopay.databinding.ActivityLoginBinding;
import br.com.meopay.databinding.ActivityWebViewBinding;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityWebViewBinding binding;
    private WebView myWebView;
    private static final String URL_PAGE = "http://504b-2804-5f0c-1124-a400-3ce7-762d-73a-e925.ngrok.io/home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_view);
        //setContentView(R.layout.activity_web_view);
        //binding.btnBackWebView.setOnClickListener(this);

        myWebView = (WebView) findViewById(R.id.webview);
       // setContentView(myWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebView.addJavascriptInterface(new WebAppInterface(this, null), "Android");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            myWebView.setWebContentsDebuggingEnabled(true);
        }

        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl(URL_PAGE);
        //myWebView.loadUrl("https://www.google.com");
        //setContentView(myWebView);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @JavascriptInterface
    public void jsShowToast(String toast) {
        new AlertDialog.Builder(this)
                .setTitle("Dialog")
                .setMessage(toast)
                .setPositiveButton(android.R.string.ok, null)
                .create()
                .show();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_web_view:
                finish();
                startActivity(new Intent(WebViewActivity.this, MainActivity.class));
                break;
        }
    }
}