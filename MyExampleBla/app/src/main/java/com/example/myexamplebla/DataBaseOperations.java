package com.example.myexamplebla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOperations {

    public static String dpts = "{\"departments\":[{\"id\":1,\"name\":\"Medicina de familie\",\"hospitalId\":1},{\"id\":2,\"name\":\"ORL\",\"hospitalId\":1},{\"id\":3,\"name\":\"Pediatrie\",\"hospitalId\":1},{\"id\":4,\"name\":\"Pneumologie\",\"hospitalId\":1},{\"id\":5,\"name\":\"Oftalmologie\",\"hospitalId\":1}]}";

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
}
