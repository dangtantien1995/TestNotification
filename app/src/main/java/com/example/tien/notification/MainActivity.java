package com.example.tien.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnTao , btnDong;
    int notificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddEvent();
        AddControl();
    }
    private void AddControl() {
        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taoNotification();
            }

        });

        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dongNotification();
            }
        });
    }

    private void dongNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationId);
    }

    public void taoNotification(){
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Ahhihihi")
                .setContentText("Ban co thong bao moi ");

        //nhấn vào thông báo chuyển sang màn hình khác
        Intent intent = new Intent(this , UpdateActivity.class);
        PendingIntent resultPendingIntent =  PendingIntent.getActivity(this , 0 , intent , PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        //set âm thanh
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mBuilder.setSound(uri);

        notificationId = 113; //id để xác định notification đó
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, mBuilder.build());
    }

    private void AddEvent() {
        btnTao = (Button) findViewById(R.id.buttonTao);
        btnDong = (Button) findViewById(R.id.buttonDong);
        
        OkImFine();
        OkImFine2();
        OkImFine3();
    }

    private void OkImFine3() {
    }

    private void OkImFine2() {
    }

    private void OkImFine() {
    }
    
    
}
