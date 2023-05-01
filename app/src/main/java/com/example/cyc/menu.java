package com.example.cyc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void abc(View v){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        fgm1 f1=new fgm1();
        fgm2 f2=new fgm2();
        switch (v.getId()){
            case R.id.tv1:
                ft.replace(R.id.lv,f1);
                break;
            case R.id.tv2:
                ft.replace(R.id.lv,f2);
                break;
        }

        ft.commit();

    }
}