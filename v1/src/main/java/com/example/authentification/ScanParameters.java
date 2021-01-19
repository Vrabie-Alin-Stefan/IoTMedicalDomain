/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  com.google.android.gms.auth.api.signin.GoogleSignIn
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.database.DataSnapshot
 *  com.google.firebase.database.DatabaseError
 *  com.google.firebase.database.DatabaseReference
 *  com.google.firebase.database.FirebaseDatabase
 *  com.google.firebase.database.ValueEventListener
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.text.NumberFormat
 *  java.text.SimpleDateFormat
 *  java.util.Calendar
 *  java.util.Date
 */
package com.example.authentification;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.authentification.Parameter;
import com.example.authentification.PulseStatistics;
import com.example.authentification.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScanParameters
extends AppCompatActivity {
    GoogleSignInAccount account;
    public TextView bmiEvaluatedInput;
    public TextView bmiValueInput;
    public LinearLayout mainLayout;
    public NumberFormat nf = NumberFormat.getInstance();
    public int oxigen = 12;
    public TextView pulseForAge;
    public TextView pulseForBmi;
    public TextView pulseForGender;
    public int pulseValue = 80;
    public TextView pulseValueInput;
    public RelativeLayout relativeLayout;
    public User user;
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_scan_parameters);
        Parameter parameter;
        parameter= scanValues();


    }
    public void createNewParam(int n, int n2) {
        FirebaseDatabase.getInstance().getReference("params").child(this.account.getId())
                .child(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(Calendar.getInstance()
                                .getTime()))
                .setValue((Object)new Parameter(n, n2));
    }

    private Parameter scanValues(){
        
    }




}

