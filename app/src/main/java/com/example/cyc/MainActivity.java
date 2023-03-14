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

public class MainActivity extends AppCompatActivity {

    private EditText edi_name;
    private EditText edi_password;
    private CheckBox checkBox;
    private Button btn;
    private int Remember;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindID();

        SharedPreferences sharedPreferences = getSharedPreferences("mynp.xml", MODE_PRIVATE);

        if (sharedPreferences != null) {
            String name = sharedPreferences.getString("name", "");
            password = sharedPreferences.getString("password", "");
            Remember = sharedPreferences.getInt("check", 0);
            edi_name.setText(name);
        }
        if (Remember == 1) {
            checkBox.setChecked(true);
            edi_password.setText(password);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edi_name.getText().toString();
                String password = edi_password.getText().toString();

                if("admin".equals(name) && "123456".equals(password)){
                    SharedPreferences np = getSharedPreferences("mynp.xml", MODE_PRIVATE);

                    SharedPreferences.Editor editor = np.edit();
                    editor.putString("name", name);
                    editor.putString("password", password);

                    if (checkBox.isChecked()) {
                        Remember = 1;
                        editor.putInt("check", Remember);
                    } else {
                        Remember = 0;
                        editor.putInt("check", Remember);
                    }

                    editor.commit();
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void bindID() {
        edi_name = findViewById(R.id.edit_text1);
        edi_password = findViewById(R.id.edit_text2);
        checkBox = findViewById(R.id.checkBox1);
        btn = findViewById(R.id.button1);
    }
}