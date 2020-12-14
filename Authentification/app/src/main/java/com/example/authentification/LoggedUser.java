package com.example.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoggedUser extends AppCompatActivity {

    private TextView userNameText;
    private Button btnSignOut;
    private Button btnFindDevice;
    private Button btnUpdateProfile;
    private Button btnScanParams;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_user);
        Intent intent = getIntent();
        btnSignOut = findViewById(R.id.sign_out_button);

        btnFindDevice = findViewById(R.id.find_device_button);
        btnUpdateProfile = findViewById(R.id.update_profile_button);
        btnScanParams = findViewById(R.id.scan_button);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(LoggedUser.this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

        userNameText = (TextView) findViewById(R.id.userName);
        userNameText.setText(account.getDisplayName());


        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleSignInClient.signOut();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(LoggedUser.this, MainActivity.class));
            }
        });

        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoggedUser.this, UpdateProfile.class));
            }
        });

    }

}