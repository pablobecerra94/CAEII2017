package overhead.caeii2017.Actividades;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import overhead.caeii2017.Actividades.SpeakerItemActivity;
import overhead.caeii2017.R;
import overhead.caeii2017.Util.SqliteConector;

public class ConferencesActivity extends AppCompatActivity {
    String speakerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferences);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setDisplayHomeAsUp();

        Bundle bundle = getIntent().getExtras();
        String conferenceName=bundle.getString("Conference");
        setTitle(conferenceName);
        ImageView conferencePicture = (ImageView) findViewById(R.id.speakerPicture);
        TextView conferenceText=(TextView) findViewById(R.id.conferenceText);
        TextView conferenceSpeaker = (TextView) findViewById(R.id.conferenceSpeaker);


        Resources res = getResources();


        SqliteConector conector = new SqliteConector(this, "DBCaeii2017", null, 1);

        SQLiteDatabase database = conector.getReadableDatabase();

        if(database != null){
            String[] fields = {"text","speaker"};
            String[] arguments={conferenceName};
            Cursor cursor = database.query("Conferences",fields,"name=?",arguments,null,null,null);
            if(cursor.moveToFirst()){
                String text= cursor.getString(0);
                conferenceText.setText(text);
                speakerName = cursor.getString(1);
                conferenceSpeaker.setText("Disertante: " + speakerName);
                String imageName = speakerName.toLowerCase().replace(" ","").replace("ñ","n").replace("í","i").replace("é","e").replace("á","a").replace("ó","o").replace("ú","u");
                int resID = res.getIdentifier(imageName , "drawable", getPackageName());
                conferencePicture.setImageResource(resID);
            }


            database.close();
        }

        conferencePicture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), SpeakerItemActivity.class);
                intent.putExtra("SpeakerName", speakerName);
                startActivity(intent);
            }
        });




        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/monserratregular.ttf");
    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
