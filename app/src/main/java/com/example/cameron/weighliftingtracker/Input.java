package com.example.cameron.weighliftingtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class Input extends AppCompatActivity implements View.OnClickListener{
    Switch sw_kgorlb, sw_location;
    EditText txt_weightkg, txt_weightlb, txt_newlift, txt_location;
    TextView  txt_displaytest;
    Button btn_savenew, btn_remove;
    Double Weight;
    String location = "";
    String newlift = "";
    String W;
    MyDBHandler dbHandler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        txt_weightkg = (EditText) findViewById(R.id.txt_weightkg);
        txt_weightlb = (EditText) findViewById(R.id.txt_weightlb);
        txt_newlift = (EditText) findViewById(R.id.txt_newlift);
        txt_location= (EditText) findViewById(R.id.txt_location);
        txt_displaytest = (TextView) findViewById(R.id.txt_displaytest);
        sw_kgorlb = (Switch) findViewById(R.id.sw_kgorlb);
        sw_kgorlb.setChecked(true);
        sw_kgorlb.setOnClickListener(this);
        sw_location = (Switch) findViewById(R.id.sw_location);
        sw_location.setChecked(true);
        sw_location.setOnClickListener(this);
        btn_savenew = (Button) findViewById(R.id.btn_savenew);
        btn_remove =(Button) findViewById(R.id.btn_remove);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }
    //Add a product to the database
    public void addButtonClicked(View view){
        LiftsDB lift = new LiftsDB(txt_newlift.getText().toString());
        dbHandler.addLift(lift);
        printDatabase();
    }

    public void removeButtonClicked (View view){
        String inputText = txt_newlift.getText().toString();
        dbHandler.deleteLift(inputText);
        printDatabase();
    }
    //Print the database
    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        txt_displaytest.setText(dbString);
        txt_newlift.setText("");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sw_kgorlb:
                if (sw_kgorlb.isChecked()) {
                    sw_kgorlb.setText("Kg");
                    txt_weightkg.setVisibility(View.VISIBLE);
                    txt_weightlb.setVisibility(View.INVISIBLE);
                } else {
                    sw_kgorlb.setText("Lb");
                    txt_weightlb.setVisibility(View.VISIBLE);
                    txt_weightkg.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.sw_location:
                if (sw_location.isChecked()) {
                    txt_location.setVisibility(View.VISIBLE);
                } else {
                    txt_location.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.btn_savenew:
                if (sw_kgorlb.isChecked()) {

                    Toast.makeText(getApplicationContext(), "New Lift Added", Toast.LENGTH_SHORT).show();
                } else {
                    sw_kgorlb.setText("Lb");
                    txt_weightlb.setVisibility(View.VISIBLE);
                    txt_weightkg.setVisibility(View.INVISIBLE);
                    break;
                }
        }
    }
}