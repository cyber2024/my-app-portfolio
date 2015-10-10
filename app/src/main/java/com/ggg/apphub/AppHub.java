package com.ggg.apphub;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class AppHub extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_hub);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_hub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnspotifystreamer:
                Toast.makeText(getApplicationContext(), "Launching Popular Movies", Toast
                        .LENGTH_SHORT).show();
                openApp(this,"moviestreamer.ggg.com.moviestreamer");
                break;
            case R.id.btnscores:
                Toast.makeText(getApplicationContext(), "Launching Scores", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnlibrary:
                Toast.makeText(getApplicationContext(), "Launching Library", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnreader:
                Toast.makeText(getApplicationContext(), "Launching Reader", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnbigger:
                Toast.makeText(getApplicationContext(), "Launching Bigger", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnmyownapp:
                Toast.makeText(getApplicationContext(), "Launching Capstone", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public static boolean openApp(Context context, String packageName){
        PackageManager manager = context.getPackageManager();
        try{
            Intent i = manager.getLaunchIntentForPackage(packageName);
            if( i == null){
                //bail
                throw new PackageManager.NameNotFoundException();
            }
            context.startActivity(i);
            return true;
        } catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }
}
