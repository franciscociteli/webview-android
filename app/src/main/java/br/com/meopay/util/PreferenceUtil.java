package br.com.meopay.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtil {

    public static final String  ENVIRONMENT_HML = "https://52.168.167.13";
    //public static final String ENVIRONMENT_HML = "";
    public static final String OPTION_CREDIT = "Crédito";
    public static final String OPTION_DEBIT = "Débito";

    //tipos de reimpressao de transacao
    public static final String REPRINT_OPTION_MERCHANT = "merchant";
    public static final String REPRINT_OPTION_CLIENT = "client";
    public static final String REPRINT_OPTION_SMS_CLIENT = "sms";

    //tipos de reimpressao de cancelamento
    public static final String REPRINT_OPTION_CANCEL_MERCHANT = "reprint_cancel_merchant";
    public static final String REPRINT_OPTION_CANCEL_CLIENT = "reprint_cancel_client";

    public static final String PRINT_MSG_ERROR = "Erro na impressão de comprovante";

    //tipos de split
    public static final String COMMISSIONED_PERCENT = "percent";
    public static final String COMMISSIONED_VALUE = "amount";

    //tipos de operacao de pagamento
    public static final String OPERATION_PAYMENT_CODE = "payment_code";
    public static final String OPERATION_TEF = "tef";
    public static final String OPERATION_FULL = "full";
    public static final String OPERATION_PAYMENT_USER = "payment_user";
    public static final String PRE_PAID = "pre_paid";

    public static final String DEFAULT_PASSWORD = "999";

    public static String getDocument(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String document = preferences.getString("document", "");
        if (document != null && !document.equalsIgnoreCase("")) {
            return document;
        }

        return null;
    }

    public static String getEventName(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String eventName = preferences.getString("event_name", "");
        if (eventName != null && !eventName.equalsIgnoreCase("")) {
            return eventName;
        }

        return null;
    }

    public static Integer getCompanyId(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Integer companyId = preferences.getInt("company_id", 0);
        if (companyId != null) {
            return companyId;
        }

        return null;
    }

    public static String getSplitMode(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String document = preferences.getString("split_mode", "");
        return document;
    }

    public static Boolean getSplitEnabled(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return true;
        //return preferences.getBoolean("split_enabled", false);
    }

    public static String getOperationType(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("operation_type", "");
    }

    public static Boolean hasOperartionType(Context context, String operationType) {
        String operation = getOperationType(context);
        String[] operations = operation.split(",");
        for (String op : operations) {
            if (op.equalsIgnoreCase(operationType)) {
                return true;
            }
        }
        return false;
    }

    public static void resetPreferences(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("document", null);
        editor.putInt("company_id", 0);
        editor.putString("operation_type", null);
        editor.putBoolean("split_enabled", false);
        editor.putString("split_mode", null);
        editor.putString("event_name", null);
        editor.apply();
    }

    public static String translateTransactionOption(String option) {
        if (option.equalsIgnoreCase("credit")) {
            return OPTION_CREDIT;
        }

        if (option.equalsIgnoreCase("debit")) {
            return OPTION_DEBIT;
        }

        return null;
    }
}
