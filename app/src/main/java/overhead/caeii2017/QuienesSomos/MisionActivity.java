package overhead.caeii2017.QuienesSomos;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import overhead.caeii2017.R;


public class MisionActivity extends AppCompatActivity {
    private TextView misionTextView;
    private TextView visionTextView;
    private TextView objectiveTextView;
    private TextView misionTitleTextView;
    private TextView visionTitleTextView;
    private  TextView objectiveTitleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mision);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getText(R.string.mision_fragment));
        misionTextView = (TextView) findViewById(R.id.misionTextView);
        setFont(misionTextView);
        visionTextView  = (TextView) findViewById(R.id.visionTextView);
        setFont(visionTextView);
        objectiveTextView = (TextView) findViewById(R.id.objectiveTextView);
        setFont(objectiveTextView);
        misionTitleTextView=(TextView) findViewById(R.id.misionTitleTextView);
        setTitleFont(misionTitleTextView);
        visionTitleTextView=(TextView) findViewById(R.id.visionTitleTextView);
        setTitleFont(visionTitleTextView);
        objectiveTitleTextView=(TextView) findViewById(R.id.objectiveTitleTextView);
        setTitleFont(objectiveTitleTextView);
        setDisplayHomeAsUp();




    }

    private void setTitleFont(TextView textView) {
      //  Typeface font = Typeface.createFromAsset(getAssets(),"fonts/SignPainter-HouseScript.ttf");
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Montserrat-Bold_0.ttf");
        textView.setTypeface(font);
        textView.setTextSize(35);
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
