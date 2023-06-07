package com.example.temisdk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import okhttp3.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.robotemi.sdk.Robot;

public class MainActivity1 extends AppCompatActivity {

    private Button btn;

    private Robot robot;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("sensor");

    NetworkTask networkTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        btn = (Button)findViewById(R.id.btn);
        robot = Robot.getInstance();

        networkTask = new NetworkTask();

        databaseReference.child("sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object location = snapshot.getValue();
                if(location == "A"){
                    robot.goTo("A"); //센서위치로 이동
                    networkTask.location = "A";
                    networkTask.execute();
                    Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(location == "B"){
                    robot.goTo("B"); //센서위치로 이동
                    networkTask.location = "B";
                    networkTask.execute();
                    Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(location == "C"){
                    robot.goTo("C"); //센서위치로 이동
                    networkTask.location = "C";
                    networkTask.execute();
                    Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(location == "D"){
                    robot.goTo("D"); //센서위치로 이동
                    networkTask.location = "D";
                    networkTask.execute();
                    Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
