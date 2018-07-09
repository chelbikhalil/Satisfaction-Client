package com.example.laptop.satisficationtest;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.preference.EditTextPreference;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.prefs.Preferences;

public class TestActivity extends AppCompatActivity {
    private final int PREFERENCES_ACTIVITY = 2;

 private ImageButton satisfait;
 private ImageButton medium;
 private ImageView trist;
 private ImageButton tresinstatisfait;
 private EditTextPreference EmailSetting;
 private Date date;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.main, menu );
        return true;

    }


    protected void onCreate(Bundle savedInstanceState) {
        final Calendar calendar=Calendar.getInstance();
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_test );




        satisfait = (ImageButton)findViewById( R.id.tressatisfai );
        satisfait.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String result = "";
                Intent intent = new Intent(TestActivity.this, HomeActivity.class);
                intent.putExtra( "extra","Client très Satisfait" );

                startActivity( intent );
            }
        } );
        medium = (ImageButton)findViewById( R.id.satisfait );
        medium.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, HomeActivity.class);
                intent.putExtra( "extra","Client satisfait" );
                startActivity( intent );
            }
        } );
        trist = (ImageButton)findViewById( R.id.insatisfait);
        trist.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, HomeActivity.class);
                intent.putExtra( "extra","Client  Normal" );
                startActivity( intent );
            }
        } );
        tresinstatisfait = (ImageButton)findViewById( R.id.tresinstisfait );
        tresinstatisfait.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, HomeActivity.class);
                intent.putExtra( "extra","Client  Très InSatisfait" );
                startActivity( intent );
            }
        } );
    }



    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.gone:
                Intent intent = new Intent(TestActivity.this,   MainActivity.class);
                startActivity( intent );
                return true;
            case R.id.quitter:
                Process.killProcess(Process.myPid());
                System.exit(1);
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }
}

