package com.example.temisdk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.temisdk.temi.CustomTtsListener;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnBeWithMeStatusChangedListener;

import java.util.Timer;
import java.util.TimerTask;

import org.jetbrains.annotations.NotNull;

public class MainActivity2 extends AppCompatActivity {
    Button btn;
    EditText et;
    Robot robot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = (Button) findViewById(R.id.btn);
        et = (EditText) findViewById(R.id.edt);
        robot = Robot.getInstance();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                robot.beWithMe();
                //관리자 호출
            }
        };

        timer.schedule(task, 40000);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(et.getText().toString().length() == 0){
                    return;
                }

                if(Integer.parseInt(et.getText().toString()) == 123456){
                    robot.goTo("B");
                    Intent intent = new Intent(MainActivity2.this, MainActivity1.class);
                    startActivity(intent);
                }
                else{
                    robot.beWithMe();
                    //관리자 호출
                }
            }
        });

    }
}