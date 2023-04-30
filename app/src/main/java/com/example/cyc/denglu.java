package com.example.cyc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cyc.jiavabean.MYsqliteopenhepler;
import com.example.cyc.jiavabean.user;

public class denglu extends AppCompatActivity {
    private Button register1;

    private EditText name1,password1;

    private MYsqliteopenhepler mYsqliteopenhepler1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        mYsqliteopenhepler1= new MYsqliteopenhepler(this);
        find();
    }
    private void find(){
        register1 = findViewById(R.id.register1);
        name1 = findViewById(R.id.name1);
        password1 = findViewById(R.id.password1);

    }
    public void zhuche(View view){
        String s = name1.getText().toString();
        String s1 = password1.getText().toString();
        user u= new user (s, s1);
        long l = mYsqliteopenhepler1.register(u);
        if(l != -1){
            Toast.makeText(this, "registration success", Toast.LENGTH_SHORT).show();
            Intent i3 =new Intent(this,MainActivity.class);
            startActivity(i3);
        }else{
            Toast.makeText(this, "registration failed", Toast.LENGTH_SHORT).show();
        }
    }
}