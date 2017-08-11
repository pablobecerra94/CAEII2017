package overhead.caeii2017.Actividades;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import overhead.caeii2017.QuienesSomos.AboutUsActivity;
import overhead.caeii2017.R;

public class VisitsOpcionActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits_opcion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        final String visitName = bundle.getString("VisitName");
        setTitle(visitName);
        setDisplayHomeAsUp();

        String[]items={"Descripción","Horarios"};

        ListView itemList;
        itemList=(ListView) findViewById(R.id.itemList);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, items);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapter.getItem(i);
                Intent intent;
                if(selectedItem.equals("Descripción")){
                    intent = new Intent(getApplicationContext(), VisitDescriptionActivity.class);

                }else{
                    intent = new Intent(getApplicationContext(), VisitItem.class);
                }
                intent.putExtra("VisitName", visitName);
                startActivity(intent);

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

