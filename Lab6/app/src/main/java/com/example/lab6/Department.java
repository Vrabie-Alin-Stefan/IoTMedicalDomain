package com.example.lab6;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id;
    private String name;
    private int hospitalId;
    private List<Doctor> doctors;

    public Department(int id, String name, int hospital) {
        this.id = id;
        this.name = name;
        this.hospitalId = hospital;
        this.doctors = new ArrayList<Doctor>();
    }

    public void addDoctor(Doctor doctor) {
        DataBaseOperations.addDoctor(doctor);
        this.doctors.add(doctor);
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctors() {

        this.doctors = DataBaseOperations.getDoctorsForDepartment(this.id);

        return this.doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
