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

import overhead.caeii2017.Actividades.VisitsOpcionActivity;
import overhead.caeii2017.QuienesSomos.AboutUsActivity;
import overhead.caeii2017.R;

public class TechnicalVisitisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[]items={"Tenaris","Bayer","Unilever","La Fármaco","Femsa","Cesvi","I-Flow","Galvasa","Sabic","Techo","Inti","Ruhrpumpen","Dana","Genrod","Loreal","Metalsa","MercadoLibre","CEAMSE","Edelflex","Valmec","Droguería del Sud","Globant", "Banco Alimentario de La Plata","Tigre","Sandvik","Telefónica", "Peisa",
        "Pirelli","Du Pont","CNEA","Escuela Técnica 29","Galfione","TRF","Pura","Schneider Electric","Cervecería y Maltería Quilmes","Laminados Reforzados","Gersolar", "UNLP","FRD","Trimak","Gottert","Spirax Sarco","Industrias Guidi","Cartocor","Dimare"};
        ListView itemList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_visitis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        setTitle(R.string.technicalVisitsTitle);
        itemList=(ListView) findViewById(R.id.itemList);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapter.getItem(i);
                Intent intent = new Intent(getApplicationContext(), VisitsOpcionActivity.class);
                intent.putExtra("VisitName", selectedItem);
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
