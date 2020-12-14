package com.example.myexamplebla;

import java.util.List;

public class Doctor {
    private int id;
    //name -- disappears when User is created
    private String name;
    private int registeredNo;
    private int departmentId;
    //List<Patient>
    private List<String> patients;

    public Doctor(int id, String name, int registeredNo, int department, List patients) {
        this.id = id;
        this.name = name;
        this.registeredNo = registeredNo;
        this.departmentId = department;
        this.patients = patients;
    }

    public void addPatient(String patient) {
        this.patients.add(patient);
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

    public int getRegisteredNo() {
        return registeredNo;
    }

    public void setRegisteredNo(int registeredNo) {
        this.registeredNo = registeredNo;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public List getPatients() {
        return patients;
    }

    public void setPatients(List patients) {
        this.patients = patients;
    }

    public void deletePatient(String patient) {
        this.patients.remove(patient);
    }

    public void checkReports(String Patient) {

    }

    public void prescribeMedicine(String Patient) {

    }

    public void prescribeTest(String Patient) {

    }

    public void getNotifications() {

    }
}
