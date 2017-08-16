package com.example.francisco.w3d2weekday;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStaticBoradcast, btnStaticBoradcast2, btnDynamicBroadcast;
    EditText TypeSomeText;

    MyDynamicReceiver myDynamicReceiver;
    IntentFilter intentFilter;

    TextView etchanged;

    RecyclerView rvRandomsList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStaticBoradcast = (Button) findViewById(R.id.btnStaticBoradcast);
        btnStaticBoradcast2 = (Button) findViewById(R.id.btnStaticBoradcast2);
        btnDynamicBroadcast = (Button) findViewById(R.id.btnDynamicBroadcast);
        TypeSomeText = (EditText) findViewById(R.id.TypeSomeText);

        btnStaticBoradcast.setOnClickListener(this);
        btnStaticBoradcast2.setOnClickListener(this);
        btnDynamicBroadcast.setOnClickListener(this);

        etchanged = (TextView) findViewById(R.id.etchanged);

        rvRandomsList = (RecyclerView) findViewById(R.id.rvRandomsList);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        itemAnimator = new DefaultItemAnimator();
        rvRandomsList.setLayoutManager(layoutManager);
        rvRandomsList.setItemAnimator(itemAnimator);

        myDynamicReceiver = new MyDynamicReceiver(etchanged, rvRandomsList);

        for(int i = 0; i<(new Random()).nextInt(100); i++) {
            Intent intIntent = new Intent(this, RandomObjectsService.class);
            intIntent.setAction("createObject");
            startService(intIntent);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStaticBoradcast:
                Intent intent = new Intent();
                intent.setAction("myAction");
                sendBroadcast(intent);
                break;
            case R.id.btnStaticBoradcast2:
                Intent intent1 = new Intent();
                intent1.setAction("myAction2");
                sendBroadcast(intent1);
                break;
            case R.id.btnDynamicBroadcast:
                Intent intent2 = new Intent();
                intent2.setAction("TypeMessage");
                intent2.putExtra("value1",TypeSomeText.getText().toString());
                sendBroadcast(intent2);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        intentFilter = new IntentFilter("doSomethingElse");
        intentFilter.addAction("doSomething");
        intentFilter.addAction("TypeMessage");
        intentFilter.addAction("randomListact");
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_APP_ERROR);
        intentFilter.addAction(Intent.ACTION_BATTERY_OKAY);
        intentFilter.addAction(Intent.ACTION_CAMERA_BUTTON);
        intentFilter.addAction(Intent.ACTION_USER_BACKGROUND);
        intentFilter.addAction(Intent.ACTION_SET_WALLPAPER);

        registerReceiver(myDynamicReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        //unregisterReceiver(myDynamicReceiver);
    }
}
