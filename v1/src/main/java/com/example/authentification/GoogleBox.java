/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.auth.api.signin.GoogleSignIn
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.auth.api.signin.GoogleSignInClient
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder
 *  java.lang.Object
 */
package com.example.authentification;

import android.content.Context;
import com.example.authentification.MainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class GoogleBox {
    public static GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount((Context)MainActivity.APP_CTX);
    public static final GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

    public static GoogleSignInClient getGoogleSingInClient(Context context) {
        return GoogleSignIn.getClient((Context)context, (GoogleSignInOptions)gso);
    }
}

