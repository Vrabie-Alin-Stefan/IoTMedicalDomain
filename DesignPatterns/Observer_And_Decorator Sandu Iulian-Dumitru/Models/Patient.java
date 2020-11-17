package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import ComputationalFormulas.ComputeScore;

public class Patient extends User implements  Subject{

   private Vector<Doctor> MyDoctors;
   private Date DateOfBirth;
   private int Score;
   private  int Height;
   private int Weight;
   private int Age;
   protected String Gender;
   private int LevelOfActivity;
   private ArrayList<Diagnostic> Hisotory;

   public Patient(Date dateOfBirth, int height, int weight,int levelOfActivity) {
      DateOfBirth = dateOfBirth;
      Height = height;
      Weight = weight;
      LevelOfActivity =levelOfActivity;
   }

   public void viewCurrentDiagnosic(){
   }
   private void addToHystory(Diagnostic diagnostic){}
   public void setScore(ComputeScore compute_using){
      //...getting score ...
      if(isDangerousScore(Score)) {notifyDoctor();}

   }

   private boolean isDangerousScore(int score) {
      return  false;
   }

   public void sendMessageToDoctor(String message){}


   @Override
   public void attach() {
      MyDoctors.add( new Doctor());
   }

   @Override
   public void detach(Doctor doc) {
      MyDoctors.remove(doc);
   }

   @Override
   public void notifyDoctor() {
      for (Doctor doc:MyDoctors) doc.update();
   }
}
