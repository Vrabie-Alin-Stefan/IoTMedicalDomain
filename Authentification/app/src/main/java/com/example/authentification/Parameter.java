package com.example.authentification;

import java.util.Date;

public class Parameter {

    public String userId;
    public int pulse;
    public Date dateAdded;


    public Parameter(String userId, int pulse, Date date) {
        this.userId = userId;
        this.pulse = pulse;
        this.dateAdded = date;
    }
}
