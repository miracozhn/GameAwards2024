package com.example.gameawards2024;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gameawards2024.data.DatabaseHelper;
import com.example.gameawards2024.data.Game;
import com.example.gameawards2024.ui.adapters.GameAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Veritabanını sıfırla ve yeniden oluştur
        getApplicationContext().deleteDatabase("games.db");
        databaseHelper = new DatabaseHelper(this);
        
        setupRecyclerView();
        loadGames();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.gamesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadGames() {
        List<Game> games = databaseHelper.getAllGames();
        if (games.isEmpty()) {
            Toast.makeText(this, "Oyun listesi yüklenemedi!", Toast.LENGTH_SHORT).show();
        } else {
            GameAdapter adapter = new GameAdapter(this, games);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
} 