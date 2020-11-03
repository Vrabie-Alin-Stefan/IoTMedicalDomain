package FacadeDesignPattern;

import CommandDesignPattern.User;

public class Patient implements UserI {
    String dateOfBirth;
    Adress patientAdress;

    public void viewCurentDiagnostic(){}
    public String sendMessageToDoctor(String message){
        return message;
    }
    public void login()
    {
        System.out.println("Login");
    }
    public void register(){
        System.out.println("Register");
    }
}
