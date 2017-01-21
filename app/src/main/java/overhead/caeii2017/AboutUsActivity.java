package overhead.caeii2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         String[]items={getString(R.string.mision_fragment),getString(R.string.aareiiTitle),getString(R.string.delegationsTitle),getString(R.string.contactTitle)};
         ListView itemList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.aboutUsTitle);
        itemList=(ListView) findViewById(R.id.itemList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
}
