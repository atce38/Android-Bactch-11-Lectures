package com.abidingtech.www.androidbactch11.Lecture26;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.abidingtech.www.androidbactch11.Lecture25.WifiActivity;
import com.abidingtech.www.androidbactch11.R;

public class BgService extends Service {
    public static final String CHANNEL_ID = "ForegroundServiceChannel";
    public BgService() {
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");
        createNotificationChannel();
        Intent notificationIntent = new Intent(this, WifiActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Foreground Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1, notification);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.post(this);
                Toast.makeText(BgService.this, "Service is Started...", Toast.LENGTH_SHORT).show();

            }
        },6000);

        return START_STICKY;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed!", Toast.LENGTH_SHORT).show();
//        Intent serviceIntent=new Intent(this, BgService.class);
//        startService(serviceIntent);
    }
}