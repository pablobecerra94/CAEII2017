package overhead.caeii2017;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class MisionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.mision);
        //text.setText();
    }
}
