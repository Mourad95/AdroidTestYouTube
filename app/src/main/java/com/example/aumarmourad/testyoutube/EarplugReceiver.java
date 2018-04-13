package com.example.aumarmourad.testyoutube;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by aumarmourad on 13/04/2018.
 */

class EarplugReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getIntExtra("state",-1) ==1) {

            Log.d("ecouteur", "je suis dans broadcast receiver");
            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            if (launchIntent != null) {
                context.startActivity(launchIntent);//null pointer check in case package name was not found
            }
        }
    }
}
