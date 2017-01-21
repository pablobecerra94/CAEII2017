package overhead.caeii2017;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class MisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mision);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getText(R.string.mision_fragment));
        TextView misionTextView = (TextView) findViewById(R.id.misionTextView);
        TextView visionTextView = (TextView) findViewById(R.id.visionTextView);
        TextView objectiveTextView = (TextView) findViewById(R.id.objectiveTextView);

    }
}
