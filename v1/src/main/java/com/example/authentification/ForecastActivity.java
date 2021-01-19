/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.firebase.database.DataSnapshot
 *  com.google.firebase.database.DatabaseError
 *  com.google.firebase.database.DatabaseReference
 *  com.google.firebase.database.FirebaseDatabase
 *  com.google.firebase.database.ValueEventListener
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package com.example.authentification;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.authentification.Forecast;
import com.example.authentification.GoogleBox;
import com.example.authentification.Parser;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class ForecastActivity
extends AppCompatActivity {
    Forecast forecast;
    private DatabaseReference mFirebaseDatabase;
    TextView textView_panelist;
    TextView tv_oxigen;

    private void getPulseFromPatientHystory() {
        FirebaseDatabase.getInstance().getReference().child("params").child(GoogleBox.account.getId()).addValueEventListener(new ValueEventListener(){

            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                Parser.parseObj(dataSnapshot.getValue().toString());
                Forecast forecast = new Forecast();
                TextView textView = ForecastActivity.this.textView_panelist;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(forecast.forecatsMyData(Parser.pulse_list));
                stringBuilder.append("");
                textView.setText((CharSequence)stringBuilder.toString());
                TextView textView2 = ForecastActivity.this.tv_oxigen;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(forecast.forecatsMyData(Parser.oxigen_list));
                stringBuilder2.append("");
                textView2.setText((CharSequence)stringBuilder2.toString());
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427376);
        this.textView_panelist = (TextView)this.findViewById(2131231105);
        this.tv_oxigen = (TextView)this.findViewById(2131231104);
        getPulseFromPatientHystory();
    }

}

