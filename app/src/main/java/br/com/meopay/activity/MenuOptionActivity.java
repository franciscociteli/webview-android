package br.com.meopay.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.meopay.util.PreferenceUtil;
import br.com.meopay.R;
import br.com.meopay.databinding.ActivityMenuOptionBinding;

public class MenuOptionActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMenuOptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_option);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu_option);
        binding.btnCancellation.setOnClickListener(this);
        binding.btnReprint.setOnClickListener(this);
        binding.btnUpdaeProducts.setOnClickListener(this);
        binding.btnBackOption.setOnClickListener(this);
        binding.btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancellation:
                //startActivity(new Intent(MenuOptionActivity.this, CancellationActivity.class));
                break;
            case R.id.btn_reprint:
                //startActivity(new Intent(MenuOptionActivity.this, ReprintOptionsActivity.class));
                break;
            case R.id.btn_updae_products:
                updateProducts(this);
                break;
            case R.id.btn_back_option:
                startActivity(new Intent(MenuOptionActivity.this, MainActivity.class));
                break;
            case R.id.btn_exit:
                PreferenceUtil.resetPreferences(MenuOptionActivity.this);
                startActivity(new Intent(MenuOptionActivity.this, LoginActivity.class));
                break;
        }
    }

    private void updateProducts(final AppCompatActivity context) {
        binding.btnBackOption.setVisibility(View.GONE);
        binding.btnCancellation.setVisibility(View.GONE);
        binding.btnReprint.setVisibility(View.GONE);
        binding.btnUpdaeProducts.setVisibility(View.GONE);
        binding.btnExit.setVisibility(View.GONE);
        binding.txtOption.setText("Atualizando produtos...");

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}