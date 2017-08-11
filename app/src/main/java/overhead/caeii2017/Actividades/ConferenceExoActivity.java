package overhead.caeii2017.Actividades;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import overhead.caeii2017.Actividades.SpeakerItemActivity;
import overhead.caeii2017.R;

public class ConferenceExoActivity extends AppCompatActivity {
    String speakerName;
    String speakerName2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_exo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setDisplayHomeAsUp();

        Bundle bundle = getIntent().getExtras();
        String conferenceName=bundle.getString("Conference");
        setTitle(conferenceName);
        ImageView conferencePicture = (ImageView) findViewById(R.id.speakerPicture);
        ImageView conferencePicture2 = (ImageView) findViewById(R.id.speakerPicture2);
        TextView conferenceText=(TextView) findViewById(R.id.conferenceText);
        TextView conferenceSpeaker = (TextView) findViewById(R.id.conferenceSpeaker);
         speakerName="Lucas Damián Herrero";
         speakerName2="Brian Vallejo";
        Resources res = getResources();
        String imageName = speakerName.toLowerCase().replace(" ","").replace("ñ","n").replace("í","i").replace("é","e").replace("á","a").replace("ó","o").replace("ú","u");
        int resID = res.getIdentifier(imageName , "drawable", getPackageName());
        conferencePicture.setImageResource(resID);
        String imageName2 = speakerName2.toLowerCase().replace(" ","").replace("ñ","n").replace("í","i").replace("é","e").replace("á","a").replace("ó","o").replace("ú","u");
        int resID2 = res.getIdentifier(imageName2 , "drawable", getPackageName());
        conferencePicture2.setImageResource(resID2);

        conferenceSpeaker.setText("Disertantes: " + speakerName +" y " + speakerName2);

        conferenceText.setText(getText(R.string.ExoConferenceText));

        conferencePicture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), SpeakerItemActivity.class);
                intent.putExtra("SpeakerName", speakerName);
                startActivity(intent);
            }
        });

        conferencePicture2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), SpeakerItemActivity.class);
                intent.putExtra("SpeakerName", speakerName2);
                startActivity(intent);
            }
        });

    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
