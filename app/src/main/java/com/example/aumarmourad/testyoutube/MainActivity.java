package com.example.aumarmourad.testyoutube;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    EarplugReceiver myEarPlugReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // unregisterReceiver(myEarPlugReceiver);

        setContentView(R.layout.activity_main);
        ImageView luffy = findViewById(R.id.luffy);

        luffy.setOnTouchListener(this);
        intentFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        myEarPlugReceiver= new EarplugReceiver();
        registerReceiver(myEarPlugReceiver,intentFilter);


    }
    //pour l'ecouteur
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myEarPlugReceiver);     // j'ecoute plus


    }

    @Override
    protected void onRestart() {
        super.onRestart();

         registerReceiver(myEarPlugReceiver,intentFilter);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

       Intent zoroIntent = new Intent(MainActivity.this, ZoroView.class);
        startActivity(zoroIntent);

        return false;
    }
}
