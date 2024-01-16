package com.example.project;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChartActivity extends AppCompatActivity {

    ImageButton img_btn;
    Dialog dialogAnimated_chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        getSupportActionBar().hide();
        img_btn=findViewById(R.id.imageButton_close);
        dialogAnimated_chart = new Dialog(this, R.style.dialogstyle);

    }
}