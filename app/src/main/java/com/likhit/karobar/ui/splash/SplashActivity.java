package com.likhit.karobar.ui.splash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.likhit.karobar.R;
import com.likhit.karobar.base.BaseActivity;
import com.likhit.karobar.databinding.ActivitySplashBinding;
import com.likhit.karobar.ui.home.HomeActivity;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        startTimer();
    }

    private void startTimer() {
        //30 Sec Timer.
        binding.getRoot().postDelayed(new Runnable() {
            @Override
            public void run() {
                launchActivity();
            }
        }, 5000);
    }

    void launchActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        this.startActivity(intent);
    }
}
