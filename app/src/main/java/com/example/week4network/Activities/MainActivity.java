package com.example.week4network.Activities;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.week4network.Entity.UserLoginData;
import com.example.week4network.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends Activity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);



        activityMainBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser(activityMainBinding.userNameTxt.getText().toString(),activityMainBinding.userPassTxt.getText().toString());

            }
        });
        activityMainBinding.singUpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSingIn();
            }
        });

    }

    private void navigateToSingIn() {
        startActivity(new Intent(MainActivity.this, SingUpActivity.class));
    }

    private void loginUser(String userName,String userPass)
    {
        if(!TextUtils.isEmpty(userName) && Patterns.EMAIL_ADDRESS.matcher(userName).matches())
        {
            if(!TextUtils.isEmpty(userPass))
            {
                //makeLoginUserAsync(userName,userPass);
                makeLoginRequestWithCallBack(userName,userPass);
                //makeLoginRequest(userName,userPass);
            }
            else
            {
                //passValid Değil
            }
        }
        else
        {
            //email adresi valid değil
        }

    }

    private void showProgressbar()
    {
        activityMainBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar()
    {
        activityMainBinding.progressBar.setVisibility(View.GONE);
    }

    private void makeLoginRequest(String userName, String userPass)  {

        showProgressbar();

        Response response;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"email\":\"okay.yildirim1@gmail.com\",\n    \"password\": \"111111\",\n    \"returnSecureToken\" : true\n}");
        Request request = new Request.Builder()
                .url("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyBwi7VewRmOTTxyj-j9WWpSUEpejETM7mI")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            response = client.newCall(request).execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        hideProgressbar();
    }

    private void makeLoginRequestWithCallBack(String userName,String userPass)  {

        showProgressbar();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"email\":\"" + userName+ "\",\n    \"password\": \"" + userPass + "\",\n    \"returnSecureToken\" : true\n}");
        Request request = new Request.Builder()
                .url("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyBwi7VewRmOTTxyj-j9WWpSUEpejETM7mI")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                hideProgressbar();
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if(response.isSuccessful())
                {

                    final String myResponse = response.body().string();

                    UserLoginData userLoginData = new Gson().fromJson(myResponse, UserLoginData.class);

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hideProgressbar();
                            startActivity(new Intent(MainActivity.this,DataDisplayActivity.class));
                        }
                    });
                }
            }
        });

    }

    private void makeLoginUserAsync(String userName, String userPass)
    {
        loginUserAsync asyncLogin = new loginUserAsync();
        asyncLogin.execute(activityMainBinding.userNameTxt.getText().toString(),activityMainBinding.userPassTxt.getText().toString());
    }

    private class loginUserAsync extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showProgressbar();
                }
            });

        }

        @Override
        protected String doInBackground(String... params) {

            Response response;

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n    \"email\":\"okay.yildirim@gmail.com\",\n    \"password\": \"111111\",\n    \"returnSecureToken\" : true\n}");
            Request request = new Request.Builder()
                    .url("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyBwi7VewRmOTTxyj-j9WWpSUEpejETM7mI")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            try {
                response = client.newCall(request).execute();

                return response.toString();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return "";
            }
        }

        @Override
        protected void onPostExecute(String serviceResult) {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hideProgressbar();
                }
            });
            if (serviceResult.length() > 0) {
                startActivity(new Intent(MainActivity.this,DataDisplayActivity.class));
                //UserLoginData userLoginData = new Gson().fromJson(serviceResult., UserLoginData.class);

            }
        }

    }
}