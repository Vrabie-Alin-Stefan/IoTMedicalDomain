package com.doc.healt01;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.util.Log;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static  String  CURENT_EMAIL;
 public  static Patient CurrentPatient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Account[] accounts=AccountManager.get(this).getAccounts();

         CURENT_EMAIL=accounts[0].name;

         ///// if patient exist in databse get patient...
        CurrentPatient=getFromDB(CURENT_EMAIL);
        ////////else
        new Patient("0748159964",new Date(1998,03,15),140,180,"Main");
        //Log.d("s", "onCreate: "+ CurrentPatient.getGender());

    }

    private void set() {
        Log.d("x", "setName: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    private Patient getFromDB(String curentEmail) {
        return null;
    }

}