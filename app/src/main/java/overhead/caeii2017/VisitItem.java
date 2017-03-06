package overhead.caeii2017;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class VisitItem extends AppCompatActivity {
    private CheckBox checkBox;
    private TextView name;
    private TextView duration;
    private TextView address;
    private TextView day;
    private TextView turn1;

    private  TextView place;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_test1);
        checkBox=(CheckBox) findViewById(R.id.checkBox);
        name= (TextView) findViewById(R.id.nameTextView);
        duration= (TextView) findViewById(R.id.durationTextView);
        address= (TextView) findViewById(R.id.addressTextView);
        day= (TextView) findViewById(R.id.dayTextView);
        turn1= (TextView) findViewById(R.id.turn1TextView);
        place= (TextView) findViewById(R.id.placeTextView);

        Bundle bundle = getIntent().getExtras();
        String visitName=bundle.getString("VisitName");
        setTitle(visitName);
        name.setText("");

        SqliteConector conector = new SqliteConector(this, "DBCaeii2017", null, 1);

        SQLiteDatabase database = conector.getReadableDatabase();

        if(database != null){
            String[] durationField = {"duration"};
            String[] arguments={visitName};
            Cursor cursor = database.query("TechnicalVisits",durationField,"name=?",arguments,null,null,null);
            if(cursor.moveToFirst()){
                String text= cursor.getString(0);
                duration.setText(text+" minutos");

            }


            String[] addressField = {"address"};
            cursor = database.query("TechnicalVisits",addressField,"name=?",arguments,null,null,null);

            if(cursor.moveToFirst()){
                String text= cursor.getString(0);
                address.setText(text);
            }

            String[] dayFields = {"day","month","year"};
            cursor = database.query("TechnicalVisits",dayFields,"name=?",arguments,null,null,null);

            if(cursor.moveToFirst()){
                String text= cursor.getString(0)+"/"+cursor.getString(1)+"/"+cursor.getString(2);
                day.setText(text);
            }

            String[] placeField = {"place"};
            cursor = database.query("TechnicalVisits",placeField,"name=?",arguments,null,null,null);

            if(cursor.moveToFirst()){
                String text= cursor.getString(0);
                place.setText(text);
            }

            String[]fields = {"hour","minute"};
            cursor = database.query("Turns",fields,"name=?",arguments,null,null,null);
            int count=0;
            while(cursor.moveToNext()){

                String hour= cursor.getString(0);
                String minute=cursor.getString(1);
                if(count!=0){
                    turn1.setText(turn1.getText()+"\n" + String.valueOf(count+1)+"º Turno " + hour +":"+minute);
                }
                else{
                    turn1.setText(String.valueOf(count+1)+"º Turno " + hour +":"+minute);
                }
                count++;


            }
            ArrayList<String> list = new ArrayList<>();


            while(count!=0){
                list.add( count +"º Turno");
                count--;
            }

            String []opcions  = list.toArray(new String[list.size()]);


            spinner  = (Spinner)findViewById(R.id.spinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opcions);
            spinner.setAdapter(adapter);

            database.close();


        }




    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void alarm(View view){
        if(checkBox.isChecked()){
            AlarmManager objAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH,4);
            cal.set(Calendar.MONTH,Calendar.MARCH);
            cal.set(Calendar.YEAR,2017);
            cal.set(Calendar.HOUR_OF_DAY, 10);
            cal.set(Calendar.MINUTE, 40);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            Intent alarmShowIntent = new Intent(this,AlarmActivity.class);
            PendingIntent alarmPendingIntent = PendingIntent.getActivity(this, 0,alarmShowIntent,0 );

            objAlarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), alarmPendingIntent);
        }

    }
}
