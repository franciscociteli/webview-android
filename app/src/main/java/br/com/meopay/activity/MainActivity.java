package br.com.meopay.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.volley.VolleyError;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import br.com.meopay.R;
import br.com.meopay.adapter.WebAppInterface;
import br.com.meopay.callback.WebViewCallBack;
import br.com.meopay.databinding.ActivityMainBinding;
import br.com.meopay.model.ProductData;
import br.com.meopay.service.ApiCallBack;
import br.com.meopay.service.ProductApiClient;
import br.com.meopay.util.PreferenceUtil;
import br.com.meopay.util.TransactionToken;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ApiCallBack, WebViewCallBack {

    private WebView myWebView;
    private String url;

    private static final String DEFAULT_URL = "http://192.168.18.34:8080/home";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnManualPayment.setOnClickListener(this);

//        binding.btnOptions.setOnClickListener(this);
        //binding.btnSaleCommision.setOnClickListener(this);
//        binding.btnManualPayment.setOnClickListener(this);
 //       binding.btnSale.setOnClickListener(this);

       /* if (PreferenceUtil.getOperationType(this) == PreferenceUtil.OPERATION_TEF) {
            binding.btnManualPayment.setVisibility(View.GONE);
            //binding.btnSaleCommision.setVisibility(View.GONE);
        }*/

        //IntentFilter filter = new IntentFilter();
        //filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //registerReceiver(broadcastReceiver, filter);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            Log.e("CONNECTION", "hasconnection:" + (netInfo != null && netInfo.isConnected()));
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_manual_payment:
                //finish();
                //startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                //showBottomSheetDialog();
                this.showBottomSheetDialog();
                //ProductApiClient.getInstance().findByKey(MainActivity.this, "WALLET_INSURANCE", this);
                break;
        }
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.webview_dialog_layout);

        final View bottomSheet = bottomSheetDialog.findViewById(R.id.bottomSheet);
        final ViewGroup.LayoutParams childLayoutParams = bottomSheet.getLayoutParams();
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        childLayoutParams.height = displayMetrics.heightPixels;

        bottomSheet.setLayoutParams(childLayoutParams);

        myWebView = (WebView) bottomSheetDialog.findViewById(R.id.webviewDialog);
        // setContentView(myWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebView.addJavascriptInterface(new WebAppInterface(this, this), "Android");

        

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            myWebView.setWebContentsDebuggingEnabled(true);
        }

        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(DEFAULT_URL);
        bottomSheetDialog.show();
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
    public void onSuccessApi(Object response) {
        this.url = ((ProductData) response).getUrl() != null ? ((ProductData) response).getUrl() : DEFAULT_URL;
        this.showBottomSheetDialog();
    }

    @Override
    public void onErrorApi(VolleyError error) {
        this.url = DEFAULT_URL;
        this.showBottomSheetDialog();
    }

    private String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    @Override
    public void onCallBack() {
        String strDevice = this.getDeviceName();
        myWebView.post(new Runnable() {
            public void run() {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    myWebView.evaluateJavascript("showDeviceName('" + strDevice + "');", null);
                } else {
                    myWebView.loadUrl("showDeviceName('" + strDevice + "')");
                }
            }
        });

    }
}
