package overhead.caeii2017.QuienesSomos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import overhead.caeii2017.R;
import overhead.caeii2017.Util.CustomList;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[]items={getString(R.string.mision_fragment),getString(R.string.aareiiTitle),getString(R.string.delegationsTitle),getString(R.string.contactTitle)};
        Integer[] imageId = { R.drawable.mision, R.drawable.que_es, R.drawable.delegations, R.drawable.contact };
        ListView list;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        setTitle(R.string.aboutUsTitle);
        list=(ListView) findViewById(R.id.list);
        CustomList adapter = new CustomList(this, items, imageId);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent mision = new Intent(getApplicationContext(), MisionActivity.class);
                        startActivity(mision);
                        break;
                    case 1:
                        Intent aareii = new Intent(getApplicationContext(), AareiiActivity.class);
                        startActivity(aareii);
                        break;
                    case 2:
                        Intent delegations = new Intent(getApplicationContext(), DelegationsActivity.class);
                        startActivity(delegations);
                        break;

                    case 3:
                        Intent contact = new Intent(getApplicationContext(), ContactActivity.class);
                        startActivity(contact);
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
