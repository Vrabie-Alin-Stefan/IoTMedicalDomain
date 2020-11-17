package FacadeDesignPattern;

import java.util.ArrayList;

public class Doctor implements UserI {

    public ArrayList<Patient> showPatients(ArrayList<Patient> patients){
        return patients;
    }
    public boolean addPatient(Patient patient){
        ArrayList<Patient> patients=new ArrayList<Patient>();
        return patients.add(patient);
    }
    public void deletePatient(){}
    public void prescribeMedicine(){}
    public void getMessageFromPatients(){}

    public void login()
    {
        System.out.println("Login");
    }
    public void register(){
        System.out.println("Register");
    }
}
