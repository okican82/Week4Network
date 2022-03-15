package com.example.week4network.Util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class LocationDirector {

    private static LocationDirector instance;

    public LocationDirector()
    {

    }

    public static LocationDirector getInstance()
    {
        if(instance == null)
        {
            instance = new LocationDirector();
        }
        return instance;

    }

    public void openLocation(Context context, double latitude, double longitude)
    {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr="+ latitude + "," + longitude));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
