package com.example.authentification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.NumberFormat;
import java.util.Date;
import java.util.UUID;

public class ScanParameters extends AppCompatActivity {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    public User user;

    public int pulseValue = 80;

    public TextView pulseValueInput;
    public TextView pulseForAge;
    public TextView pulseForGender;
    public TextView bmiValueInput;
    public TextView bmiEvaluatedInput;
    public TextView pulseForBmi;

    public RelativeLayout relativeLayout;
    public LinearLayout mainLayout;

    public NumberFormat nf = NumberFormat.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_parameters);

        pulseValueInput = (TextView) findViewById(R.id.pulseValue);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);

        pulseForAge = (TextView) findViewById(R.id.pulseForAge);
        pulseForGender = (TextView) findViewById(R.id.pulseForGender);
        bmiValueInput = (TextView) findViewById(R.id.bmiValue);
        bmiEvaluatedInput = (TextView) findViewById(R.id.bmiEvaluated);
        pulseForBmi = (TextView) findViewById((R.id.pulseForBmi));

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(ScanParameters.this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        getUser(account);
    }

    public void getUser(GoogleSignInAccount account) {

        String new_email = "";
        if (account.getEmail().contains(".")) {
            String[] list = account.getEmail().split("\\.");
            for (int i = 0; i < list.length; i++)
                new_email = new_email.concat(list[i]);
        }
        String[] parts = new_email.split("@");

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("/users/");

        mFirebaseDatabase.child("user".concat(parts[0])).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.getValue() != null) {
                    user = snapshot.getValue(User.class);

                    mainLayout.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.INVISIBLE);
                    pulseValueInput.setText(nf.format(pulseValue));

                    PulseStatistics ps = new PulseStatistics(pulseValue);

                    if (ps.statisticByAge(user.age).equals("Normal")) {
                        pulseForAge.setText(ps.statisticByAge(user.age));
                        pulseForAge.setTextColor(Color.GREEN);
                    } else {
                        pulseForAge.setText(ps.statisticByAge(user.age));
                        pulseForAge.setTextColor(Color.RED);
                    }

                    if (ps.statisticByGender(user.gender) == 1) {
                        pulseForGender.setText("Normal");
                        pulseForGender.setTextColor(Color.GREEN);
                    } else {
                        pulseForGender.setText("Not normal");
                        pulseForGender.setTextColor(Color.RED);
                    }

                    bmiValueInput.setText(nf.format(ps.calculateBMI(user.weight, user.height)));

                    String bmiEvaluated = ps.evaluateBMI(user.weight, user.height);

                    if (bmiEvaluated.equals("Severe Thinness") || bmiEvaluated.equals("Obese Class III")) {
                        bmiEvaluatedInput.setText(bmiEvaluated);
                        bmiEvaluatedInput.setTextColor(Color.RED);
                    } else if (bmiEvaluated.equals("Moderate Thinness") || bmiEvaluated.equals("Obese Class II")) {
                        bmiEvaluatedInput.setText(bmiEvaluated);
                        bmiEvaluatedInput.setTextColor(Color.rgb(255, 165, 0));
                    } else if (bmiEvaluated.equals("Mild Thinness") || bmiEvaluated.equals("Obese Class I")) {
                        bmiEvaluatedInput.setText(bmiEvaluated);
                        bmiEvaluatedInput.setTextColor(Color.YELLOW);
                    } else {
                        bmiEvaluatedInput.setText(bmiEvaluated);
                        bmiEvaluatedInput.setTextColor(Color.GREEN);
                    }

                    if (ps.statisticsByBMI(user.weight, user.height) == 1) {
                        pulseForBmi.setText("Normal");
                        pulseForBmi.setTextColor(Color.GREEN);
                    } else {
                        pulseForBmi.setText("Not normal");
                        pulseForBmi.setTextColor(Color.RED);
                    }

                    //getLastParam(user.id);
                    createNewParam(pulseValue, user.id);

                } else {
                    mainLayout.setVisibility(View.INVISIBLE);
                    relativeLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void createNewParam(int pulse, String id) {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("params");

        String uniqueID = UUID.randomUUID().toString();
        mFirebaseDatabase.child("param".concat(user.id)).child("param".concat(uniqueID)).setValue(new Parameter(id, pulse,new Date(System.currentTimeMillis())));
    }

    public void getLastParam(String id){

     

    }

}