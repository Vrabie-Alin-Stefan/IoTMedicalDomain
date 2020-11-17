package com.example.lab6;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;
import java.util.List;

@Aspect
public class DoctorBeforeAfterAspect {
    @Pointcut("execution(* com.example.lab6.Doctor.addPatient(..))&& args(patient) ")
    public void addPatient(String patient) {
    }

    @Before("addPatient(patient)")
    public void beforeAddPatient(String patient) {
        Log.d("Doctor", "Check if patient, " + patient + ", already exists!");
        List<String> allPatients = DataBaseOperations.getPatients();
        for (int i = 0; i < allPatients.size(); i++) {
            if (allPatients.get(i) == patient) {
                throw new Error("Patient already exists!!");
            }
        }
    }

    @After("addPatient(patient)")
    public void afterAddPatient(String patient) {
        Log.d("Doctor", "Patient has been added with success!");
    }

    @Pointcut("execution(* com.example.lab6.Doctor.deletePatient(..))&& args(patient) ")
    public void deletePatient(String patient) {
    }

    @Before("deletePatient(patient)")
    public void beforeDeletePatient(String patient) {
        boolean exists = false;

        List<String> allPatients = DataBaseOperations.getPatients();
        for (int i = 0; i < allPatients.size(); i++) {
            if (allPatients.get(i).toString().equals(patient)) {
                exists = true;
            }
        }
        if(exists == false){
            throw new Error("Patient don't exists!!");
        }
    }

    @After("deletePatient(patient)")
    public void afterDeletePatient(String patient) {
        Log.d("Doctor", "Patient has been deleted with success!");
    }
}
