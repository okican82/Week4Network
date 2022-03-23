package com.example.week4network.Retrofit.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.week4network.Retrofit.Network.Request.NetworkRequest;
import com.example.week4network.Retrofit.Network.Request.NetworkRequestListener;
import com.example.week4network.databinding.ActivityCallApidifferentClassBinding;


public class CallAPIDifferentClassActivity extends AppCompatActivity implements NetworkRequestListener {

    ActivityCallApidifferentClassBinding activityCallApidifferentClassBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCallApidifferentClassBinding = ActivityCallApidifferentClassBinding.inflate(getLayoutInflater());
        View view = activityCallApidifferentClassBinding.getRoot();
        setContentView(view);

        activityCallApidifferentClassBinding.getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void getData()
    {
        showProgress();
        NetworkRequest networkRequest = new NetworkRequest(this);
        networkRequest.getRequest();
    }

    private void showProgress()
    {
        activityCallApidifferentClassBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress()
    {
        activityCallApidifferentClassBinding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess() {
        hideProgress();
        Log.d("TAG", "onSuccess: ");
    }

    @Override
    public void onFail() {
        hideProgress();
        Log.d("TAG", "onFail: ");
    }
}