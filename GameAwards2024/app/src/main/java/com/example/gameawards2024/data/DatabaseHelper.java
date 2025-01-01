package com.example.gameawards2024.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "games.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_GAMES = "games";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_RATING = "rating";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_IMAGE_URL = "image_url";
    private static final String COLUMN_VIDEO_URL = "video_url";
    private static final String COLUMN_RELEASE_YEAR = "release_year";
    private static final String COLUMN_DEVELOPER = "developer";
    private static final String COLUMN_PUBLISHER = "publisher";
    private static final String COLUMN_PLATFORM = "platform";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GAMES_TABLE = "CREATE TABLE " + TABLE_GAMES + "("
                + COLUMN_ID + " TEXT PRIMARY KEY,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_GENRE + " TEXT,"
                + COLUMN_RATING + " REAL,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_IMAGE_URL + " TEXT,"
                + COLUMN_VIDEO_URL + " TEXT,"
                + COLUMN_RELEASE_YEAR + " TEXT,"
                + COLUMN_DEVELOPER + " TEXT,"
                + COLUMN_PUBLISHER + " TEXT,"
                + COLUMN_PLATFORM + " TEXT"
                + ")";
        db.execSQL(CREATE_GAMES_TABLE);
        
        // Örnek verileri ekle
        insertSampleData(db);
    }

    private void insertSampleData(SQLiteDatabase db) {
        // Baldur's Gate 3
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, "1");
        values.put(COLUMN_TITLE, "Baldur's Gate 3");
        values.put(COLUMN_GENRE, "RPG");
        values.put(COLUMN_RATING, 9.5);
        values.put(COLUMN_DESCRIPTION, "Baldur's Gate 3, Dungeons & Dragons evreninde geçen epik bir rol yapma oyunudur. " +
                "Larian Studios tarafından geliştirilen oyun, D&D 5. Edisyon kurallarını temel alır. " +
                "Zihin emiciler tarafından enfekte edilmiş bir karakteri yönettiğiniz oyunda, kaderinizi belirleyecek seçimler yaparak " +
                "Forgotten Realms'in kaderi üzerinde etkili olacaksınız. Oyun, derin karakter özelleştirme sistemi, " +
                "taktiksel sıra tabanlı dövüş mekanikleri ve etkileyici hikaye anlatımıyla dikkat çeker. " +
                "Tek başınıza ya da 4 kişiye kadar çok oyunculu modda oynayabilirsiniz. " +
                "2023 Game Awards'da Yılın Oyunu dahil olmak üzere 6 ödül kazanmıştır.");
        values.put(COLUMN_IMAGE_URL, "https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg");
        values.put(COLUMN_VIDEO_URL, "https://www.youtube.com/watch?v=1T22wNvoNiU");
        values.put(COLUMN_RELEASE_YEAR, "2023");
        values.put(COLUMN_DEVELOPER, "Larian Studios");
        values.put(COLUMN_PUBLISHER, "Larian Studios");
        values.put(COLUMN_PLATFORM, "PC, PS5");
        db.insert(TABLE_GAMES, null, values);

        // Marvel's Spider-Man 2
        values = new ContentValues();
        values.put(COLUMN_ID, "2");
        values.put(COLUMN_TITLE, "Marvel's Spider-Man 2");
        values.put(COLUMN_GENRE, "Action-Adventure");
        values.put(COLUMN_RATING, 9.0);
        values.put(COLUMN_DESCRIPTION, "Marvel's Spider-Man 2, Peter Parker ve Miles Morales'in maceralarını konu alan aksiyon-macera oyunudur. " +
                "Insomniac Games tarafından geliştirilen oyun, önceki Spider-Man oyunlarının devamı niteliğindedir. " +
                "İki Spider-Man'in güçlerini kullanarak New York'u kurtarmaya çalışacaksınız. Oyunda Venom, Kraven the Hunter ve " +
                "diğer klasik Spider-Man kötüleriyle karşılaşacaksınız. Geliştirilmiş savaş mekanikleri, yeni kostümler ve " +
                "sempatik ağ atma sistemiyle New York şehrini keşfedebilirsiniz. Oyun, etkileyici grafikleri ve " +
                "sinematik hikaye anlatımıyla PS5'in gücünü tam anlamıyla kullanıyor.");
        values.put(COLUMN_IMAGE_URL, "https://cdn.akamai.steamstatic.com/steam/apps/1817070/header.jpg");
        values.put(COLUMN_VIDEO_URL, "https://www.youtube.com/watch?v=9fVYKsEmuRo");
        values.put(COLUMN_RELEASE_YEAR, "2023");
        values.put(COLUMN_DEVELOPER, "Insomniac Games");
        values.put(COLUMN_PUBLISHER, "Sony Interactive Entertainment");
        values.put(COLUMN_PLATFORM, "PS5");
        db.insert(TABLE_GAMES, null, values);

        // The Legend of Zelda: Tears of the Kingdom
        values = new ContentValues();
        values.put(COLUMN_ID, "3");
        values.put(COLUMN_TITLE, "The Legend of Zelda: Tears of the Kingdom");
        values.put(COLUMN_GENRE, "Action-Adventure");
        values.put(COLUMN_RATING, 9.6);
        values.put(COLUMN_DESCRIPTION, "The Legend of Zelda: Tears of the Kingdom, efsanevi Zelda serisinin en yeni oyunudur. " +
                "Breath of the Wild'ın devamı niteliğindeki oyunda, Link olarak Hyrule'un gökyüzünde ve yeraltında yeni maceralar yaşayacaksınız. " +
                "Nintendo'nun geliştirdiği oyun, yepyeni yaratıcılık mekanikleri sunuyor. Ultrahand yeteneği ile nesneleri birleştirip " +
                "kendi araçlarınızı yapabilir, Fuse yeteneği ile silahlarınızı güçlendirebilir ve Recall yeteneği ile zamanı manipüle edebilirsiniz. " +
                "Devasa açık dünyası, bulmacaları ve özgür oynanış stiliyle oyunculara benzersiz bir deneyim sunuyor. " +
                "2023'ün en çok satan Nintendo Switch oyunlarından biri olmuştur.");
        values.put(COLUMN_IMAGE_URL, "https://cdn.akamai.steamstatic.com/steam/apps/1549970/header.jpg");
        values.put(COLUMN_VIDEO_URL, "https://www.youtube.com/watch?v=uHGShqcAHlQ");
        values.put(COLUMN_RELEASE_YEAR, "2023");
        values.put(COLUMN_DEVELOPER, "Nintendo");
        values.put(COLUMN_PUBLISHER, "Nintendo");
        values.put(COLUMN_PLATFORM, "Nintendo Switch");
        db.insert(TABLE_GAMES, null, values);

        // Resident Evil 4
        values = new ContentValues();
        values.put(COLUMN_ID, "4");
        values.put(COLUMN_TITLE, "Resident Evil 4");
        values.put(COLUMN_GENRE, "Survival Horror");
        values.put(COLUMN_RATING, 9.3);
        values.put(COLUMN_DESCRIPTION, "Resident Evil 4, 2005 yılında çıkan klasik korku-aksiyon oyununun modern bir yeniden yapımıdır. " +
                "Capcom tarafından geliştirilen oyun, orijinalin atmosferini korurken modern oyun mekaniklerini başarıyla entegre ediyor. " +
                "Leon S. Kennedy olarak başkanın kızını kurtarmak için İspanya'nın kırsal bölgelerinde tehlikeli bir maceraya atılacaksınız. " +
                "Las Plagas virüsünün etkisi altındaki köylüler, tehlikeli yaratıklar ve gizemli kült üyeleriyle mücadele edeceksiniz. " +
                "Geliştirilmiş grafikleri, yeniden tasarlanan dövüş sistemi ve genişletilmiş hikayesiyle hem eski hayranları hem de " +
                "yeni oyuncuları memnun etmeyi başarmıştır. Oyun, birçok 'Yılın En İyi Yeniden Yapımı' ödülü kazanmıştır.");
        values.put(COLUMN_IMAGE_URL, "https://cdn.akamai.steamstatic.com/steam/apps/2050650/header.jpg");
        values.put(COLUMN_VIDEO_URL, "https://www.youtube.com/watch?v=j5Xv2lM9wes");
        values.put(COLUMN_RELEASE_YEAR, "2023");
        values.put(COLUMN_DEVELOPER, "Capcom");
        values.put(COLUMN_PUBLISHER, "Capcom");
        values.put(COLUMN_PLATFORM, "PC, PS4, PS5, Xbox Series X/S");
        db.insert(TABLE_GAMES, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAMES);
        onCreate(db);
    }

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {
            COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_RATING,
            COLUMN_DESCRIPTION, COLUMN_IMAGE_URL, COLUMN_VIDEO_URL,
            COLUMN_RELEASE_YEAR, COLUMN_DEVELOPER, COLUMN_PUBLISHER, COLUMN_PLATFORM
        };

        Cursor cursor = db.query(TABLE_GAMES, columns, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Game game = new Game(
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENRE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_RATING)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_URL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_VIDEO_URL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RELEASE_YEAR)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DEVELOPER)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PUBLISHER)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLATFORM))
                );
                games.add(game);
            } while (cursor.moveToNext());
        }
        
        cursor.close();
        return games;
    }

    public Game getGameById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Game game = null;

        try {
            String[] columns = {
                COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_RATING,
                COLUMN_DESCRIPTION, COLUMN_IMAGE_URL, COLUMN_VIDEO_URL,
                COLUMN_RELEASE_YEAR, COLUMN_DEVELOPER, COLUMN_PUBLISHER, COLUMN_PLATFORM
            };

            String selection = COLUMN_ID + " = ?";
            String[] selectionArgs = { id };

            Cursor cursor = db.query(TABLE_GAMES, columns, selection, selectionArgs, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                game = new Game(
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENRE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_RATING)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_URL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_VIDEO_URL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RELEASE_YEAR)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DEVELOPER)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PUBLISHER)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLATFORM))
                );
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return game;
    }
} 