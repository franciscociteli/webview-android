package br.com.meopay.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import br.com.meopay.R;
import br.com.meopay.databinding.ActivityInitializationBinding;



public class InitializationActivity extends AppCompatActivity {
    private ActivityInitializationBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_initialization);
        finish();
        startActivity(new Intent(InitializationActivity.this, LoginActivity.class));
        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String document = preferences.getString("document", "");
        if (document != null && !document.equalsIgnoreCase("")) {
            initialize(document);
        } else {
            finish();
            startActivity(new Intent(InitializationActivity.this, LoginActivity.class));
        }*/

    }





    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
