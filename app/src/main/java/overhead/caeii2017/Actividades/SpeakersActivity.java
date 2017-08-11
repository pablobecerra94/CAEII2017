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

public class SpeakersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[]items={"Martín Urquizo", "Marcos Aquino", "Andrés Villamor", "Augusto Cicaré", "Eduardo Jorge Oreste", "Alejandro Leiras", "Mario Paredes", "Diego Prado",
                "Andrés Sartarelli", "Mónica Miralles","Laura Toledo","Cecilia Smoglie","Martin Vila","Joan Cwaik","Victor Manuel Fontan","Norma Cadoppi","Catalina Lonac","Hernán Charreau","Paulo Strina",
                "Jorge Camblong", "Gastón Morales", "Daniel Rodríguez", "Lucas Damián Herrero", "Brian Vallejo","Enrique Alberto Pesl","Alejandro Mangioni","Carlos Balseiro"};

        ListView itemList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.speakersTitle);
        setDisplayHomeAsUp();

        itemList=(ListView) findViewById(R.id.itemList);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, items);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapter.getItem(i);
                Intent intent = new Intent(getApplicationContext(), SpeakerItemActivity.class);
                intent.putExtra("SpeakerName", selectedItem);
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
