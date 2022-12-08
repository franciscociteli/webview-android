package br.com.meopay.service;

import android.content.Context;

import br.com.meopay.listener.CompanyResponseListener;
import br.com.meopay.util.ApiUtils;

public class CompanyApiClient {

    private static CompanyApiClient instance;

    private CompanyApiClient() {}

    public static synchronized CompanyApiClient getInstance() {
        if (instance == null) {
            instance = new CompanyApiClient();
        }

        return instance;
    }

    public void storeCompanyByDocument(Context context, String document, ApiCallBack callBack) {
        CompanyResponseListener listener = new CompanyResponseListener(context, callBack);
        ApiUtils.get(context,"companies/" + document + "/find_by_document", listener, listener);
    }
}
