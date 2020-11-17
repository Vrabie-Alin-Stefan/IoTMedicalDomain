package Factory;

import Factory.Department;

public class Doctor extends User {

    private int registeredNo;
    private Department Department;

    @Override
    public int login() {
        System.out.println("Login from Doctor!");
        return 0;
    }

    @Override
    public int register() {
        System.out.println("Register from Doctor!");
        return 0;
    }

    @Override
    public int changePassword() {
        System.out.println("ChangePassword from Doctor!");
        return 0;
    }

    @Override
    public int logout() {
        System.out.println("Logout from Doctor!");
        return 0;
    }

    public void addPatient(Patient patient) {
    }

    public void deletePatient(Patient patient) {
    }

    public void checkReports(Patient patient) {
    }

    public void prescribeMedicine(Patient patient) {
    }

    public void prescribeTest(Patient patient) {
    }

    public void getNotifications() {
    }
}

