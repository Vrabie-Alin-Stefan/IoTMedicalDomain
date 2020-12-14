package com.example.myexamplebla;

import android.util.Log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HospitalBeforeAfterAspect {

    @Pointcut("execution(* com.example.myexamplebla.Hospital.addDepartment(..))")
    public void selectAddDepartment() {
    }

    @Before("selectAddDepartment()")
    public void beforeAdvice() {
        Log.d("Hospital:", "Check if department already exists!");
    }

    @After("selectAddDepartment()")
    public void afterAdvice() {
        Log.d("Hospital:", "Department has been added with success!");
    }
}
