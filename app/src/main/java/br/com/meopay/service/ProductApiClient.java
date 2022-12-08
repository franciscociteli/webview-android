package br.com.meopay.service;

import android.content.Context;

import br.com.meopay.listener.CompanyResponseListener;
import br.com.meopay.listener.ProductResponseListener;
import br.com.meopay.util.ApiUtils;

public class ProductApiClient {

    private static ProductApiClient instance;

    private ProductApiClient() {}

    public static synchronized ProductApiClient getInstance() {
        if (instance == null) {
            instance = new ProductApiClient();
        }

        return instance;
    }

    public void findByKey(Context context, String productKey, ApiCallBack callBack) {
        ProductResponseListener listener = new ProductResponseListener(context, callBack);
        ApiUtils.get(context,"find_by_key/" + productKey, listener, listener);
    }
}
