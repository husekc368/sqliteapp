package com.example.cody.sqliteapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText editName, editSurName, editMarks;
    Button btnAddData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editTextName);
        editSurName = (EditText) findViewById(R.id.editTextSurname);
        editMarks = (EditText) findViewById(R.id.editTextMarks);
        btnAddData = (Button) findViewById(R.id.buttonSubmit);
        AddData();


    }

    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                boolean isInserted= mydb.insertData(
                        editName.getText().toString(), editSurName.getText().toString(),
                        editMarks.getText().toString() );
                if (isInserted==true)
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data is not Inserted",Toast.LENGTH_LONG).show();

            }
        });
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
