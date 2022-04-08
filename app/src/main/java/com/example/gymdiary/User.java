package com.example.gymdiary;

import java.util.List;

public class User {

    public String username, email;
    private List<Workout> workoutList;

    public User(){

    }

    public User(String username, String email, List<Workout> workoutList){
        this.workoutList = workoutList;
        this.username = username;
        this.email = email;

    }


}
