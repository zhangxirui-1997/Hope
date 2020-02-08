package com.example.mydetermination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Record_card extends AppCompatActivity {

    private int id=0;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_card);
        initIntent();

    }

    private void initIntent(){
        Intent intent=getIntent();
        id=Integer.parseInt(intent.getStringExtra("idthis"));
        textView=findViewById(R.id.textView11);
        textView.setText(id+" ");
    }
}
