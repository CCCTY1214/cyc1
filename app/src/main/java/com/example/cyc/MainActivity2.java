package com.example.cyc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    private FragmentTransaction fragment_t;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //fragment_t = getSupportFragmentManager().beginTransaction();
        //fragment_t.setReorderingAllowed(true)
        //        .add(R.id.fragment_container_view, fgm1.class, null)
        //        .commit();
        //fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container_view);
        //fragment_t.hide(fragment);

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