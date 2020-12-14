package com.example.lab6;

import android.util.Log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

@Aspect
public class HospitalBeforeAfterAspect {

    @Pointcut("execution(* com.example.lab6.Hospital.addDepartment(..))&& args(department) ")
    public void addDepartment(Department department) {
    }

    @Before("addDepartment(department)")
    public void beforeAddDepartment(Department department) {
        Log.d("Hospital", "Check if department, " + department.getName() + ", already exists!");
        List<Department> alldepartments = DataBaseOperations.getDeparments();
        for (int i = 0; i < alldepartments.size(); i++) {
            if (alldepartments.get(i).getName() == department.getName() && alldepartments.get(i).getHospitalId() == department.getHospitalId()) {
                throw new Error("Department already exists in the hospital!");
            }
        }
    }

    @After("addDepartment(department)")
    public void afterAddDepartment(Department department) {
        Log.d("Hospital", "Department has been added with success!");
    }
}
