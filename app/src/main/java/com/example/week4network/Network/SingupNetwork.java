package com.example.week4network.Network;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SingupNetwork {

    private SignUpListener signUpListener;


    public SingupNetwork(SignUpListener signUpListener) {
        this.signUpListener = signUpListener;
    }

    public void signup(String username, String password)
    {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"email\":\"" + username + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}");
        Request request = new Request.Builder()
                .url("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyBwi7VewRmOTTxyj-j9WWpSUEpejETM7mI")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                e.printStackTrace();
                signUpListener.failed();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if(response.isSuccessful())
                {

                    final String myResponse = response.body().string();
                    signUpListener.success();

                }
            }
        });

    }
}
