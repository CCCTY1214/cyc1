package com.example.cyc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cyc.jiavabean.MYsqliteopenhepler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edi_name;
    private EditText edi_password;
    private CheckBox checkBox;
    private Button login;
    private Button register;
    private int Remember;
    private String password;
    private Intent intent;
    private MYsqliteopenhepler mYsqliteopenhepler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mYsqliteopenhepler =new MYsqliteopenhepler(this);
        find();{
        }
    }










    private  void find(){
        edi_name = findViewById(R.id.edit_text1);
        edi_password = findViewById(R.id.edit_text2);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(this);
        register.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.login:
                String s = edi_name.getText().toString();
                String s1= edi_password.getText().toString();
                boolean login = mYsqliteopenhepler.login(s, s1);
                if(login){
                    Toast.makeText(this,"login successful",Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(this,MainActivity2.class);
                    startActivity(i);
                }else {
                    Toast.makeText(this,"Login failed",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.register:
                Intent i1 =new Intent(this,denglu.class);
                startActivity(i1);
                break;
        }

    }
}
