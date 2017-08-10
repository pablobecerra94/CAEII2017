package overhead.caeii2017;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PilarConferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilar_conferences);
        setContentView(R.layout.activity_pilar_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        final String pilarName = bundle.getString("PilarName");
        setTitle(pilarName);
        setDisplayHomeAsUp();

        Integer[] imageMision2050 = { R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers,R.drawable.speakers,R.drawable.speakers,R.drawable.speakers,R.drawable.speakers,R.drawable.speakers,R.drawable.speakers };
        //   Integer[] imageADNIndustrial = { R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers, R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers };
        Integer[] imageCartas = { R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers, R.drawable.speakers , R.drawable.speakers };
        String[]itemsMision2050={"Transformando en hielo el calor","De la Biomecánica a la Ingeniería del Movimiento","Nanotecnología. Lo pequeño puede cambiar el mundo.","Rol del Ingeniero en las economías regionales","Ideas del futuro para ingenieros de hoy","La era de la innovación disruptiva","Proyectos de Inversión con Acero Galvanizado por Inmersión en Caliente","Transformemos el presente, porque el futuro es hoy","La caña de azúcar en el nuevo escenario energético","Inteligencia Tecnológica: conocer el camino recorrido para llegar más lejos en la innovación sostenible" };
        // String[]itemsADNIndustrial={"Martín Urquizo", "Marcos Aquino", "Andrés Villamor", "Augusto Cicaré", "Eduardo Jorge Oreste", "Alejandro Leiras", "Mario Paredes", "Diego Prado"};
        String[]itemsCartas={"La excepción a la regla de Pareto","Siempre ganamos el juego que realmente estamos jugando","Eficiencia e imaginación para la Salud – Un Exo para Linda","La experiencia personal es intransferible","En búsqueda de tu propósito","¿Que nos dejó la Física del Siglo XX y cómo impactó en nuestras vidas?"};

        ListView itemList;

        itemList=(ListView) findViewById(R.id.itemList);

        switch (pilarName){
            case "Mision 2050":
                final CustomList adapterMision2050 = new CustomList(this, itemsMision2050, imageMision2050);
                itemList.setAdapter(adapterMision2050);
                itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent;
                        String selectedItem = adapterMision2050.getItem(i);
                        intent = new Intent(getApplicationContext(), ConferencesActivity.class);
                        intent.putExtra("Conference", selectedItem);
                        startActivity(intent);
                    }
                });
                break;
            case "ADN Industrial":
               /* final CustomList adapterADNIndustrial = new CustomList(this, itemsADNIndustrial, imageADNIndustrial);
                itemList.setAdapter(adapterADNIndustrial);
                itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selectedItem = adapterADNIndustrial.getItem(i);
                        Intent intent = new Intent(getApplicationContext(), SpeakerItemActivity.class);
                        intent.putExtra("SpeakerName", selectedItem);
                        startActivity(intent);
                    }
                });*/
                break;
            case "Suma cartas a tu baraja":
                final CustomList adapterCartas = new CustomList(this, itemsCartas, imageCartas);
                itemList.setAdapter(adapterCartas);
                itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent;
                        String selectedItem = adapterCartas.getItem(i);
                        if(selectedItem.contains("Un Exo para Linda")){
                            intent = new Intent(getApplicationContext(), ConferenceExoActivity.class);
                        }else {
                            intent = new Intent(getApplicationContext(), ConferencesActivity.class);
                        }
                        intent.putExtra("Conference", selectedItem);
                        startActivity(intent);
                    }
                });
                break;
            default:
        }



    }
    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivities(View view) { startActivity(new Intent(this, AboutUsActivity.class)); }
}
