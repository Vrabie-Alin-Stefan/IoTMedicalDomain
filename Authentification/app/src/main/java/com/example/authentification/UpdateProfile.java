package com.example.authentification;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class UpdateProfile extends AppCompatActivity {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    public User user;

    public TextView inputNameText;
    public TextView inputEmailText;
    public TextView ageText;
    public TextView heightText;
    public TextView weightText;
    public RadioButton femaleBtn;
    public RadioButton maleBtn;
    public Button updateBtn;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String genderChoice;
    public NumberFormat nf = NumberFormat.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        inputNameText = (TextView) findViewById(R.id.inputName);
        inputEmailText = (TextView) findViewById(R.id.inputEmail);
        ageText = (TextView) findViewById(R.id.inputAge);
        heightText = (TextView) findViewById(R.id.inputHeight);
        weightText = (TextView) findViewById(R.id.inputWeight);
        femaleBtn = (RadioButton) findViewById(R.id.femaleButton);
        maleBtn = (RadioButton) findViewById(R.id.maleButton);
        updateBtn = (Button) findViewById(R.id.updateProfileButton);

        getUser();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ageText.getText().toString().equals("")
                        && !heightText.getText().toString().equals("")
                        && !weightText.getText().equals("")
                        && (femaleBtn.isChecked() || maleBtn.isChecked())) {

                    if (femaleBtn.isChecked()) {
                        genderChoice = "female";
                    } else {
                        genderChoice = "male";
                    }
                    verifyUser();
                } else {
                    if (ageText.getText().toString().equals("")) {
                        ageText.setError("Please complete your age!");
                    }
                    if (heightText.getText().toString().equals("")) {
                        heightText.setError("Please complete your height!");
                    }
                    if (weightText.getText().toString().equals("")) {
                        weightText.setError("Please complete your weight!");
                    }
                    femaleBtn.setChecked(true);
                }
            }
        });
    }

    private void getUser() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(UpdateProfile.this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("/users/");

        mFirebaseDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                user = snapshot.getValue(User.class);
                if (user.email.equals(account.getEmail())) {
                    inputNameText.setText(user.name);
                    inputEmailText.setText(user.email);

                    ageText.setText(nf.format(user.age));
                    heightText.setText(nf.format(user.height));
                    weightText.setText(nf.format(user.weight));
                    if (user.gender.equals("female"))
                        femaleBtn.setChecked(true);
                    else
                        maleBtn.setChecked(true);
                } else {
                    Toast.makeText(UpdateProfile.this, "Please complete this form!", Toast.LENGTH_SHORT).show();
                    inputNameText.setText(account.getDisplayName());
                    inputEmailText.setText(account.getEmail());
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public void verifyUser() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(UpdateProfile.this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

        String[] parts = account.getEmail().split("@");

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("/users/");



        mFirebaseDatabase.child("user".concat(parts[0])).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                 if (snapshot.getValue() != null) {
                    user = snapshot.getValue(User.class);
                    decideOperation(1, user);
                } else {
                    decideOperation(0, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void decideOperation(int operation, User user) {
        if (operation == 1) {
            String[] parts = user.email.split("@");
            updateUser(parts[0], inputNameText.getText().toString(),
                    inputEmailText.getText().toString(),
                    genderChoice,
                    Integer.parseInt(heightText.getText().toString()),
                    Integer.parseInt(weightText.getText().toString()),
                    Integer.parseInt(ageText.getText().toString()));
        } else {
            String[] parts =  inputEmailText.getText().toString().split("@");
            createNewUser(parts[0], inputNameText.getText().toString(),
                    inputEmailText.getText().toString(),
                    genderChoice,
                    Integer.parseInt(heightText.getText().toString()),
                    Integer.parseInt(weightText.getText().toString()),
                    Integer.parseInt(ageText.getText().toString()));
        }
        Toast.makeText(UpdateProfile.this, "User updated!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(UpdateProfile.this, LoggedUser.class));
    }

    public void createNewUser(String id, String name, String email, String gender, int height, int weight, int age) {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        mFirebaseDatabase.child("user".concat(id)).setValue(new User(id, name, email, gender, height, weight, age));
    }

    public void updateUser(String id, String name, String email, String gender, int height, int weight, int age) {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        Map<String, Object> userUpdates = new HashMap<>();
        userUpdates.put("email", email);
        userUpdates.put("name", name);
        userUpdates.put("age", age);
        userUpdates.put("gender", gender);
        userUpdates.put("height", height);
        userUpdates.put("weight", weight);

        mFirebaseDatabase.child("user".concat(id)).updateChildren(userUpdates);

    }


}