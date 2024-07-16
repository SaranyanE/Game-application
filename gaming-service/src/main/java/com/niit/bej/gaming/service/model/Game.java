package com.niit.bej.gaming.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

public class Game {
    @MongoId
    private int id;
    private String title;
    private String genre;
    private String releaseYear;
    private double rating;

    public Game() {
    }

    public Game(int id, String title, String genre, String releaseYear, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && Double.compare(game.rating, rating) == 0 && Objects.equals(title, game.title) && Objects.equals(genre, game.genre) && Objects.equals(releaseYear, game.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, releaseYear, rating);
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", title='" + title + '\'' + ", genre='" + genre + '\'' + ", releaseYear='" + releaseYear + '\'' + ", rating=" + rating + '}';
    }
}
