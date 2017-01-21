package overhead.caeii2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
    }
}
