package com.example.lab6;

import android.util.Log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

@Aspect
public class DepartmentBeforeAfterAspect {
    @Pointcut("execution(* com.example.lab6.Department.addDoctor(..))&& args(doctor) ")
    public void addDoctor(Doctor doctor) {
    }

    @Before("addDoctor(doctor)")
    public void beforeAddDoctor(Doctor doctor) {
        Log.d("Department", "Check if doctor, " + doctor.getName() + ", already exists!");

        List<Doctor> allDoctors = DataBaseOperations.getDoctors();
        for (int i = 0; i < allDoctors.size(); i++) {
            if (allDoctors.get(i).getRegisteredNo() == doctor.getRegisteredNo()) {
                throw new Error("Doctor already exists!!");
            }
        }
    }

    @After("addDoctor(doctor)")
    public void afterAddDoctor(Doctor doctor) {
        Log.d("Department", "Doctor has been added with success!");
    }
}
