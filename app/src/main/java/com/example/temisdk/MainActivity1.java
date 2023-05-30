package com.example.temisdk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;

public class MainActivity1 extends AppCompatActivity {

    private Button btn;

    private Robot robot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button btn =(Button)findViewById(R.id.btn);
        robot = Robot.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //서버에서 센서 신호 받아서 이동, 위치 알림 보내기, 암구호 요청(입력페이지 필요함 intent),
                //암구호 입력시 홈베이스 이동, 미입력시 촬영 및 따라가기, 관리자 도착시 홈베이스



                //서버에 야간경비 시작했다고 보냄 -> 인체감지 센서 활성화

                //서버에서 센서신호 받음
                robot.goTo("A"); //센서위치로 이동
                //서버로 테미 위치 보내기

                //암구호 입력창 인텐트
                //if 암구호 입력 성공
                robot.goTo("B"); //홈베이스로 이동
                  //  else
                robot.beWithMe(); //따라가기

                //관리자 도착 시
                //robot.goTo("B");

            }
        });
    }
}
