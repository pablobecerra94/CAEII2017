package overhead.caeii2017;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TechnicalVisitisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[]items={getString(R.string.visitItemTest1),getString(R.string.visitItemTest2)};
        ListView itemList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        setTitle(R.string.technicalVisitsTitle);
        itemList=(ListView) findViewById(R.id.itemList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent test1 = new Intent(getApplicationContext(), ItemTest1.class);
                        startActivity(test1);
                        break;
                    case 1:
                        Intent aareii = new Intent(getApplicationContext(), ItemTest2.class);
                        startActivity(aareii);
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
