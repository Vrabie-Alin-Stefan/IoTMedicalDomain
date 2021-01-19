/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.AppCompatActivity
 *  com.google.android.gms.auth.api.signin.GoogleSignIn
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.auth.api.signin.GoogleSignInClient
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder
 *  com.google.android.gms.common.SignInButton
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.tasks.Task
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.example.authentification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.authentification.GoogleBox;
import com.example.authentification.LoggedUser;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity
extends AppCompatActivity {
    public static Context APP_CTX;
    private String TAG = "MainActivity";
    private static final int REQ_CODE = 753;
    GoogleSignInAccount account;
    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton signInButton;

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {

            account = task.getResult(ApiException.class);
            updateUI();

        }
        catch (ApiException apiException) {
            String string2 = this.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("signInResult:failed code=");
            stringBuilder.append(apiException.getStatusCode());
            Log.w((String)string2, (String)stringBuilder.toString());

        }
    }

    private void signIn() {
        startActivityForResult(mGoogleSignInClient.getSignInIntent(), REQ_CODE);
    }

    private void updateUI() {
        APP_CTX = this.getApplicationContext();
        GoogleBox.account = account;
        if (this.account != null) {
            startActivity(new Intent(this, LoggedUser.class));
        }
        else Log.d(TAG, "xxxxxxx: ");
    }

    public void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        Log.d(TAG, "SSSSSSSSSSSSSSSSSSSSSSSSSSS ");
        if(n==REQ_CODE)
        handleSignInResult((Task<GoogleSignInAccount>)GoogleSignIn.getSignedInAccountFromIntent((Intent)intent));

    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.signInButton = (SignInButton)this.findViewById(R.id.sign_id_button);
        this.mGoogleSignInClient = GoogleSignIn.getClient((Activity)this, (GoogleSignInOptions)new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build());
        this.signInButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                signIn();
            }
        });
    }

}

