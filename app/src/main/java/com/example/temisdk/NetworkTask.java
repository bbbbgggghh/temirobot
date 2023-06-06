package com.example.temisdk;

import android.os.AsyncTask;
import android.util.Log;

import okhttp3.*;

public class NetworkTask extends AsyncTask<Void, Void, String> {
    String location = "A" ;
    @Override
    protected String doInBackground(Void... params) {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            String json = "{\"location\":\"" + location + "\"}";
            RequestBody requestBody = RequestBody.create(json, mediaType);

            // Create a Request with the URL 및 Request Body 설정
            Request request = new Request.Builder()
                    .url("https://6k5q9dxxj2.execute-api.ap-northeast-2.amazonaws.com/test") // 실제 서버의 URL로 대체
                    .post(requestBody) // POST 요청 설정
                    .build();

            // Create a Request with the URL
//            Request request = new Request.Builder()
//                    .url("https://6k5q9dxxj2.execute-api.ap-northeast-2.amazonaws.com/test") // Replace with the actual URL of your server
//                    .build();

            try (Response response = client.newCall(request).execute()) {
                // Handle the response
                return response.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Process the result on the main thread
        if (result != null) {
            Log.d("NetworkTask", "Response: " + result);
        } else {
            Log.e("NetworkTask", "Error occurred during network operation");
        }
    }
}
