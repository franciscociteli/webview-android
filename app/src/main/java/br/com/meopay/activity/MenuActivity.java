package br.com.meopay.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.internal.ManufacturerUtils;

import br.com.meopay.R;
import br.com.meopay.databinding.ActivityMainBinding;
import br.com.meopay.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActivityMenuBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        binding.btnTransaction.setOnClickListener(this);
        binding.btnSplit.setOnClickListener(this);
        binding.btnBackMenu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_transaction:
               // startActivity(new Intent(MenuActivity.this, AmountActivity.class));
                break;
            case R.id.btn_split:
               // Intent intent = new Intent(MenuActivity.this, CommissionedAcivity.class);
               // intent.putExtra("split", true);
               // startActivity(intent);
                break;
            case R.id.btn_back_menu:
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}