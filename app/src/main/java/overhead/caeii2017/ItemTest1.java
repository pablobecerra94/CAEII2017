package overhead.caeii2017;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.Calendar;

public class ItemTest1 extends AppCompatActivity {
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_test1);

        checkBox=(CheckBox) findViewById(R.id.checkBox);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void alarm(View view){
        if(checkBox.isChecked()){
            AlarmManager objAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH,31);
            cal.set(Calendar.MONTH,Calendar.JANUARY);
            cal.set(Calendar.YEAR,2017);
            cal.set(Calendar.HOUR_OF_DAY, 18);
            cal.set(Calendar.MINUTE, 27);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            Intent alamShowIntent = new Intent(this,AlarmActivity.class);
            PendingIntent alarmPendingIntent = PendingIntent.getActivity(this, 0,alamShowIntent,0 );

            objAlarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), alarmPendingIntent);
        }

    }
}
