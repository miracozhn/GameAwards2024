package com.example.gameawards2024.ui.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.gameawards2024.R;
import com.example.gameawards2024.data.Game;
import com.example.gameawards2024.ui.GameDetailsActivity;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {
    private final List<Game> games;
    private final LayoutInflater inflater;

    public GameAdapter(android.content.Context context, List<Game> games) {
        this.inflater = LayoutInflater.from(context);
        this.games = games;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GameViewHolder(inflater.inflate(R.layout.item_game, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        holder.bind(games.get(position));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    class GameViewHolder extends RecyclerView.ViewHolder {
        private ImageView gameImage;
        private TextView titleView;
        private TextView genreView;
        private TextView ratingView;
        private TextView developerView;
        private TextView publisherView;
        private TextView platformView;
        private TextView releaseYearView;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage = itemView.findViewById(R.id.gameImage);
            titleView = itemView.findViewById(R.id.gameTitle);
            genreView = itemView.findViewById(R.id.gameGenre);
            ratingView = itemView.findViewById(R.id.gameRating);
            developerView = itemView.findViewById(R.id.gameDeveloper);
            publisherView = itemView.findViewById(R.id.gamePublisher);
            platformView = itemView.findViewById(R.id.gamePlatform);
            releaseYearView = itemView.findViewById(R.id.gameReleaseYear);
        }

        public void bind(Game game) {
            titleView.setText(game.getTitle());
            genreView.setText("Tür: " + game.getGenre());
            ratingView.setText(String.format("Puan: %.1f/10", game.getRating()));
            developerView.setText("Geliştirici: " + game.getDeveloper());
            publisherView.setText("Yayıncı: " + game.getPublisher());
            platformView.setText("Platform: " + game.getPlatform());
            releaseYearView.setText("Çıkış Yılı: " + game.getReleaseYear());

            Glide.with(itemView.getContext())
                    .load(game.getImageUrl())
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(gameImage);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), GameDetailsActivity.class);
                intent.putExtra("game_id", game.getId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
} 