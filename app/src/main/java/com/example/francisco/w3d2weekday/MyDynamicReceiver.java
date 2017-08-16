package com.example.francisco.w3d2weekday;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by FRANCISCO on 15/08/2017.
 */

public class MyDynamicReceiver extends BroadcastReceiver{

    TextView etchanged;
    RecyclerView rvRandomsList;

    public MyDynamicReceiver() {}

    public MyDynamicReceiver(TextView etchanged, RecyclerView rvRandomsList) {
        this.etchanged = etchanged;
        this.rvRandomsList = rvRandomsList;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "I am a dynamic receiver", Toast.LENGTH_SHORT).show();
        try{etchanged.setText(intent.getAction().toString());}catch(Exception ex){}
        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Airplane changed", Toast.LENGTH_LONG).show();
                //etchanged.setText("Airplane changed");
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Power connected", Toast.LENGTH_LONG).show();
//                etchanged.setText("Power connected");
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Power disconnected", Toast.LENGTH_LONG).show();
//                etchanged.setText("Power disconnected");
                break;
            case Intent.ACTION_SCREEN_ON:
                Toast.makeText(context, "Screen on", Toast.LENGTH_LONG).show();
//                etchanged.setText("Screen on");
                break;
            case Intent.ACTION_SCREEN_OFF:
                Toast.makeText(context, "Screen off", Toast.LENGTH_LONG).show();
//                etchanged.setText("Screen off");
                break;
            case Intent.ACTION_SET_WALLPAPER:
                Toast.makeText(context, "Set wallpaper", Toast.LENGTH_LONG).show();
//                etchanged.setText("Set wallpaper");
                break;
            case "randomListact":
                Log.d("a", "onReceive: RandomListact");

                ArrayList<RandomObjects> randomList = intent.getParcelableArrayListExtra("randomList");
                //initialize the adapter
                RandomListAdapter randomsListAdapter = new RandomListAdapter(randomList);
                rvRandomsList.setAdapter(randomsListAdapter);
                randomsListAdapter.notifyDataSetChanged();

                break;
        }
    }
}
