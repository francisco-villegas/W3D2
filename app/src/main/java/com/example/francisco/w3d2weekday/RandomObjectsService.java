package com.example.francisco.w3d2weekday;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class RandomObjectsService extends IntentService {

    private static final String TAG = "RandomObjectsService";
    MyDynamicReceiver myDynamicReceiver;
    IntentFilter intentFilter;

    public int imgs[]={
            R.drawable.bruno,
            R.drawable.agapornis,
            R.drawable.arana,
            R.drawable.camera,
            R.drawable.fish,
            R.drawable.frog,
            R.drawable.reptile,
            R.drawable.husky
    };

    public RandomObjectsService() {
        super("RandomObjects");
    }
    ArrayList<RandomObjects> randomList = new ArrayList<>();
    SecureRandom randomS = new SecureRandom();
    @Override
    protected void onHandleIntent(Intent intent) {
        switch(intent.getAction()) {
            case "createObject":
//                for(int i=0;i<(new Random()).nextInt(100 - 1);i++) {
                    String random1 = new BigInteger(130, randomS).toString(32);
                    double random2 = ((double)(new Random()).nextInt(100000 - 1))/100;
                    int random3 = (new Random()).nextInt(1000 - 1);
                    int random4 = imgs[(new Random()).nextInt(8)];
                    randomList.add(new RandomObjects(random1, random2, random3, random4));
                    Log.d(TAG, "onHandleIntent: "+random1+" "+random2+" "+random3+" "+random4);
//                }
                break;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onHandleIntent: "+(new Random()).nextInt(100 - 1));
        Intent intent2 = new Intent();
        intent2.setAction("randomListact");
        intent2.putExtra("randomList",randomList);
        sendBroadcast(intent2);
        super.onDestroy();
    }
}
