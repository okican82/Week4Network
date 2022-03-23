package com.example.week4network.Retrofit.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.week4network.databinding.ActivityRetrofitBinding;

public class RetrofitActivity extends AppCompatActivity {

    ActivityRetrofitBinding activityRetrofitBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRetrofitBinding = ActivityRetrofitBinding.inflate(getLayoutInflater());
        View view = activityRetrofitBinding.getRoot();
        setContentView(view);


        activityRetrofitBinding.openDifferentClassApiCallActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDifferentClassAPICall();
            }
        });

        activityRetrofitBinding.openIntroductionActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntroductionActivity();
            }
        });

    }

    private void openIntroductionActivity()
    {
        startActivity(new Intent(RetrofitActivity.this,IntroductionRetrofitActivity.class));
    }

    private void openDifferentClassAPICall() {
        startActivity(new Intent(RetrofitActivity.this,CallAPIDifferentClassActivity.class));
    }




}