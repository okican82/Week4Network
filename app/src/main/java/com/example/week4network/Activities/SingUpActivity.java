package com.example.week4network.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.week4network.R;
import com.example.week4network.Network.SignUpListener;
import com.example.week4network.Network.SingupNetwork;
import com.example.week4network.databinding.ActivitySingInBinding;

public class SingUpActivity extends AppCompatActivity implements SignUpListener {

    ActivitySingInBinding activitySingInBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activitySingInBinding = ActivitySingInBinding.inflate(getLayoutInflater());
        View view = activitySingInBinding.getRoot();
        setContentView(view);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle(R.string.sing_up);

        activitySingInBinding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    private void signUp()
    {
        SingupNetwork singupNetwork = new SingupNetwork(this);
        singupNetwork.signup("okay1@gmail.com","111111");
    }

    @Override
    public void success() {
        Toast.makeText(getApplicationContext(), "success",Toast.LENGTH_SHORT);
    }

    @Override
    public void failed() {
        Toast.makeText(getApplicationContext(), "failed",Toast.LENGTH_SHORT);
    }
}