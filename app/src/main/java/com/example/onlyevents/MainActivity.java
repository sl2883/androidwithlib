package com.example.onlyevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.clevertap.android.sdk.CleverTapAPI;
import com.example.mylibrary.Summation;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        CleverTapAPI.setDebugLevel(3);

        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("Name", "sunny lib 123");    // String
        profileUpdate.put("Identity", "sunnylib");      // String or number

        clevertapDefaultInstance.onUserLogin(profileUpdate);

        final Button button = findViewById(R.id.button);
        final Button loginChange = findViewById(R.id.loginchange);
        TextView text = findViewById(R.id.centertext);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Random rand = new Random();
                int rand_int1 = rand.nextInt(1000);
                int rand_int2 = rand.nextInt(1000);

                Summation summation = new Summation(rand_int1, rand_int2);
                int total = summation.sum(getApplicationContext());

                text.setText(rand_int1 + " + " + rand_int2 + " = " + total + "");
            }
        });

        loginChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Random rand = new Random();
                int rand_int1 = rand.nextInt(1000);

                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                profileUpdate.put("Name", "sunny lib " + rand_int1);    // String
                profileUpdate.put("Identity", "sunnylib " + rand_int1);      // String or number

                text.setText("sunnylib " + rand_int1);

                clevertapDefaultInstance.onUserLogin(profileUpdate);
            }
        });


    }
}