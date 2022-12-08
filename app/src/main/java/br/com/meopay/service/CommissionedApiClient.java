package br.com.meopay.service;

import android.content.Context;

import br.com.meopay.listener.CommissionedResponseListener;
import br.com.meopay.util.ApiUtils;

public class CommissionedApiClient {

    private static CommissionedApiClient instance;

    private CommissionedApiClient() {}

    public static synchronized CommissionedApiClient getInstance() {
        if (instance == null) {
            instance = new CommissionedApiClient();
        }

        return instance;
    }

    public void findByCompany(Context context, Integer companyId, final ApiCallBack callBack) {
        CommissionedResponseListener listener = new CommissionedResponseListener(context, callBack);
        ApiUtils.get(context,"commissioneds/" + companyId + "/find_by_company", listener, listener);
    }

}
