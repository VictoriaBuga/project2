package com.example.project.model;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.Date;

public class Tasks {
    @SerializedName("task_code")
    private String task_code;
    @SerializedName("hours_sleep")
    private int hours_sleep;
    @SerializedName("meals_number")
    private int meals_number;
    @SerializedName("showers")
    private int showers;
    @SerializedName("snacks")
    private int snacks;
    @SerializedName("water_liters")
    private int water_liters;
    @SerializedName("username")
    private String username;

    public String getTask_code() {
        return task_code;
    }

    public void setTask_code(String task_code) {
        this.task_code = task_code;
    }


    public int getHours_sleep() {
        return hours_sleep;
    }

    public void setHours_sleep(int hours_sleep) {
        this.hours_sleep = hours_sleep;
    }

    public int getMeals_number() {
        return meals_number;
    }

    public void setMeals_number(int meals_number) {
        this.meals_number = meals_number;
    }

    public int getShowers() {
        return showers;
    }

    public void setShowers(int showers) {
        this.showers = showers;
    }

    public int getSnacks() {
        return snacks;
    }

    public void setSnacks(int snacks) {
        this.snacks = snacks;
    }

    public int getWater_liters() {
        return water_liters;
    }

    public void setWater_liters(int water_liters) {
        this.water_liters = water_liters;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "task_code='" + task_code + '\'' +
                ", hours_sleep=" + hours_sleep +
                ", meals_number=" + meals_number +
                ", showers=" + showers +
                ", snacks=" + snacks +
                ", water_liters=" + water_liters +
                ", username=" + username +
                '}';
    }
}
