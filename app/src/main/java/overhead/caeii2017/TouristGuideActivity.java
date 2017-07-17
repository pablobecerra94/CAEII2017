package overhead.caeii2017;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class TouristGuideActivity extends AppCompatActivity {

    String[] web = new String[] { "Links de interés", "Planos" };
    Integer[] imageId = { R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers };
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touristic_guide);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.UsefulInformation);
        setDisplayHomeAsUp();

        CustomList adapter = new CustomList(this, web, imageId);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:

                        Intent interest = new Intent(getApplicationContext(), InterestLinkActivity.class);
                        startActivity(interest);
                        break;
                    case 1:
                        Intent plane = new Intent(getApplicationContext(), PlaneActivity.class);
                        startActivity(plane);
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
