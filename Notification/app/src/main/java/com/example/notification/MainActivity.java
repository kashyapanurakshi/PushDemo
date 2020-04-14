package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                        Notification noti = new Notification.Builder(MainActivity.this)
                                .setTicker("TickerTitle")
                                .setContentTitle("Content Title")
                                .setContentText("Content Text")
                                .setSmallIcon(R.drawable.ic_launcher_foreground)
                                .setContentIntent(pIntent).getNotification();

                        noti.flags = Notification.FLAG_AUTO_CANCEL;
                        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        nm.notify(0,noti);
                    }
                }
        );
    }
}
