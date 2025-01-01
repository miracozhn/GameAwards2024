package com.example.gameawards2024.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameawards2024.MainActivity;
import com.example.gameawards2024.R;
import com.example.gameawards2024.data.DatabaseHelper;
import com.example.gameawards2024.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {
    private ImageView logoImageView;
    private TextView networkStatusText;
    private DatabaseHelper databaseHelper;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isCheckingConnection = true;
    private final int CHECK_INTERVAL = 1000; // Her 1 saniyede bir kontrol et

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initializeViews();
        startLogoAnimation();
        startConnectionCheck();
    }

    private void initializeViews() {
        logoImageView = findViewById(R.id.logoImageView);
        networkStatusText = findViewById(R.id.networkStatusText);
        databaseHelper = new DatabaseHelper(this);
    }

    private void startLogoAnimation() {
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(logoImageView, View.ROTATION, 0f, 360f);
        rotationAnimator.setDuration(2000);
        rotationAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        rotationAnimator.setInterpolator(new LinearInterpolator());
        rotationAnimator.start();
    }

    private void startConnectionCheck() {
        isCheckingConnection = true;
        checkInternetConnection();
    }

    private void checkInternetConnection() {
        if (!isCheckingConnection) return;

        boolean isConnected = NetworkUtil.isNetworkAvailable(this);
        networkStatusText.setVisibility(View.VISIBLE);
        
        if (!isConnected) {
            networkStatusText.setText("İnternet Bağlantısı Bekleniyor...");
            networkStatusText.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            
            // Tekrar kontrol et
            handler.postDelayed(this::checkInternetConnection, CHECK_INTERVAL);
        } else {
            networkStatusText.setText("İnternete Bağlandı");
            networkStatusText.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            isCheckingConnection = false;
            
            handler.postDelayed(() -> {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }, 2000); // Bağlantı sağlandıktan 2 saniye sonra geç
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isCheckingConnection = false;
        if (databaseHelper != null) {
            databaseHelper.close();
        }
        handler.removeCallbacksAndMessages(null);
    }
} 