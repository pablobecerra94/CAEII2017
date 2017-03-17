package overhead.caeii2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesActivity extends AppCompatActivity {

    String[] web = new String[] { "Cronograma", "Conferencias y Talleres", "Visitas Tecnicas", "Disertantes" };
    Integer[] imageId = { R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers };

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        setTitle(R.string.aboutUsTitle);

        CustomList adapter = new CustomList(this, web, imageId);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent schedule = new Intent(getApplicationContext(), ScheduleActivity.class);
                        startActivity(schedule);
                        break;
                    case 1:
                        Intent conferences = new Intent(getApplicationContext(), ConferencesActivity.class);
                        startActivity(conferences);
                        break;
                    case 2:
                        Intent technicalVisits = new Intent(getApplicationContext(), TechnicalVisitisActivity.class);
                        startActivity(technicalVisits);
                        break;
                    case 3:
                        Intent speakers= new Intent(getApplicationContext(), SpeakersActivity.class);
                        startActivity(speakers);
                        break;
                    default:

                }
            }
        });
    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivities(View view) { startActivity(new Intent(this, AboutUsActivity.class)); }
}
