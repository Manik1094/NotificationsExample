package com.example.helloworld.notificationsproject;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.opengl.Visibility;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder builder;
    Button notification_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification_btn = findViewById(R.id.notification_btn);

        sendNotification();


//        notification_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendNotification();
//            }
//        });


    }

//    public void createNotification(NotificationManager notificationManager){
//         builder = new NotificationCompat.Builder(this,"123")
//                .setContentTitle("Test")
//                .setContentText("Hi this is first notification")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                 .setSmallIcon(R.drawable.ic_stat_name)
//                .setAutoCancel(false);
////         .setVisibility(VISIBILITY_PRIVATE);
//        notificationManager.notify(1, builder.build());
//
//
//    }

    public void sendNotification(){
        NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(NOTIFICATION_SERVICE);

        //Create Notification Channel
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("123",name,importance);
            channel.setDescription(description);
            channel.enableVibration(true);
            channel.enableLights(true);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            channel.setLightColor(R.color.colorPrimary);


            notificationManager.createNotificationChannel(channel);
        }


        //Create Notification
        builder = new NotificationCompat.Builder(this,"123")
                .setContentTitle("Test")
                .setContentText("Hi this is first notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setAutoCancel(false);
        notificationManager.notify(1, builder.build());




//        createNotificationChannels(notificationManager);
//        createNotification(notificationManager);
    }

//    public void createNotificationChannels(NotificationManager notificationManager){
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
//            CharSequence name = getString(R.string.channel_name);
//            String description = getString(R.string.channel_description);
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel("123",name,importance);
//            channel.setDescription(description);
//            channel.enableVibration(true);
//            channel.enableLights(true);
//            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
//            channel.setLightColor(R.color.colorPrimary);
//
//
//            notificationManager.createNotificationChannel(channel);
//        }
//    }


}
