package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView displayText = (TextView)findViewById(R.id.Display);

        DataModeling model = DataModeling.getInstance();
        model.setBloodPresure((float)12.2);
        model.setOxygen((float)12.2);
        model.setTemperature((float)12.2);
        model.setBloodPresure((float)12.2);

        displayText.setText(model.Diagnostic(model.getTemperature(), model.getBloodPresure(), model.getHeartBeats(), model.getOxygen()));


    }
}
