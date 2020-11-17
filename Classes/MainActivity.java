package com.example.lab6;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Address address = new Address("str1", 1, "Iasi", "Romania");

        Hospital hospital = new Hospital(1, "Sf Spiridon", address, DataBaseOperations.getDeparments());

        Department department = new Department(23, "Nefrologie", hospital.getId());

        hospital.addDepartment(department);

        //13692
        Doctor doct = new Doctor(20, "Ion Popescu", 24567, department.getId(), DataBaseOperations.getPatients());

        doct.addPatient("Un pacient");

        doct.deletePatient("Ion Barbu");

        department.addDoctor(doct);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}