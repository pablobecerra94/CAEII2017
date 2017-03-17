package overhead.caeii2017;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class VisitItem extends AppCompatActivity {
    private CheckBox checkBox;
    private TextView name;
    private TextView duration;
    private TextView address;
    private TextView date;
    private TextView turn1;
    private TextView place;
    private Spinner spinner;
    private int day;
    private int month;
    private int year;
    private String visitName;
    private String turnNumber;
    private SQLiteDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_test1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        name = (TextView) findViewById(R.id.nameTextView);
        duration = (TextView) findViewById(R.id.durationTextView);
        address = (TextView) findViewById(R.id.addressTextView);
        date = (TextView) findViewById(R.id.dayTextView);
        turn1 = (TextView) findViewById(R.id.turn1TextView);
        place = (TextView) findViewById(R.id.placeTextView);

        Bundle bundle = getIntent().getExtras();
        visitName = bundle.getString("VisitName");
        setTitle(visitName);
        name.setText("");

        SqliteConector conector = new SqliteConector(this, "DBCaeii2017", null, 1);

      //  SQLiteDatabase database = conector.getReadableDatabase();
         database = conector.getWritableDatabase();

        if (database != null) {
            String[] durationField = {"duration"};
            String[] arguments = {visitName};
            Cursor cursor = database.query("TechnicalVisits", durationField, "name=?", arguments, null, null, null);
            if (cursor.moveToFirst()) {
                String text = cursor.getString(0);
                duration.setText(text + " minutos");

            }


            String[] addressField = {"address"};
            cursor = database.query("TechnicalVisits", addressField, "name=?", arguments, null, null, null);

            if (cursor.moveToFirst()) {
                String text = cursor.getString(0);
                address.setText(text);
            }

            String[] dayFields = {"day", "month", "year"};
            cursor = database.query("TechnicalVisits", dayFields, "name=?", arguments, null, null, null);

            if (cursor.moveToFirst()) {
                day = cursor.getInt(0);
                month = cursor.getInt(1);
                year = cursor.getInt(2);
                String text = cursor.getString(0) + "/" + cursor.getString(1) + "/" + cursor.getString(2);
                date.setText(text);
            }

            String[] placeField = {"place"};
            cursor = database.query("TechnicalVisits", placeField, "name=?", arguments, null, null, null);

            if (cursor.moveToFirst()) {
                String text = cursor.getString(0);
                place.setText(text);
            }

            String[] fields = {"hour", "minute"};
            cursor = database.query("Turns", fields, "name=?", arguments, null, null, null);
            int count = 0;
            while (cursor.moveToNext()) {

                String hour = cursor.getString(0);
                String minute = cursor.getString(1);
                if (count != 0) {

                    turn1.setText(Integer.valueOf(minute) >= 10 ? turn1.getText() + "\n" + String.valueOf(count + 1) + "º Turno " + hour + ":" + minute : turn1.getText() + "\n" + String.valueOf(count + 1) + "º Turno " + hour + ":0" + minute);

                } else {
                    turn1.setText(Integer.valueOf(minute) >= 10 ? String.valueOf(count + 1) + "º Turno " + hour + ":" + minute : String.valueOf(count + 1) + "º Turno " + hour + ":0" + minute);
                }
                count++;


            }
            ArrayList<String> list = new ArrayList<>();


            while (count != 0) {
                list.add(count + "º Turno");
                count--;
            }

            String[] opcions = list.toArray(new String[list.size()]);


            spinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcions);
            spinner.setAdapter(adapter);


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                    turnNumber = spinner.getSelectedItem().toString().substring(0, 1);
                    changeCheckBox();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {

                }

            });

           // database.close();
        }
    }

    private void changeCheckBox() {
        String[] fields = {"alarm"};
        String[] arguments = {visitName,turnNumber};
        Cursor cursor = database.query("Turns", fields, "name=? AND number=?", arguments, null, null, null);
        if(cursor.moveToFirst()){
            if(cursor.getString(0).equals("True")){
                checkBox.setChecked(true);
            }else{
                checkBox.setChecked(false);
            }
        }
    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivities(View view) {
        startActivity(new Intent(this, AboutUsActivity.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void alarm(View view) {
        int id=0;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);


       // SqliteConector conector = new SqliteConector(this, "DBCaeii2017", null, 1);
      //  SQLiteDatabase database = conector.getReadableDatabase();
        if (database != null) {
            String[] durationField = {"hour", "minute","id"};
            String[] arguments = {visitName, turnNumber};
            Cursor cursor = database.query("Turns", durationField, "name=? AND number=?", arguments, null, null, null);
            if (cursor.moveToFirst()) {
                cal.set(Calendar.HOUR_OF_DAY, cursor.getInt(0));
                cal.set(Calendar.MINUTE, cursor.getInt(1));
                id=cursor.getInt(2);

            }
        }
        AlarmManager objAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if (checkBox.isChecked()) {

            Calendar today = Calendar.getInstance();
            if (cal.compareTo(today) >= 0) {

                //  launchNotification(cal);
                launchAlarm(objAlarmManager, cal,id);

            }

            ContentValues values= new ContentValues();
            values.put("alarm","True");

            String[] updateArguments={visitName,turnNumber};
            database.update("Turns",values,"name=? AND number=?",updateArguments);
           // database.close();
        }
        else{
            ContentValues values= new ContentValues();
            values.put("alarm","False");

            String[] updateArguments={visitName,turnNumber};
            database.update("Turns",values,"name=? AND number=?",updateArguments);
            stopAlarm(objAlarmManager,cal,id);
        }
    }

    private void stopAlarm(AlarmManager objAlarmManager, Calendar cal,int id) {

        Intent alarmShowIntent = new Intent(getApplicationContext(), AlarmActivity.class);
        alarmShowIntent.putExtra("Title", visitName);
        PendingIntent alarmPendingIntent = PendingIntent.getActivity(getApplicationContext(), id, alarmShowIntent, 0);
        objAlarmManager.cancel(alarmPendingIntent);
    }

    private void launchAlarm(AlarmManager objAlarmManager, Calendar cal,int id) {
        Intent alarmShowIntent = new Intent(getApplicationContext(), AlarmActivity.class);
        alarmShowIntent.putExtra("Title", visitName);
        PendingIntent alarmPendingIntent = PendingIntent.getActivity(getApplicationContext(), id, alarmShowIntent, 0);
        AlarmCounter.add();

        objAlarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), alarmPendingIntent);


    }

    @Override
    public void onBackPressed() {
        database.close();
        this.finish();
    }

}
