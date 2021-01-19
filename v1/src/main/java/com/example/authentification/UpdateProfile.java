/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.RadioButton
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.AppCompatActivity
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.database.ChildEventListener
 *  com.google.firebase.database.DataSnapshot
 *  com.google.firebase.database.DatabaseError
 *  com.google.firebase.database.DatabaseReference
 *  com.google.firebase.database.FirebaseDatabase
 *  com.google.firebase.database.ValueEventListener
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.NumberFormat
 *  java.util.HashMap
 *  java.util.Map
 */
package com.example.authentification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.authentification.GoogleBox;
import com.example.authentification.LoggedUser;
import com.example.authentification.User;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class UpdateProfile
extends AppCompatActivity {
    GoogleSignInAccount account = GoogleBox.account;
    public TextView ageText;
    public RadioButton femaleBtn;
    private static final String TAG = "ddd";
    private TextView newUserWarning;
    public TextView heightText;
    public TextView inputEmailText;
    public TextView inputNameText;
    public RadioButton maleBtn;
    public Button updateBtn;
    public User user;
    public TextView weightText;

    private void getUser() {
         inputNameText.setText(account.getDisplayName());
         inputEmailText.setText(account.getEmail());
        FirebaseDatabase.getInstance().getReference().child("users").child(account.getId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user=snapshot.getValue(User.class);
               if(user!=null){
                   newUserWarning.setVisibility(View.INVISIBLE);
                   ageText.setText(user.age+"");
                   weightText.setText(user.weight+"");
                   heightText.setText(user.height+"");
                   if(user.gender.equals("male")){
                       maleBtn.setChecked(true);
                   }
                   else femaleBtn.setChecked(true);

               }
               else newUserWarning.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_update_profile);
        this.inputNameText = (TextView)this.findViewById(R.id.inputName);

        this.inputEmailText = (TextView)this.findViewById(R.id.inputEmail);
        this.ageText = (TextView)this.findViewById(R.id.inputAge);
        inputEmailText.setEnabled(false);
        inputNameText.setEnabled(false);
        this.heightText = (TextView)this.findViewById(R.id.inputHeight);
        this.weightText = (TextView)this.findViewById(R.id.inputWeight);
        this.femaleBtn = (RadioButton)this.findViewById(R.id.femaleButton);
        this.maleBtn = (RadioButton)this.findViewById(R.id.maleButton);
        this.updateBtn = (Button)this.findViewById(R.id.updateProfileButton);
        newUserWarning=findViewById(R.id.newUserTextView);
        String gen;
        getUser();
        this.updateBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {

                if (UpdateProfile.this.ageText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Please complete your age!",Toast.LENGTH_SHORT).show();
                }
               else if (UpdateProfile.this.heightText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Please complete your height!",Toast.LENGTH_SHORT).show();
                }
               else if (UpdateProfile.this.weightText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Please complete your weight!",Toast.LENGTH_SHORT).show();
                }
               else if(!(femaleBtn.isChecked()||maleBtn.isChecked()))
                {
                    Toast.makeText(getApplicationContext(),"Please select your gender!",Toast.LENGTH_SHORT).show();
                }

               else{
                   String gen=((femaleBtn.isChecked())? "female":"male");
                FirebaseDatabase.getInstance().getReference().child("users").child(account.getId()).setValue(new User(account.getDisplayName(),
                        account.getEmail(),gen,Integer.parseInt(ageText.getText()+"")
                        ,Integer.parseInt(weightText.getText()+"")
                        ,Integer.parseInt(heightText.getText()+"")));
                    Toast.makeText(getApplicationContext(),"Successfuly update DB",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateProfile.this,LoggedUser.class));
               }
            }
        });
    }





}

