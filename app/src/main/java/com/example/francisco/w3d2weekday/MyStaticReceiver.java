package com.example.francisco.w3d2weekday;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyStaticReceiver extends BroadcastReceiver {

    private static final String TAG = "MyStaticReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case "myAction":
                Log.d(TAG, "onReceive: myAction");
                break;
            case "myAction2":
                Log.d(TAG, "onReceive: myAction2");
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Airplane changed", Toast.LENGTH_LONG).show();
                break;

        }
//        Log.d(TAG, "onReceive: ");
//        Toast.makeText(context, "onReceive", Toast.LENGTH_SHORT).show();
    }
}
