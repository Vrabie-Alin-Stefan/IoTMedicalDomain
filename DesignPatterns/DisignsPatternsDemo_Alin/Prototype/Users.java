package com.example.myapplication;

import java.util.HashMap;
import java.util.Map;

public class Users {

    private static Map<String, User> UsersMap = new HashMap<String, User>();


    public static User getUser(String userType)
    {
        return (User) UsersMap.get(userType).clone();
    }

}
