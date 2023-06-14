package com.example.temisdk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import okhttp3.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.robotemi.sdk.Robot;

public class MainActivity1 extends AppCompatActivity {

    private Robot robot;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    NetworkTask networkTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        FirebaseApp.initializeApp(this);

        robot = Robot.getInstance();

        networkTask = new NetworkTask();

        databaseReference.child("sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object loc = snapshot.getValue();
                String location = String.valueOf(loc);
                if(location == "1"){
                    robot.goTo("E"); //센서위치로 이동
                    networkTask.location = "E";
                    networkTask.execute();
                    databaseReference.child("sensor").setValue(0);
                    Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                else if(location == "2"){
                    robot.goTo("F"); //센서위치로 이동
                    networkTask.location = "F";
                    networkTask.execute();
                    databaseReference.child("sensor").setValue(0);
                    Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    return;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
