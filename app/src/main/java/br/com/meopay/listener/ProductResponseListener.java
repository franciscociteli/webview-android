package br.com.meopay.listener;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import br.com.meopay.model.CompanyResponse;
import br.com.meopay.model.ProductData;
import br.com.meopay.service.ApiCallBack;

public class ProductResponseListener implements Response.Listener<String>, Response.ErrorListener {

    private Context context;
    private ApiCallBack callBack;

    public ProductResponseListener() {}

    public ProductResponseListener(Context context, final ApiCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public void onResponse(String response) {
        try {
            Gson gson = new Gson();
            ProductData company = gson.fromJson(response, ProductData.class);
            callBack.onSuccessApi(company);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("ERROR", error.toString());
        if (callBack != null) {
            callBack.onErrorApi(error);
        }
    }
}
