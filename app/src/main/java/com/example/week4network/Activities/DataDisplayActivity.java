package com.example.week4network.Activities;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.week4network.Adapters.DutyPharmacyAdapter;
import com.example.week4network.Entity.DutyPharmacy;
import com.example.week4network.R;
import com.example.week4network.databinding.ActivityDataDisplayBinding;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataDisplayActivity extends Activity {

    private ActivityDataDisplayBinding activityDataDisplayBinding;
    private ArrayList<DutyPharmacy> dutyPharmacyItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDataDisplayBinding = ActivityDataDisplayBinding.inflate(getLayoutInflater());
        View view = activityDataDisplayBinding.getRoot();
        setContentView(view);

        showProgressbar();


        if(haveNetworkConnection())
        {
            getDutyData();
        }
        else
        {
            Toast.makeText(getApplicationContext(), R.string.network_connection_error,Toast.LENGTH_SHORT);
        }


    }

    private void showProgressbar()
    {
        activityDataDisplayBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar()
    {
        activityDataDisplayBinding.progressBar.setVisibility(View.GONE);
    }

    private void getDutyData()
    {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://seng4052022-495da-default-rtdb.firebaseio.com/dutyPharmacy.json")
                .method("GET", null)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                DataDisplayActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hideProgressbar();
                    }
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful())
                {
                    final String myResponse = response.body().string();

                    dutyPharmacyItemList = new ArrayList<DutyPharmacy>();
/*
                    try {
                        JSONArray jsonArray = new JSONArray(myResponse);
                        for(int i = 0;i<jsonArray.length();i++)
                        {
                            //String address, String dist, String loc, String name, String phone
                            //jsonArray.getJSONObject(0).getString("address")
                            DutyPharmacy dutyPharmacy = new DutyPharmacy(
                                    jsonArray.getJSONObject(i).getString("address"),
                                    jsonArray.getJSONObject(i).getString("dist"),
                                    jsonArray.getJSONObject(i).getString("loc"),
                                    jsonArray.getJSONObject(i).getString("name"),
                                    jsonArray.getJSONObject(i).getString("phone")
                            );



                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/

                    DutyPharmacy[] DutyPharmacyList = new Gson().fromJson(myResponse, DutyPharmacy[].class);
                    dutyPharmacyItemList = new ArrayList<DutyPharmacy>(Arrays.asList(DutyPharmacyList));

                    DataDisplayActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hideProgressbar();
                            diplayListData();
                        }
                    });
                }
            }
        });
    }


    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }



    private void diplayListData()
    {
        DutyPharmacyAdapter adapter = new DutyPharmacyAdapter(dutyPharmacyItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        activityDataDisplayBinding.dataListRecyclerView.setLayoutManager(mLayoutManager);
        activityDataDisplayBinding.dataListRecyclerView.setAdapter(adapter);




    }
}
