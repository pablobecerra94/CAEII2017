package overhead.caeii2017;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VisitDescriptionActivity extends AppCompatActivity {

    String web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUp();
        Bundle bundle = getIntent().getExtras();
        String visitName = bundle.getString("VisitName");
        ImageView visitPicture = (ImageView) findViewById(R.id.visitPicture);
        TextView visitText = (TextView) findViewById(R.id.visitText);
        setTitle(visitName);
        Resources res = getResources(); //cambiemos kraken gato!
        String imageName = visitName.toLowerCase().replace(" ","").replace("ñ","n").replace("í","i").replace("é","e").replace("á","a").replace("ó","o").replace("ú","u").replace("-","");
        int resID = res.getIdentifier(imageName , "drawable", getPackageName());
        visitPicture.setImageResource(resID);

        SqliteConector conector = new SqliteConector(this, "DBCaeii2017", null, 1);

        SQLiteDatabase database = conector.getReadableDatabase();

        if(database != null){
            String[] fields = {"text","web"};
            String[] arguments={visitName};
            Cursor cursor = database.query("VisitText",fields,"name=?",arguments,null,null,null);
            if(cursor.moveToFirst()){
                String text= cursor.getString(0);
                visitText.setText(text);
                web = cursor.getString(1);
            }

            database.close();
        }

        visitPicture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(web);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
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
