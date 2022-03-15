package com.example.week4network.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.week4network.R;
import com.example.week4network.databinding.ActivitySingInBinding;

public class SingInActivity extends AppCompatActivity {

    ActivitySingInBinding activitySingInBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        activitySingInBinding = ActivitySingInBinding.inflate(getLayoutInflater());
        View view = activitySingInBinding.getRoot();
        setContentView(view);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle(R.string.sing_up);


    }
}