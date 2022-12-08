package br.com.meopay.listener;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import br.com.meopay.model.CompanyData;
import br.com.meopay.model.CompanyResponse;
import br.com.meopay.model.EventResponse;
import br.com.meopay.service.ApiCallBack;

public class EventResponseListener implements Response.Listener<String>, Response.ErrorListener {

    private Context context;
    private ApiCallBack callBack;

    public EventResponseListener() {}

    public EventResponseListener(Context context, final ApiCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public void onResponse(String response) {
        try {
            Gson gson = new Gson();
            EventResponse event = gson.fromJson(response, EventResponse.class);
            if (event.getEvent() != null) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("event_name", event.getEvent().getName());
                editor.apply();
                if (callBack != null) {
                    callBack.onSuccessApi(event);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("ERROR", error.toString());
    }
}
