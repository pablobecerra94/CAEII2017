package overhead.caeii2017;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    private TextView coordinationTitle;
    private TextView coordinationMail;
    private TextView diffusionTitle;
    private TextView diffusionMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.contactTitle);
        coordinationTitle=(TextView)findViewById(R.id.coordinationTItle);
        coordinationMail=(TextView)findViewById(R.id.coordinationMail);
        diffusionTitle=(TextView)findViewById(R.id.diffusionTitle);
        diffusionMail=(TextView)findViewById(R.id.diffusionMail);
        setFont(coordinationMail);
        setFont(diffusionMail);
        setTitleFont(coordinationTitle);
        setTitleFont(diffusionTitle);

        setDisplayHomeAsUp();
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
        textView.setTextSize(30);
        textView.setTextColor(Color.RED);
    }

    public void setFont(TextView textView) {
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/monserratregular.ttf");
        textView.setTypeface(font);
    }

    public void startActivities(View view) { startActivity(new Intent(this, AboutUsActivity.class)); }
}
