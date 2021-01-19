/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.authentification;

public class User {
    public int age;
    public String email;


    public String gender;
    public int height;
    public String name;
    public int weight;

    public User() {
    }

    public User(String name, String email, String gender, int height, int weight, int age) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
}

