package br.com.meopay.adapter;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.meopay.callback.WebViewCallBack;

public class WebAppInterface {

    Context mContext;
    WebViewCallBack callBack;

    public WebAppInterface(Context c, WebViewCallBack callBack) {
        mContext = c;
        this.callBack = callBack;
    }

    @JavascriptInterface
    public void confirmContract(String product) throws JSONException {
        JSONObject jObject = new JSONObject(product);
        new AlertDialog.Builder(this.mContext)
                .setTitle("Confirmação")
                .setMessage("Produto contratado com sucesso.")
                .setPositiveButton(android.R.string.ok, null)
                .create()
                .show();
        //this.callBack.onCallBack();
        //Toast.makeText(mContext, "Produto  contratado com sucesso", Toast.LENGTH_SHORT).show();
    }
}
