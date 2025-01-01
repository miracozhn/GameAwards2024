package com.example.gameawards2024.data;

public class Game {
    private String id;
    private String title;
    private String genre;
    private double rating;
    private String description;
    private String imageUrl;
    private String videoUrl;
    private String releaseYear;
    private String developer;
    private String publisher;
    private String platform;

    public Game(String id, String title, String genre, double rating, String description,
                String imageUrl, String videoUrl, String releaseYear, String developer,
                String publisher, String platform) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.releaseYear = releaseYear;
        this.developer = developer;
        this.publisher = publisher;
        this.platform = platform;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPlatform() {
        return platform;
    }
} 