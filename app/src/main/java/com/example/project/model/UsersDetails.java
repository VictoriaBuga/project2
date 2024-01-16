package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class UsersDetails {
    @SerializedName("name_user")
    private String name_user;
    @SerializedName("username_login")
    private String username_login;
    @SerializedName("email_login")
    private String email_login;
    @SerializedName("phone")
    private String phone;
    @SerializedName("age")
    private int age;
    @SerializedName("country")
    private String country;
    @SerializedName("weight")
    private int weight;
    @SerializedName("gender")
    private String gender;
    @SerializedName("height")
    private int height;

    public UsersDetails()
    {
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getUsername_login() {
        return username_login;
    }

    public void setUsername_login(String username_login) {
        this.username_login = username_login;
    }

    public String getEmail_login() {
        return email_login;
    }

    public void setEmail_login(String email_login) {
        this.email_login = email_login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "UsersDetails{" +
                "name_user='" + name_user + '\'' +
                ", age='" + age + '\'' +
                ", country='" + country + '\'' +
                ", email_login='" + email_login + '\'' +
                ", gender=" + gender +
                ", height='" + height + '\'' +
                ", phone=" + phone +
                ", weight='" + weight + '\'' +
                //", username_login='" + username_login + '\'' +
                '}';
    }
}
