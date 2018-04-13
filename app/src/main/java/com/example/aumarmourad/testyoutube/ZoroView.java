package com.example.aumarmourad.testyoutube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ZoroView extends AppCompatActivity implements View.OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoro_view);
        ImageView zoro = findViewById(R.id.zoro);
        zoro.setOnTouchListener(this);


    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }

        return false;
    }
}
