package com.example.week4network.Retrofit.Network.Request;

import android.util.Log;

import com.example.week4network.Retrofit.Entity.Comment;
import com.example.week4network.Retrofit.Network.RetrofitAPI;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRequest {

    private NetworkRequestListener networkRequestListener;

    public NetworkRequest(NetworkRequestListener networkRequestListener){
        this.networkRequestListener = networkRequestListener;
    }

    public void getRequest()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getCommentById(1).enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                if (response.isSuccessful())
                {
                        Comment comment = response.body();
                        networkRequestListener.onSuccess();
                        Log.d("TAG", "onResponse: ");
                }
                else
                {
                    networkRequestListener.onFail();
                }
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                networkRequestListener.onFail();
                Log.d("TAG", "onFailure: ");
            }
        });
    }
}
