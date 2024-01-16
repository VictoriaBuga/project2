package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class RateUs {
    @SerializedName("username")
    private String username;
    @SerializedName("rating_code")
    private String rating_code;
    @SerializedName("rating")
    private int rating;


    public String getRating_code() {
        return rating_code;
    }

    public void setRating_code(String rating_code) {
        this.rating_code = rating_code;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "RateUs{" +
                "rating_code='" + rating_code + '\'' +
                ", rating='" + rating + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
