package overhead.caeii2017;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[]items={getString(R.string.scheduleTitle),getString(R.string.conferencesTitle),getString(R.string.technicalVisitsTitle),getString(R.string.speakersTitle)};
        ListView itemList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        setTitle(R.string.activitiesTitle);
        itemList=(ListView) findViewById(R.id.itemList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
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
