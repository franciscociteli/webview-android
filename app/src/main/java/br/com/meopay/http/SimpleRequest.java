package br.com.meopay.http;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleRequest extends StringRequest {

    private Map<String, String> headers;
    private Map<String, String> parameters;

    public SimpleRequest(int method, String url,
                         Response.Listener<String> listener,
                         @Nullable @org.jetbrains.annotations.Nullable Response.ErrorListener errorListener,
                         Map<String, String> headers) {
        super(method, url, listener, errorListener);
        this.headers = headers;
    }

    public SimpleRequest(int method, String url,
                         Response.Listener<String> listener,
                         @Nullable @org.jetbrains.annotations.Nullable Response.ErrorListener errorListener,
                         Map<String, String> headers, Map<String, String> parameters) {
        super(method, url, listener, errorListener);
        this.headers = headers;
        this.parameters = parameters;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected Map<String,String> getParams() throws AuthFailureError {
        return this.parameters != null ? this.parameters : super.getParams();
    }
}