package com.example.gameawards2024;

import android.app.Application;

import com.bumptech.glide.Glide;

public class GameAwardsApplication extends Application {
    private static GameAwardsApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Glide.get(this).trimMemory(level);
    }

    public static GameAwardsApplication getInstance() {
        return instance;
    }
} 