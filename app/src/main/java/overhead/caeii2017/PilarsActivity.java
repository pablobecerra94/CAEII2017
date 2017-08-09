package overhead.caeii2017;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by CrimsonBraixen on 17/07/2017.
 */

public class PilarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[]items={"Mision 2050","ADN Industrial","Suma cartas a tu baraja"};
        Integer[] imageId = { R.drawable.mision2050mini, R.drawable.adnindustrialmini, R.drawable.sumacartasatubarajamini };
        ListView itemList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilars);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.pilars_activity);
        setDisplayHomeAsUp();

        final CustomList adapter = new CustomList(this, items, imageId);
        itemList = (ListView)findViewById(R.id.itemList);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapter.getItem(i);
                Intent intent = new Intent(getApplicationContext(), PilarsItemActivity.class);
                intent.putExtra("PilarName", selectedItem);
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
}
