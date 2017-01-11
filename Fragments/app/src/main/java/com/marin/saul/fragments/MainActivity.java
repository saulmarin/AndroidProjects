package com.marin.saul.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se carga la toolbar como una actionbar para que funcione en android 4
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(),"Toaaaast",Toast.LENGTH_SHORT).show();

                Snackbar.make(view, "Loading finished", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();

                /*Snackbar.make(view, "Ola que ase", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();*/
            }
        });
        Log.d("CICLOVIDA","ONCREATE");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } else if ( id == R.id.action_save){
            Snackbar.make(fab, "Guardando...", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();
        }else if ( id == R.id.action_refresh){

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLOVIDA","ONSTART");
    }

    // Para refrescar la pantalla: se usa mucho
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CICLOVIDA","ONRESUME");
    }

    // Para grabar lo que esté en pantalla para que no se pierda
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CICLOVIDA","ONPAUSE");
    }

    // No se usa mucho. Tenemos el onResume
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("CICLOVIDA","ONRESTART");
    }

    // NO USAR
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CICLOVIDA","ONDESTROY");
    }
}
