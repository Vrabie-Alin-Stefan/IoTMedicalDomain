package com.doc.healt01;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ComputeScore {
     private int age=MainActivity.CurrentPatient.getAge();
    private int getMaxHeartBeepKarvonenMethod(){
         return (int)Math.round( 207-age*0.7);
    }

    public float computeScore(int heartBeet, int bloodOxigen, int arterialTennis ){
         return 2;

     }
}

  /*   private int getHeartBeetMaxValue(int age ,String gender){
         if(10<=age && age<=20) return 200;
         else if(20<age && age<=30) return 190;
         else if(30<age && age<=35) return 185;
         else if(35<age && age<=40) return 180;
         else if(40<age && age<=45) return 175;
         else if(45<age && age<=50) return 170;
         else if(50<age && age<=55) return 165;
         else if(55<age && age<=60) return 160;
         else if(60<age && age<=65) return 155;
         else if(65<age && age<=70) return 150;
         else if (70<age) return 150;
         else return 0;
     }*/



