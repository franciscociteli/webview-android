package br.com.meopay.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import br.com.meopay.http.SimpleRequest;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;


import cz.msebera.android.httpclient.conn.scheme.Scheme;

public class ApiUtils {
    //private static final String BASE_URL = "https://api.meopay.com.br";
    private static final String BASE_URL = "http://43b4-2804-5f0c-11ef-800-f12e-410d-7990-34a0.ngrok.io";
    //private static final String BASE_URL = "http://61cf-2804-5f0c-11be-b500-8ca7-4da0-6859-cd8.ngrok.io";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void post(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void get(Context context, String url, Response.Listener responseListener, Response.ErrorListener errorListener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        SimpleRequest stringRequest = new SimpleRequest(Request.Method.GET, getAbsoluteUrl(url), responseListener, errorListener, getHeader());
        queue.add(stringRequest);

    }

    public static void post(Context context, String url, Map<String, String> params, Response.Listener responseListener, Response.ErrorListener errorListener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        SimpleRequest stringRequest = new SimpleRequest(Request.Method.POST, getAbsoluteUrl(url), responseListener, errorListener, getHeader(), params);
        queue.add(stringRequest);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + "/" + relativeUrl;
    }

    private static Map<String, String> getHeader() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-access-token", "wnK3151CUa");
        return headers;
    }

}
