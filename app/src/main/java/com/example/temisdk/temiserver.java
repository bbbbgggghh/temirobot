package com.example.temisdk;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class temiserver extends AppCompatActivity {

    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        client = new OkHttpClient();

        Button button1 = findViewById(R.id.btn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest("순찰 모드 ON");
            }
        });
    }

    private void sendRequest(String message) {
        String url = "https://6k5q9dxxj2.execute-api.ap-northeast-2.amazonaws.com/test";
        String json = "{\"message\": \"순찰 모드 ON\"}";

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"), json))
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 요청 실패 처리
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string(); // 응답에서 JSON 문자열 가져오기

                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        String isParam = jsonObject.getString("isparam");
                        if (isParam.contains("@")) {
                            // '@' 문자에 해당하는 곳으로 이동 하게끔
                        } else {
                            // '@' 문자를 찾지 못했을 때 .. 없을 수가 없긴 함
                        }
                    } catch (JSONException e) {
                        // JSON 파싱 예외 처리
                    }
                } else {
                    // 요청 실패시 다시 달라고 하기
                }
            }
        });
    }
}
