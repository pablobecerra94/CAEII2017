package overhead.caeii2017;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class TouristGuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touristic_guide);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.TouristicGuideTitle);
        setDisplayHomeAsUp();

        TextView constructionTextView = (TextView) findViewById(R.id.constructionTextView);
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/monserratregular.ttf");
        constructionTextView.setTypeface(font);
    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivities(View view) { startActivity(new Intent(this, AboutUsActivity.class)); }
}
