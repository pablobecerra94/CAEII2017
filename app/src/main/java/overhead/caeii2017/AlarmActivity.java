package overhead.caeii2017;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AlarmActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        Bundle bundle = getIntent().getExtras();
        String title= bundle.getString("Title");
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
