package overhead.caeii2017;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SponsorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        setTitle(R.string.sponsorsTitle);

        ImageView techint = (ImageView) findViewById(R.id.techint);
        ImageView arcor = (ImageView) findViewById(R.id.arcor);
        ImageView penaflor = (ImageView) findViewById(R.id.penaflor);
        ImageView cnea = (ImageView) findViewById(R.id.cnea);
        ImageView socialab = (ImageView) findViewById(R.id.socialab);
        ImageView cecilia = (ImageView) findViewById(R.id.cecilia);
        ImageView dana = (ImageView) findViewById(R.id.dana);
        ImageView pae = (ImageView) findViewById(R.id.pae);
        ImageView mercadolibre = (ImageView) findViewById(R.id.mercadolibre);
        ImageView femsa = (ImageView) findViewById(R.id.femsa);
        ImageView unilever = (ImageView) findViewById(R.id.unilever);
        ImageView inti = (ImageView) findViewById(R.id.inti);

        TextView exclusiveSponsor= (TextView) findViewById(R.id.exclusiveSponsorTextView);
        TextView sponsor= (TextView) findViewById(R.id.sponsorsTextView);
        TextView aliados = (TextView) findViewById(R.id.aliadosTextView);

        dana.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.danaWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        femsa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.femsaWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        cecilia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.ceciliaWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        socialab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.socialabWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        mercadolibre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.mercadolibreWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        inti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.intiWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        unilever.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.unileverWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        techint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.techintWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        arcor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.arcorWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        penaflor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.penaflorWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        cnea.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.cneaWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        pae.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.paeWebPage));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        setTitleFont(exclusiveSponsor);
        setTitleFont(sponsor);
        setTitleFont(aliados);

    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setTitleFont(TextView textView) {
        //  Typeface font = Typeface.createFromAsset(getAssets(),"fonts/SignPainter-HouseScript.ttf");
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Montserrat-Bold_0.ttf");
        textView.setTypeface(font);
        textView.setTextSize(35);
        textView.setTextColor(Color.RED);
    }
}
