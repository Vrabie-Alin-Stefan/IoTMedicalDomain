package com.example.lab6;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOperations {

    public static String dpts = "{\"departments\":[{\"id\":1,\"name\":\"Medicina de familie\",\"hospitalId\":1},{\"id\":2,\"name\":\"ORL\",\"hospitalId\":1},{\"id\":3,\"name\":\"Pediatrie\",\"hospitalId\":1},{\"id\":4,\"name\":\"Pneumologie\",\"hospitalId\":1},{\"id\":5,\"name\":\"Oftalmologie\",\"hospitalId\":1}]}";
    public static String adds = "{\"addresses\":[{\"Street\":\"Bulevardul Independen\u021bei\",\"HouseNo\":1,\"City\":\"Iasi\",\"Country\":\"Romania\"},{\"Street\":\"Vasile Lupu\",\"HouseNo\":62,\"City\":\"Iasi\",\"Country\":\"Romania\"},{\"Street\":\" Pantelimon Halipa\",\"HouseNo\":14,\"City\":\"Iasi\",\"Country\":\"Romania\"}]}";
    public static String drs = "{\"doctors\":[{\"id\":1,\"name\":\"Doctor1\",\"registeredNo\":13692,\"department\":2,\"patients\":[{\"name\":\"Ion Barbu\"},{\"name\":\"Mihai Eminescu\"}]},{\"id\":2,\"name\":\"Doctor2\",\"registeredNo\":19842,\"department\":4,\"patients\":[{\"name\":\"Nichita Stanescu\"}]},{\"id\":3,\"name\":\"Doctor3\",\"registeredNo\":24896,\"department\":5,\"patients\":[{\"name\":\"Ion Creanga\"},{\"name\":\"Ana Blandiana\"}]}]}";
    public static String pts = "{\"patients\":[{\"name\":\"Ion Barbu\"},{\"name\":\"George Toparceanu\"},{\"name\":\"Ion Creanga\"},{\"name\":\"Mihai Eminescu\"},{\"name\":\"Lucian Blaga\"},{\"name\":\"Ana Blandiana\"},{\"name\":\"Nichita Stanescu\"}]}";


    public static List<Department> getDeparments() {
        try {
            JSONObject reader = new JSONObject(dpts);

            List<Department> alldepartments = new ArrayList<Department>();
            JSONArray departments = reader.getJSONArray("departments");
            for (int i = 0; i < departments.length(); i++) {
                JSONObject dept = departments.getJSONObject(i);
                Department department = new Department(dept.getInt("id"), dept.getString("name"), dept.getInt("hospitalId"));
                alldepartments.add(department);
            }
            return alldepartments;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Address> getAddresses() {
        try {
            JSONObject reader = new JSONObject(adds);

            List<Address> allAddresses = new ArrayList<Address>();
            JSONArray addresses = reader.getJSONArray("addresses");
            for (int i = 0; i < addresses.length(); i++) {
                JSONObject adr = addresses.getJSONObject(i);
                Address address = new Address(adr.getString("Street"), adr.getInt("HouseNo"), adr.getString("City"), adr.getString("Country"));
                allAddresses.add(address);
            }
            return allAddresses;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Doctor> getDoctors() {
        try {
            JSONObject reader = new JSONObject(drs);

            List<Doctor> allDoctors = new ArrayList<Doctor>();
            JSONArray doctors = reader.getJSONArray("doctors");
            for (int i = 0; i < doctors.length(); i++) {
                JSONObject dr = doctors.getJSONObject(i);

                List<String> patients = new ArrayList<String>();
                JSONArray pts = dr.getJSONArray("patients");
                for (int j = 0; j < pts.length(); j++) {
                    JSONObject pat = pts.getJSONObject(j);
                    String patient = pat.getString("name");
                    patients.add(patient);
                }

                Doctor doctor = new Doctor(dr.getInt("id"), dr.getString("name"), dr.getInt("registeredNo"), dr.getInt("department"), patients);
                allDoctors.add(doctor);
            }
            return allDoctors;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getPatients() {
        try {
            JSONObject reader = new JSONObject(pts);

            List<String> allPatients = new ArrayList<String>();
            JSONArray pts = reader.getJSONArray("patients");
            for (int j = 0; j < pts.length(); j++) {
                JSONObject pat = pts.getJSONObject(j);
                String patient = pat.getString("name");
                allPatients.add(patient);
            }

            return allPatients;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Doctor> getDoctorsForDepartment(int departmentId) {

        List<Doctor> allDoctors = getDoctors();
        List<Doctor> doctorList = new ArrayList<Doctor>();

        for (int i = 0; i < allDoctors.size(); i++) {
            if (allDoctors.get(i).getDepartmentId() == departmentId) {
                doctorList.add(allDoctors.get(i));
            }
        }
        return doctorList;
    }

    public static void addDoctor(Doctor doctor) {
        Log.d("Db operations", "Doctor, " + doctor.getName() + ", had been added into db");
    }

    public static void addDepartment(Department department) {
        Log.d("Db operations", "Department," + department.getName() + ", had been added into db");
    }

    public static void addPatientToDoctor(Doctor doctor, String patient) {
        Log.d("Db operations", "Patient," + patient + ", had been added to doctor " + doctor.getName());
    }

    public static void deletePatientFromDoctor(Doctor doctor, String patient) {
        Log.d("Db operations", "Patient," + patient + ", had been deleted from doctor " + doctor.getName());
    }

    public static void getHealthReportForPatient(String patient) {
        Log.d("Db operations", "Get report for patient " + patient);
    }

    public static void sendMessage(String from, String to, String subject, String body) {
        Log.d("Db operations", "Send message from " + from + " to " + to + " with the subject - " + subject + " body-- " + body);
    }

    public static void getMessages(String name) {
        Log.d("Db operations", "Get all the messages for " + name);
    }
}
