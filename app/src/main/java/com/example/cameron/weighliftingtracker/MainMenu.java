package com.example.cameron.weighliftingtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button btn_newlift, btn_tracker, btn_maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        btn_newlift=(Button)findViewById(R.id.btn_newlift);
        btn_newlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainMenu.this,Input.class);
                startActivity(i);
            }
        });
        btn_tracker=(Button)findViewById(R.id.btn_tracker);
        btn_tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainMenu.this,PBTracker.class);
                startActivity(i);
            }
        });
        btn_maps=(Button)findViewById(R.id.btn_maps);
        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainMenu.this,LiftsLocation.class);
                startActivity(i);
            }
        });
    }
}
