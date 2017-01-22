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

import java.util.ArrayList;
import java.util.List;

public class ActivitiesActivity extends AppCompatActivity implements TechnicalVisitsFragments.OnFragmentInteractionListener,SpeakersFragment.OnFragmentInteractionListener,ScheduleFragment.OnFragmentInteractionListener,ConferencesFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        setToolbar();
        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setTitle(R.string.activitiesTitle);
    }

    public void startActivities(View view) { startActivity(new Intent(this, ActivitiesActivity.class)); }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {

            //ab.setHomeAsUpIndicator(R.drawable.ic_menu_camera);
            ab.setDisplayHomeAsUpEnabled(true);

        }
    }

    public void setupViewPager(ViewPager upViewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ScheduleFragment(), getString(R.string.scheduleTitle));
        adapter.addFragment(new ConferencesFragment(), getString(R.string.conferencesTitle));
        adapter.addFragment(new TechnicalVisitsFragments(), getString(R.string.technicalVisitsTitle));
        adapter.addFragment(new SpeakersFragment(), getString(R.string.speakersTitle));
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
