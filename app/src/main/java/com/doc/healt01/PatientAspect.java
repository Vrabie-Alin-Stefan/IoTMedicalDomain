package com.doc.healt01;

import android.util.Log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import static android.content.ContentValues.TAG;


@org.aspectj.lang.annotation.Aspect
public class PatientAspect {
    @Pointcut("call(public Patient.new(..))")
    void pointcut1(){}


    @After("pointcut1()")
    void execafter(){
       Patient p=MainActivity.CurrentPatient;
       if(
               p.getPhoneNumber()==null||
               p.getGender()==null||
               p.getWeight()==0||
               p.getHeight()==0||
               p.getBornDate()==null

       ) {
           MainActivity.CurrentPatient = null;
           Log.d(TAG, "execafter:  Something go wrong at initialization");
           throw new ExceptionInInitializerError();
       }
        Log.d("s", "execafter: Into aspect");
    }
}