package overhead.caeii2017;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SpeakerItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_item);

        Bundle bundle = getIntent().getExtras();
        String speakerName=bundle.getString("SpeakerName");
        ImageView speakerPicture = (ImageView) findViewById(R.id.speakerPicture);
        TextView speakerText=(TextView) findViewById(R.id.speakerText);
/*
        Resources res = getResources();
        String imageName = speakerName.toLowerCase().replace(" ","").replace("ñ","n");
        int resID = res.getIdentifier(imageName , "drawable", getPackageName());
        speakerPicture.setImageResource(resID);
*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        setTitle(speakerName);


        SqliteConector conector = new SqliteConector(this, "DBCaeii2017", null, 1);

        SQLiteDatabase database = conector.getReadableDatabase();

        if(database != null){
            String[] fields = {"SpeakerText"};
            String[] arguments={speakerName};
            Cursor cursor = database.query("Speakers",fields,"name=?",arguments,null,null,null);
            if(cursor.moveToFirst()){
                String text= cursor.getString(0);
                speakerText.setText(text);

            }
            database.close();
        }
    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivities(View view) { startActivity(new Intent(this, AboutUsActivity.class)); }
}
