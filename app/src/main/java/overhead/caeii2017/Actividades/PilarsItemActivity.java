package overhead.caeii2017.Actividades;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import android.widget.TextView;

import overhead.caeii2017.R;

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


        Bundle bundle = getIntent().getExtras();
        String pilarName = bundle.getString("PilarName");
        ImageView pilarPicture = (ImageView) findViewById(R.id.pilarPicture);
        TextView pilarText = (TextView) findViewById(R.id.pilarText);

        Resources res = getResources();
        String imageName = pilarName.toLowerCase().replace(" ","").replace("ñ","n");
        int resID = res.getIdentifier(imageName , "drawable", getPackageName());
        pilarPicture.setImageResource(resID);

        setTitle(pilarName);

        switch (pilarName) {

            case "Mision 2050":

                pilarText.setText(getResources().getString(R.string.mision2050Text));
                break;
            case "ADN Industrial":
                pilarText.setText(getResources().getString(R.string.industrialADNText));
                break;
            case "Suma cartas a tu baraja":
                pilarText.setText(getResources().getString(R.string.deckText));
                break;
        }
        setDisplayHomeAsUp();

        setFont(pilarText);
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
