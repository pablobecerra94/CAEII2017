package overhead.caeii2017;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by CrimsonBraixen on 18/07/2017.
 */

public class PilarsItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilars_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Integer[] imageMision2050 = { R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers };
        Integer[] imageADNIndustrial = { R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers, R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers };
        //Integer[] imageCartas = { R.drawable.schedules, R.drawable.conferences, R.drawable.technical_visits, R.drawable.speakers };
        //String[]itemsMision2050={"Dr. Andrés Sartarelli","Dra. Mónica Miralles","Laura Toledo","Cecilia Smoglie","Martin Vila","Joan Cwaik", "Victor Manuel Fontan","Norma Cadoppi","Catalina Lonac", "Hernán Charreau", "Paulo Strina"};
        String[]itemsADNIndustrial={"Martín Urquizo", "Marcos Aquino", "Andrés Villamor", "Augusto Cicaré", "Eduardo Jorge Oreste", "Alejandro Leiras", "Mario Paredes", "Diego Prado"};
        //String[]itemsCartas={"Dr. Andrés Sartarelli","Dra. Mónica Miralles","Laura Toledo","Cecilia Smoglie","Martin Vila","Joan Cwaik", "Victor Manuel Fontan","Norma Cadoppi","Catalina Lonac", "Hernán Charreau", "Paulo Strina"};
        ListView itemList;

        Bundle bundle = getIntent().getExtras();
        String pilarName = bundle.getString("PilarName");
        ImageView pilarPicture = (ImageView) findViewById(R.id.pilarPicture);
        TextView pilarText = (TextView) findViewById(R.id.pilarText);

        Resources res = getResources();
        String imageName = pilarName.toLowerCase().replace(" ","").replace("ñ","n");
        int resID = res.getIdentifier(imageName , "drawable", getPackageName());
        pilarPicture.setImageResource(resID);

        setTitle(pilarName);

        setDisplayHomeAsUp();

        setFont(pilarText);

        itemList=(ListView) findViewById(R.id.itemList);

        switch (pilarName){
            case "Mision 2050":
                pilarText.setText(getResources().getString(R.string.mision2050Text));
                /*final CustomList adapterMision2050 = new CustomList(this, itemsMision2050, imageMision2050);
                itemList.setAdapter(adapterMision2050);
                itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selectedItem = adapterMision2050.getItem(i);
                        Intent intent = new Intent(getApplicationContext(), SpeakerItemActivity.class);
                        intent.putExtra("SpeakerName", selectedItem);
                        startActivity(intent);
                    }
                });*/
                break;
            case "ADN Industrial":
                pilarText.setText(getResources().getString(R.string.industrialADNText));
                final CustomList adapterADNIndustrial = new CustomList(this, itemsADNIndustrial, imageADNIndustrial);
                itemList.setAdapter(adapterADNIndustrial);
                itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selectedItem = adapterADNIndustrial.getItem(i);
                        Intent intent = new Intent(getApplicationContext(), SpeakerItemActivity.class);
                        intent.putExtra("SpeakerName", selectedItem);
                        startActivity(intent);
                    }
                });
                break;
            case "Suma cartas a tu baraja":
                pilarText.setText(getResources().getString(R.string.deckText));
                /*final CustomList adapterCartas = new CustomList(this, itemsCartas, imageCartas);
                itemList.setAdapter(adapterCartas);
                itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selectedItem = adapterCartas.getItem(i);
                        Intent intent = new Intent(getApplicationContext(), SpeakerItemActivity.class);
                        intent.putExtra("SpeakerName", selectedItem);
                        startActivity(intent);
                    }
                });*/
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

    public void setFont(TextView textView) {
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/monserratregular.ttf");
        textView.setTypeface(font);
    }
}
