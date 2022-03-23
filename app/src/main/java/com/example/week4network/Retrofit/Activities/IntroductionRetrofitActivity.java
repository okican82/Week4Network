package com.example.week4network.Retrofit.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.week4network.Retrofit.Network.RetrofitAPI;
import com.example.week4network.databinding.ActivityIntroductionRetrofitBinding;


import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IntroductionRetrofitActivity extends AppCompatActivity {

    ActivityIntroductionRetrofitBinding activityIntroductionRetrofitBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityIntroductionRetrofitBinding = ActivityIntroductionRetrofitBinding.inflate(getLayoutInflater());
        View view = activityIntroductionRetrofitBinding.getRoot();
        setContentView(view);


        activityIntroductionRetrofitBinding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleGet();
            }
        });

        activityIntroductionRetrofitBinding.getUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUsers();
            }
        });

        activityIntroductionRetrofitBinding.postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postUser();
            }
        });

        activityIntroductionRetrofitBinding.getUserByIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserById(1);
            }
        });

        activityIntroductionRetrofitBinding.getUserByIdAndPostIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPostByUserIdAndPostId(1,2);
            }
        });

        activityIntroductionRetrofitBinding.getHashmapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap parametersHashmap = new HashMap<>();
                parametersHashmap.put("userId","1");
                parametersHashmap.put("id","2");

                getByHashmap(parametersHashmap);
            }
        });

        activityIntroductionRetrofitBinding.changeThePartOfTheUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeThePartOfTheURL(1);
            }
        });

        activityIntroductionRetrofitBinding.getDifferentEndpointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDifferentEndpoint();
            }
        });

        activityIntroductionRetrofitBinding.sendRequestWithHeaderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequestWithHeader();
            }
        });

        activityIntroductionRetrofitBinding.sendRequestWithHeaderDynamicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequestWithHeaderDynamic();
            }
        });

        activityIntroductionRetrofitBinding.loggingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logging();
            }
        });
    }

    private void logging() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.NONE);
//        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.sendRequestWithHeader().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    private void sendRequestWithHeaderDynamic() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        String contentType = "application/json";
        String userAgent = "RetrofitExample";

        retrofitAPI.sendRequestWithHeaderDynamic(contentType,userAgent).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    private void sendRequestWithHeader() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.sendRequestWithHeader().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");

                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }


    private void getDifferentEndpoint() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getDifferentEndpoint().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });


        retrofitAPI.sendRequest("https://api.ipify.org/").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });


    }

    private void changeThePartOfTheURL(int userId)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getPostById(userId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    private void getByHashmap(HashMap hashMap)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getPostByParams(hashMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    private void getPostByUserIdAndPostId(int userId, int postId)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getPostsByUserAndPostId(userId,postId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");

                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    private void getUserById(int userId)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getPostsByUser(userId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void postUser()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        String jsonBody = "{\"id\":100,\"name\":\"Okay YILDIRIM\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);

        retrofitAPI.postUser(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if(response.isSuccessful())
                    {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    private void getUsers()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getUsers().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    private void simpleGet()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getPosts().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d("TAG", "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });

    }
}