package overhead.caeii2017;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

//public class ScheduleDaysActivity extends AppCompatActivity {

public class ScheduleDaysActivity extends AppCompatActivity implements ThursdayFragment.OnFragmentInteractionListener, FridayFragment.OnFragmentInteractionListener, SaturdayFragment.OnFragmentInteractionListener, SundayFragment.OnFragmentInteractionListener {



    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_days);
        setToolbar();
        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setTitle(R.string.scheduleTitle);

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final android.support.v7.app.ActionBar ab = getSupportActionBar();
        if (ab != null) {

            //ab.setHomeAsUpIndicator(R.drawable.ic_menu_camera);
            ab.setDisplayHomeAsUpEnabled(true);

        }
    }

    public void setupViewPager(ViewPager upViewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ThursdayFragment(), getString(R.string.ThursdayTitle));
        adapter.addFragment(new FridayFragment(), getString(R.string.FridayTitle));
        adapter.addFragment(new SaturdayFragment(), getString(R.string.SaturdayTitle));
        adapter.addFragment(new SundayFragment(), getString(R.string.SundayTitle));
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
