package com.example.laptop.satisficationtest;

import android.content.Intent;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.prefs.Preferences;

public class HomeActivity extends AppCompatActivity {


private ImageButton ActionSend ;
private EditText Email;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.main, menu );
        return true;
    }
@Override
    protected void onCreate(Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_home );

    Bundle extras = getIntent().getExtras();

    final String newString = extras.getString( "extra" );


    ActionSend = (ImageButton) findViewById( R.id.btn );
    Email = (EditText) findViewById( R.id.Email );

    ActionSend.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String EmailSend = Email.getText().toString();

            Intent sendIntent = new Intent();
            sendIntent.setAction( Intent.ACTION_SEND );
            String msg = "Vote :" + newString + "----/----" + "Email:" + EmailSend;

            sendIntent.putExtra( Intent.EXTRA_TEXT, msg );

            sendIntent.putExtra( Intent.EXTRA_EMAIL, new String[]{"publinet.luban@gmail.com"} );
            sendIntent.setType( "text/plain" );
           Intent intentFinish = new Intent( HomeActivity.this, FinishActivity.class );
            startActivity( intentFinish );
             startActivity( sendIntent );
        }
    } );
}
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.gone:
                Intent intent = new Intent(HomeActivity.this,TestActivity.class);
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

