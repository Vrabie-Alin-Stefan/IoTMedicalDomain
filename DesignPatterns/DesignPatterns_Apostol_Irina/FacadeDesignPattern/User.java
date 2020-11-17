package FacadeDesignPattern;

public class User {

 private UserI Patient;
 private UserI Doctor;
 public User()
 {
     Patient=new Patient();
     Doctor=new Doctor();
 }

 public void PatientUser()
 {
     Patient.login();
     Patient.register();
 }

 public void DoctorUser()
 {
     Doctor.login();
     Doctor.register();
 }

}
