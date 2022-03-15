package com.example.week4network.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.week4network.Entity.DutyPharmacy;
import com.example.week4network.Util.LocationDirector;
import com.example.week4network.databinding.ActivityDutyPharmacyDetailBinding;

public class DutyPharmacyDetailActivity extends AppCompatActivity {


    ActivityDutyPharmacyDetailBinding activityDutyPharmacyDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activityDutyPharmacyDetailBinding = ActivityDutyPharmacyDetailBinding.inflate(getLayoutInflater());
        View view = activityDutyPharmacyDetailBinding.getRoot();
        setContentView(view);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            DutyPharmacy dutyPharmacy = getIntent().getExtras().getParcelable("dutyPharmacyObject");
            activityDutyPharmacyDetailBinding.adressTxt.setText(dutyPharmacy.getAddress());
            activityDutyPharmacyDetailBinding.distTxt.setText(dutyPharmacy.getDist());
            activityDutyPharmacyDetailBinding.titleTxt.setText(dutyPharmacy.getName());
            activityDutyPharmacyDetailBinding.phoneTxt.setText(dutyPharmacy.getPhone());

            activityDutyPharmacyDetailBinding.goBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoMap(dutyPharmacy.getLoc());

                }
            });



        }
    }

    private void gotoMap(String locStringData)
    {
        String[] separated = locStringData.split(",");

        LocationDirector.getInstance().openLocation(this,Double.parseDouble(separated[0]),Double.parseDouble(separated[1]));

    }

}