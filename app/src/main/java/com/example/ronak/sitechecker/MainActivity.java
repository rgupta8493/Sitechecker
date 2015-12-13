package com.example.ronak.sitechecker;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;


public class MainActivity extends ActionBarActivity {

    Button b ;
    EditText e1;
    EditText e2 ;
    public String abc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       e1= (EditText)findViewById(R.id.editText1);
        e2= (EditText)findViewById(R.id.editText2);
        b=(Button)findViewById(R.id.button1);


    }

    public void on_click(View v) {
        Async e = new Async(this);
        abc = e1.getText().toString();
        e.execute(abc);



    }

    public void on_result(){
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(abc));
            startActivity(browserIntent);
        }

        catch(Exception e){

        }




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
        }

        return super.onOptionsItemSelected(item);
    }
}
