package overhead.caeii2017.InformacionUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

import overhead.caeii2017.QuienesSomos.AboutUsActivity;
import overhead.caeii2017.R;

public class PlaneActivity extends AppCompatActivity {
    private WebView web;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.Plane);
        setDisplayHomeAsUp();



        requestWindowFeature(Window.FEATURE_NO_TITLE);
        prefs = getSharedPreferences("ayuntaap", Context.MODE_PRIVATE);
        web = (WebView)findViewById(R.id.webView);
        WebSettings settings = web.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        String url = prefs.getString("urld","https://drive.google.com/file/d/0B9PhawZwqK_vdVhMM2V2RjNnSWM/view?usp=sharing");
        web.loadUrl(url);
    }

    private void setDisplayHomeAsUp() {
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivities(View view) { startActivity(new Intent(this, AboutUsActivity.class)); }
}


