package overhead.caeii2017;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class AboutUsActivity extends AppCompatActivity implements MisionFragment.OnFragmentInteractionListener,DelegationsFragment.OnFragmentInteractionListener,ContactFragment.OnFragmentInteractionListener,AareiiFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        setToolbar(); 

        
        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.setupWithViewPager(viewPager);
        setTitle(R.string.AboutUsTitle);
    }

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
        adapter.addFragment(new MisionFragment(), getString(R.string.mision_fragment));
        adapter.addFragment(new AareiiFragment(), getString(R.string.aareiiTitle));
        adapter.addFragment(new DelegationsFragment(), getString(R.string.delegationsTitle));
        adapter.addFragment(new ContactFragment(), getString(R.string.contactTitle));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
