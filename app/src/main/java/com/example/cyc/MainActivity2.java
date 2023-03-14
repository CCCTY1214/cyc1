package com.example.cyc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void pvbutton(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity2.this,MainActivity3.class);
        startActivity(intent);
    }
    public void mumber(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity2.this,MainActivity4.class);
        startActivity(intent);
    }
}