package br.com.meopay.listener;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import br.com.meopay.model.CommissionedResponse;
import br.com.meopay.model.CompanyResponse;
import br.com.meopay.service.ApiCallBack;

public class CommissionedResponseListener implements Response.Listener<String>, Response.ErrorListener {

    private Context context;
    private ApiCallBack callBack;

    public CommissionedResponseListener() {}

    public CommissionedResponseListener(Context context) {
        this.context = context;
    }

    public CommissionedResponseListener(Context context, final ApiCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public void onResponse(String response) {
        try {
            if (this.callBack != null) {
                Gson gson = new Gson();
                CommissionedResponse commissionedResponse = gson.fromJson(response, CommissionedResponse.class);
                this.callBack.onSuccessApi(commissionedResponse);
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
