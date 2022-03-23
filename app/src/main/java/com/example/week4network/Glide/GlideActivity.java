package com.example.week4network.Glide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.week4network.R;
import com.example.week4network.databinding.ActivityGlideBinding;


public class GlideActivity extends Activity {

    ActivityGlideBinding activityGlideBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGlideBinding = ActivityGlideBinding.inflate(getLayoutInflater());
        View view = activityGlideBinding.getRoot();
        setContentView(view);

        activityGlideBinding.getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityGlideBinding.getDataButton.setVisibility(View.GONE);
                loadImage();
            }
        });



    }

    private void loadImage()
    {
        String imageUrl = "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_Ratio0.6716_AL_.jpg";
        Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .placeholder(R.drawable.image_place_holder)
                .error(R.drawable.image_error)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(activityGlideBinding.actionImage);

    }
}