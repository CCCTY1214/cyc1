package com.example.cyc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }

    private void initFruits() {
        people one = new people("约翰老妈", R.drawable.one);
        peopleList.add(one);
        people two = new people("兰登修道院", R.drawable.two);
        peopleList.add(two);
        people three = new people("辣酱老妈", R.drawable.three);
        peopleList.add(three);
        people four = new people("彼德海姆", R.drawable.four);
        peopleList.add(four);

    }
}
