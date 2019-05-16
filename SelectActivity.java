package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewMajor;
    private TextView textViewRegion;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        textViewRegion = (TextView) findViewById(R.id.textViewRegion) ;
        textViewMajor = (TextView) findViewById(R.id.textViewMajor);

        textViewMajor.setOnClickListener(this);
        textViewRegion.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == textViewMajor){
            startActivity(new Intent(this,MajorActivity.class));
        }
        if(view == textViewRegion){
            startActivity(new Intent(this,RegionActivity.class));
        }
    }

}


