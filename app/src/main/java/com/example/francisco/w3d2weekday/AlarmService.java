package com.example.francisco.w3d2weekday;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;


public class AlarmService extends Service {
    static MediaPlayer mp3;

    public void Play() {
        if(mp3 ==null) {
            mp3 = MediaPlayer.create(getApplicationContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
            mp3.start();
        }
        if(!mp3.isPlaying()) {
            mp3.start();
        }
    }

    @Override

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service alarm: "+intent.getStringExtra("element"), Toast.LENGTH_LONG).show();
        Play();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override

    public IBinder onBind(Intent intent) {
//        Toast.makeText(this, "MyAlarmService.onBind()", Toast.LENGTH_LONG).show();
        return null;

    }


    @Override

    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "MyAlarmService.onDestroy()", Toast.LENGTH_LONG).show();
    }


    @Override

    public boolean onUnbind(Intent intent) {
//        Toast.makeText(this, "MyAlarmService.onUnbind()", Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }
}
