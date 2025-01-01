package com.example.gameawards2024.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GameDatabaseHelper extends SQLiteOpenHelper {
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

    public GameDatabaseHelper(Context context) {
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAMES);
        onCreate(db);
    }

    public void insertGame(Game game) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, game.getId());
        values.put(COLUMN_TITLE, game.getTitle());
        values.put(COLUMN_GENRE, game.getGenre());
        values.put(COLUMN_RATING, game.getRating());
        values.put(COLUMN_DESCRIPTION, game.getDescription());
        values.put(COLUMN_IMAGE_URL, game.getImageUrl());
        values.put(COLUMN_VIDEO_URL, game.getVideoUrl());
        values.put(COLUMN_RELEASE_YEAR, game.getReleaseYear());
        values.put(COLUMN_DEVELOPER, game.getDeveloper());
        values.put(COLUMN_PUBLISHER, game.getPublisher());
        values.put(COLUMN_PLATFORM, game.getPlatform());

        db.insert(TABLE_GAMES, null, values);
        db.close();
    }

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_GAMES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

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
        db.close();
        return games;
    }

    public Game getGameById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_GAMES, null,
                COLUMN_ID + "=?", new String[]{id},
                null, null, null);

        Game game = null;
        if (cursor.moveToFirst()) {
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
        }

        cursor.close();
        db.close();
        return game;
    }
} 