package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class Calculator {

    @SerializedName("age")
    private int age;
    @SerializedName("height")
    private int height;
    @SerializedName("weight")
    private int weight;
    @SerializedName("username")
    private String username_login;

    public Calculator()
    {}

    public Calculator(String username_login, int age, int height, int weight)
    {
        this.username_login = username_login;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getUsername_login() {
        return username_login;
    }

    public void setUsername_login(String username_login) {
        this.username_login = username_login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", username_login='" + username_login + '\'' +
                '}';
    }
}
