package com.example.gameawards2024.data;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    private static GameRepository instance;
    private final List<Game> games;

    private GameRepository() {
        games = new ArrayList<>();
        initializeGames();
    }

    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
        }
        return instance;
    }

    private void initializeGames() {
        games.add(new Game(
            "1",
            "Baldur's Gate 3",
            "RPG",
            9.5,
            "Baldur's Gate 3, Dungeons & Dragons evreninde geçen bir rol yapma oyunudur.",
            "https://cdn1.epicgames.com/offer/d5241c76f178492ea1540fce45616757/EGS_BaldursGate3_LarianStudios_S1_2560x1440-535f36a3e26ede115b42c0a5bae73147",
            "https://www.youtube.com/watch?v=1T22wNvoNiU",
            "2023",
            "Larian Studios",
            "Larian Studios",
            "PC, PS5"
        ));

        games.add(new Game(
            "2",
            "Marvel's Spider-Man 2",
            "Action-Adventure",
            9.2,
            "Marvel's Spider-Man 2, Insomniac Games tarafından geliştirilen bir aksiyon-macera oyunudur.",
            "https://gmedia.playstation.com/is/image/SIEPDC/spiderman-2-hero-banner-desktop-01-en-07sep23",
            "https://www.youtube.com/watch?v=nq1M_Wc4FIc",
            "2023",
            "Insomniac Games",
            "Sony Interactive Entertainment",
            "PS5"
        ));

        games.add(new Game(
            "3",
            "The Legend of Zelda: Tears of the Kingdom",
            "Action-Adventure",
            9.7,
            "The Legend of Zelda: Tears of the Kingdom, Nintendo tarafından geliştirilen bir aksiyon-macera oyunudur.",
            "https://www.nintendo.com/ph/wallpaper/zelda-totk/img/wallpaper8_1920x1080.jpg",
            "https://www.youtube.com/watch?v=uHGShqcAHlQ",
            "2023",
            "Nintendo",
            "Nintendo",
            "Nintendo Switch"
        ));

        games.add(new Game(
            "4",
            "Resident Evil 4",
            "Survival Horror",
            9.3,
            "Resident Evil 4, Capcom tarafından geliştirilen bir survival horror oyunudur.",
            "https://gmedia.playstation.com/is/image/SIEPDC/resident-evil-4-hero-banner-desktop-01-ps4-ps5-en-21mar23",
            "https://www.youtube.com/watch?v=j5Xv2lM9wes",
            "2023",
            "Capcom",
            "Capcom",
            "PC, PS5, Xbox Series X/S"
        ));
    }

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }

    public Game getGameById(String id) {
        for (Game game : games) {
            if (game.getId().equals(id)) {
                return game;
            }
        }
        return null;
    }
} 