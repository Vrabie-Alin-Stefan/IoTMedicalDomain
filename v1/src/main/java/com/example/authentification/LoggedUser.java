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
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.auth.api.signin.GoogleSignInClient
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.auth.FirebaseAuth
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.authentification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.authentification.ForecastActivity;
import com.example.authentification.GoogleBox;
import com.example.authentification.MainActivity;
import com.example.authentification.ScanParameters;
import com.example.authentification.UpdateProfile;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoggedUser
extends AppCompatActivity {
    private GoogleSignInAccount account;
    private Button btnFindDevice;
    private Button btnForecast;
    private Button btnScanParams;
    private Button btnSignOut;
    private Button btnUpdateProfile;
    private TextView userNameText;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_logged_user);
        this.account = GoogleBox.account;
        this.btnSignOut = (Button)this.findViewById(R.id.sign_out_button);
        this.btnFindDevice = (Button)this.findViewById(R.id.find_device_button);
        this.btnUpdateProfile = (Button)this.findViewById(R.id.update_profile_button);
        this.btnScanParams = (Button)this.findViewById(R.id.scan_button);
        btnForecast=findViewById(R.id.btn_forecast);
        //this.btnForecast = (Button)this.findViewById();
           userNameText  = (TextView)this.findViewById(R.id.userName);
        userNameText.setText((CharSequence)this.account.getDisplayName());
        final GoogleSignInClient googleSignInClient = GoogleBox.getGoogleSingInClient((Context)this);
        this.btnSignOut.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                googleSignInClient.signOut();
                FirebaseAuth.getInstance().signOut();
                LoggedUser.this.startActivity(new Intent((Context)LoggedUser.this, MainActivity.class));
            }
        });
        this.btnUpdateProfile.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                LoggedUser.this.startActivity(new Intent((Context)LoggedUser.this, UpdateProfile.class));
            }
        });
        this.btnScanParams.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                LoggedUser.this.startActivity(new Intent((Context)LoggedUser.this, ScanParameters.class));
            }
        });
        this.btnForecast.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                startActivity(new Intent(LoggedUser.this, ForecastActivity.class));
            }
        });
    }

}

