package com.example.study.studytimer;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    List<Task> taskList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new android.content.Intent(MainActivity.this,
						PopUpActivity.class);
				startActivity(myIntent);
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        taskList = new ArrayList<>();
        taskList.add(new Task("physics", "5"));

        listView = (ListView) findViewById(R.id.listView_id);

        CustomListAdapter adapter = new
                CustomListAdapter(this, R.layout.my_list_item_layout, taskList);

        listView.setAdapter(adapter);



    }
}
