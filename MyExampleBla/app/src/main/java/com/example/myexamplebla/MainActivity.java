package com.example.myexamplebla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Address ad = new Address("str1", 1, "Iasi", "romania");

        Hospital hospital = new Hospital(1, "Sf Spiridon", ad, DataBaseOperations.getDeparments());

        Department dep = new Department(23, "myDep", hospital.getId());

        hospital.addDepartment(dep);

        Log.d("hello", dep.getName());

    }
}