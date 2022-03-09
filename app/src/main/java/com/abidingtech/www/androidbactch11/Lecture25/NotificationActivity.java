package com.abidingtech.www.androidbactch11.Lecture25;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abidingtech.www.androidbactch11.Lecture23.CUDActivity;
import com.abidingtech.www.androidbactch11.R;

public class NotificationActivity extends AppCompatActivity {

    Button btnSHowNotification;
    String CHANNEL_ID="someID",CHANNEL_NAME="SOME_NAME";
    int abc=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btnSHowNotification=findViewById(R.id.btnSHowNotification);

        btnSHowNotification.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                showNotification();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showNotification() {
        ++abc;
        Intent intent=new Intent(this, CUDActivity.class);
        PendingIntent pendingIntent=PendingIntent.
                getActivity(this,12,intent,PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Sme Title")
                .setContentText("Some Message Some Message Some MessageSome Message Some Message Some Message Some Message ")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Some Message Some Message Some MessageSome Message Some Message Some Message Some Message "))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManager manager=getSystemService(NotificationManager.class);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Some Description");
            builder.setChannelId(CHANNEL_ID);
            manager.createNotificationChannel(channel);
        }

        manager.notify(abc,builder.build());

    }
}