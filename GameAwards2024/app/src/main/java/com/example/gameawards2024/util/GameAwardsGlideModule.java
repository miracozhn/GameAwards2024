package com.example.gameawards2024.util;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

@GlideModule
public final class GameAwardsGlideModule extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        // Bellek önbelleği boyutu
        int memoryCacheSizeBytes = 1024 * 1024 * 20; // 20 MB
        builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));
        
        // Disk önbelleği boyutu
        int diskCacheSizeBytes = 1024 * 1024 * 100; // 100 MB
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, diskCacheSizeBytes));
        
        // Varsayılan request options
        builder.setDefaultRequestOptions(new RequestOptions()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .encodeFormat(Bitmap.CompressFormat.JPEG)
                .encodeQuality(90)); // %90 kalite
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
} 