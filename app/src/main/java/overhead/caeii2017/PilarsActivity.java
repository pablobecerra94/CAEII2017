package overhead.caeii2017;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by CrimsonBraixen on 17/07/2017.
 */

public class PilarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilars);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getText(R.string.pilars_activity));
        TextView mision2050 = (TextView) findViewById(R.id.mision2050);
        setTitleFont(mision2050);
        TextView industrialADN = (TextView) findViewById(R.id.industrialADN);
        setTitleFont(industrialADN);
        TextView deck = (TextView) findViewById(R.id.deck);
        setTitleFont(deck);
        TextView mision2050Text = (TextView) findViewById(R.id.mision2050Text);
        setFont(mision2050Text);
        TextView industrialADNText = (TextView) findViewById(R.id.industrialADNText);
        setFont(industrialADNText);
        TextView deckText = (TextView) findViewById(R.id.deckText);
        setFont(deckText);
        setDisplayHomeAsUp();




    }

    private void setTitleFont(TextView textView) {
        //  Typeface font = Typeface.createFromAsset(getAssets(),"fonts/SignPainter-HouseScript.ttf");
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Montserrat-Bold_0.ttf");
        textView.setTypeface(font);
        //textView.setTextSize(35);
        textView.setTextColor(Color.RED);
    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivities(View view) { startActivity(new Intent(this, AboutUsActivity.class)); }

    public void setFont(TextView textView) {
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/monserratregular.ttf");
        textView.setTypeface(font);
    }
}
