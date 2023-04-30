package com.example.cyc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private peopleAdapter peopleAdapter;
    private String[] itemData = {"1", "2", "3"};
    private List<people> peopleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        listView = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(MainActivity4.this,
                android.R.layout.simple_expandable_list_item_1, itemData);
        listView.setAdapter(adapter);

        initFruits();
        peopleAdapter = new peopleAdapter(MainActivity4.this,
                R.layout.people_item, peopleList);
        ListView listView = (ListView) findViewById(R.id.list_view_person);
        listView.setAdapter(peopleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainActivity4.this, tutu.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity4.this, laonvren.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity4.this, qianfu.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity4.this, cocodayo.class);
                        startActivity(intent3);
                        break;
                }
            }
        });

    }

    private void initFruits() {
        people one = new people("Rem Pito watermelon cake", R.drawable.one);
        peopleList.add(one);
        people two = new people("Edible cubes", R.drawable.two);
        peopleList.add(two);
        people three = new people("Karan charcoal steak with truffle sauce", R.drawable.three);
        peopleList.add(three);
        people four = new people("Canned greens and turnips", R.drawable.four);
        peopleList.add(four);

    }
}
