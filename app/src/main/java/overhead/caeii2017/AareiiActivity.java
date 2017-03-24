package overhead.caeii2017;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AareiiActivity extends AppCompatActivity {
    private TextView aareiiiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aareii);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        aareiiiText = (TextView) findViewById(R.id.aareiiiText);
        setTitle(R.string.aareiiTitle);
        setFont(aareiiiText);
        setDisplayHomeAsUp();

        ImageView aareiiImageView = (ImageView) findViewById(R.id.aareiiImage);
        aareiiImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(getString(R.string.aareiiURL));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void setFont(TextView aareiiiText) {
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/monserratregular.ttf");
        aareiiiText.setTypeface(font);
    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivities(View view) { startActivity(new Intent(this, AboutUsActivity.class)); }
}
