package com.example.lab6;

import java.util.List;

public class Hospital {
    private int id;
    private String name;
    private Address address;
    private List<Department> departments;

    public Hospital(int id, String name, Address address, List<Department> departments) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        DataBaseOperations.addDepartment(department);
        this.departments.add(department);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
