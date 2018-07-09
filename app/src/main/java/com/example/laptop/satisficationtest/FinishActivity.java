package com.example.laptop.satisficationtest;

import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class FinishActivity extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.main, menu );
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_finish );
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.gone:
                Intent intent = new Intent(FinishActivity.this,TestActivity.class);
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
