package com.niit.bej.gaming.service.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;

@Document(collection = "users")
public class User {
    @MongoId
    private int id;
    private String name;

    private List<Game> favouriteGameList;

    public User() {
    }

    public User(int id, String name, List<Game> favouriteGameList) {
        this.id = id;
        this.name = name;
        this.favouriteGameList = favouriteGameList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getFavouriteGameList() {
        return favouriteGameList;
    }

    public void setFavouriteGameList(List<Game> favouriteGameList) {
        this.favouriteGameList = favouriteGameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(favouriteGameList, user.favouriteGameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, favouriteGameList);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", favouriteGameList=" + favouriteGameList + '}';
    }

}
