package com.doc.healt01;

import android.accounts.AccountManager;
import android.util.Log;
import android.widget.Adapter;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patient extends User {
    //atributes

    private int ActualScore;
    private String PhoneNumber;
    private Date BornDate;
    private float Weight;
    private float Height;
    private  String Gender;

    //methods


    public Patient(String phoneNumber, Date bornDate, float weight, float height, String gender) {
        setPhoneNumber(phoneNumber);
        setBornDate(bornDate);
        setWeight(weight);
        setHeight(height);
        setGender(gender);
        MainActivity.CurrentPatient=this;
        Log.d("t", "Patient: Patient constructor exec....");
    }

    public int getScore() {
        return ActualScore;
    }

    public void setScore(int score) {

        ActualScore =score;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public  void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[\\-\\+\\s]", "");
        if (Pattern.compile("\\d{11}").matcher(phoneNumber).matches()
                || Pattern.compile("\\d{10}").matcher(phoneNumber).matches())
            PhoneNumber=phoneNumber;

    }
    public Date getBornDate() {
        return BornDate;
    }

    public void setBornDate(Date bornDate) {
        int curent_year = Calendar.getInstance().get(Calendar.YEAR);
      int  bornYear= bornDate.getYear();
       if(curent_year-200<bornYear && bornYear<curent_year)
        BornDate = bornDate;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        if(10<weight && weight<350)
        Weight = weight;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float height) {
        if(0.2<height && height<3)
        Height = height;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        if(gender.equals("Man") ||gender.equals("Woman"))
        Gender = gender;
    }
    public void setEmail( ){
       Emial=MainActivity.CURENT_EMAIL;

    }
    public void setLastName(String lastName){
        LastName=lastName;
    }
    public void setFirstName(String firstName){
        FirstName=firstName;
    }
   public void setAdress(String adress){
        Adress=adress;
   }

   public int getAge(){
       int curent_year = Calendar.getInstance().get(Calendar.YEAR);
       int  bornYear= BornDate.getYear();
       return curent_year-bornYear;
   }



}
