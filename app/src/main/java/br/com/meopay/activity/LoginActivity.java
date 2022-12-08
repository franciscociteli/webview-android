package br.com.meopay.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;

import br.com.meopay.R;
import br.com.meopay.base.MeoPayApp;
import br.com.meopay.databinding.ActivityLoginBinding;
import br.com.meopay.model.CompanyData;
import br.com.meopay.model.CompanyResponse;
import br.com.meopay.service.ApiCallBack;


public class LoginActivity extends AppCompatActivity implements ApiCallBack<CompanyResponse> {

    private ActivityLoginBinding binding;
    private String document;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnLogin.setVisibility(View.GONE);
                binding.textUsrMessage.setVisibility(View.VISIBLE);

                //document = binding.txtDoc.getText().toString();
                finish();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }





    @Override
    public void onSuccessApi(CompanyResponse response) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        CompanyData data = response.getCompany();
        editor.putString("document", data.getDocument());
        editor.putString("split_mode", data.getSplitMode());
        editor.putInt("company_id", data.getId());
        editor.putBoolean("split_enabled", data.getSplitEnabled() == 1 ? true : false);
        editor.putString("operation_type", data.getOperationType());
        editor.apply();








    }

    @Override
    public void onErrorApi(VolleyError error) {
        Toast.makeText(LoginActivity.this, "Falha de comunicação com o servidor", Toast.LENGTH_SHORT).show();
        binding.textUsrMessage.setVisibility(View.GONE);
        binding.btnLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}