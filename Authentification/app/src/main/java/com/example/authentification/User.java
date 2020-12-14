package com.example.authentification;

public class User {

    public String id;
    public String name;
    public String email;
    public String gender;
    public int height;
    public int weight;
    public int age;


    public User(String id, String name, String email, String gender, int height, int weight, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public User() {
    }
}
