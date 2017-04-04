package com.example.cameron.weighliftingtracker;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PBTracker extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp_tracklift;
    TextView txt_weight, txt_lift;
    String test;
    Button btn_load;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pbtracker);
        txt_weight = (TextView) findViewById(R.id.txt_weight);
        txt_lift = (TextView) findViewById(R.id.txt_lift);
        btn_load = (Button) findViewById(R.id.btn_load);
        sp_tracklift = (Spinner) findViewById(R.id.sp_tracklift);
        sp_tracklift.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Lifts, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tracklift.setAdapter(adapter);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }
        //Print the database
    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        txt_lift.setText(dbString);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        ;
        txt_weight.setText(parent.getItemAtPosition(pos).toString());
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


}