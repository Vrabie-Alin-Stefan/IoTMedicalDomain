package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Users.getUser("Doctor").addUser();
        Users.getUser("Patient").addUser();
        Users.getUser("Patient").addUser();
        Users.getUser("Patient").addUser();
    }
}
