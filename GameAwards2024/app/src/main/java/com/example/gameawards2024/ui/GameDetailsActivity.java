package com.example.gameawards2024.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.gameawards2024.R;
import com.example.gameawards2024.data.DatabaseHelper;
import com.example.gameawards2024.data.Game;

public class GameDetailsActivity extends AppCompatActivity {
    private static final String EXTRA_GAME_ID = "game_id";
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        databaseHelper = new DatabaseHelper(this);
        String gameId = getIntent().getStringExtra(EXTRA_GAME_ID);
        
        if (gameId != null) {
            Game game = databaseHelper.getGameById(gameId);
            if (game != null) {
                displayGameDetails(game);
            } else {
                Toast.makeText(this, "Oyun bilgileri yüklenemedi! ID: " + gameId, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Oyun ID'si bulunamadı!", Toast.LENGTH_LONG).show();
        }
    }

    private void displayGameDetails(Game game) {
        if (game != null) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(game.getTitle());
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFA500")));
            }

            TextView titleView = findViewById(R.id.gameDetailTitle);
            TextView genreView = findViewById(R.id.gameDetailGenre);
            TextView ratingView = findViewById(R.id.gameDetailRating);
            TextView releaseYearView = findViewById(R.id.gameDetailReleaseYear);
            TextView developerView = findViewById(R.id.gameDetailDeveloper);
            TextView publisherView = findViewById(R.id.gameDetailPublisher);
            TextView platformView = findViewById(R.id.gameDetailPlatform);
            TextView descriptionView = findViewById(R.id.gameDetailDescription);
            ImageView imageView = findViewById(R.id.gameDetailImage);
            WebView webView = findViewById(R.id.gameVideoView);

            titleView.setText(game.getTitle());
            genreView.setText("Tür: " + game.getGenre());
            ratingView.setText(String.format("Puan: %.1f/10", game.getRating()));
            releaseYearView.setText("Çıkış Yılı: " + game.getReleaseYear());
            developerView.setText("Geliştirici: " + game.getDeveloper());
            publisherView.setText("Yayıncı: " + game.getPublisher());
            platformView.setText("Platform: " + game.getPlatform());
            descriptionView.setText("\nOyun Açıklaması:\n\n" + game.getDescription());

            Glide.with(this)
                    .load(game.getImageUrl())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);

            setupWebView(webView, game.getVideoUrl());

            Log.d("GameDetails", "Game ID: " + game.getId());
            Log.d("GameDetails", "Title: " + game.getTitle());
            Log.d("GameDetails", "Genre: " + game.getGenre());
            Log.d("GameDetails", "Rating: " + game.getRating());
            Log.d("GameDetails", "Developer: " + game.getDeveloper());
            Log.d("GameDetails", "Publisher: " + game.getPublisher());
            Log.d("GameDetails", "Platform: " + game.getPlatform());
        } else {
            Toast.makeText(this, "Oyun bilgileri bulunamadı!", Toast.LENGTH_LONG).show();
        }
    }

    private void setupWebView(WebView webView, String videoUrl) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        String videoId = extractYouTubeVideoId(videoUrl);
        if (videoId != null && !videoId.isEmpty()) {
            String embedHtml = String.format(
                    "<html><body style='margin:0;padding:0;'>" +
                    "<iframe width='100%%' height='100%%' src='https://www.youtube.com/embed/%s' " +
                    "frameborder='0' allowfullscreen></iframe></body></html>",
                    videoId);
            webView.loadData(embedHtml, "text/html", "utf-8");
        }
    }

    private String extractYouTubeVideoId(String videoUrl) {
        if (videoUrl != null && videoUrl.contains("v=")) {
            String[] parts = videoUrl.split("v=");
            if (parts.length > 1) {
                String videoId = parts[1];
                int ampersandIndex = videoId.indexOf('&');
                return ampersandIndex != -1 ? videoId.substring(0, ampersandIndex) : videoId;
            }
        }
        return null;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
} 