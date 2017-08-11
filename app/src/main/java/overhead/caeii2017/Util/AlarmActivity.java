package overhead.caeii2017.Util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import overhead.caeii2017.MainActivity;
import overhead.caeii2017.R;

public class AlarmActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Vibrator vibrator;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("Title");
        setTitle(title);
        mediaPlayer = MediaPlayer.create(this,R.raw.alarm);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();
        long pattern[]={1000,1000};
        vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(vibrator.hasVibrator()) {
            vibrator.vibrate(pattern,0);
        }

        launchNotification();

    }

    private void launchNotification() {


        Intent alarmShowIntent = new Intent(this, MainActivity.class);
        alarmShowIntent.putExtra("Title", title);
        PendingIntent alarmPendingIntent = PendingIntent.getActivity(this, 0, alarmShowIntent, 0);

        Notification noti = new Notification.Builder(getApplicationContext())
                .setContentTitle("Visita Tecnica a " + title)
                .setContentText("esta por empezar")
                .setSmallIcon(R.drawable.ic_launcher)
                //.setLargeIcon(aBitmap)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(alarmPendingIntent)
                .build();

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, noti);

    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void stopAlarm(View view){
        mediaPlayer.stop();
        if(vibrator.hasVibrator()){
            vibrator.cancel();
        }

        finish();
    }


}
