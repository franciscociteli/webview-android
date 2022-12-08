package br.com.meopay.service;

import com.android.volley.VolleyError;

public interface ApiCallBack<T> {
    void onSuccessApi(T response);
    void onErrorApi(VolleyError error);
}
