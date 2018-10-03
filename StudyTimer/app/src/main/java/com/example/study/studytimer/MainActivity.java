package com.example.study.studytimer;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private List<Task> taskList;
    private ListView listView;
    private String task_key, time_key;
    private int requestcode = 1;
    private CustomListAdapter adapter;
    private Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Log.d("getstringfrompopup", "onCreate: " + task_key + time_key);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myIntent = new android.content.Intent(MainActivity.this,
						PopUpActivity.class);
				//startActivity(myIntent);
                startActivityForResult(myIntent, requestcode);
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        taskList = new ArrayList<>();


        listView = (ListView) findViewById(R.id.listView_id);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("positionoflistview", "onItemClick: " + i);
                Toast.makeText(MainActivity.this,
                        "Item in position " + i + " clicked", Toast.LENGTH_LONG).show();
            }
        });

        adapter = new
                CustomListAdapter(this, R.layout.my_list_item_layout, taskList);

        listView.setAdapter(adapter);




    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if(resultCode == Activity.RESULT_OK) {
            if(i != null) {
                task_key = i.getStringExtra("TASK_INFO");
                time_key = i.getStringExtra("TIME_INFO");
                Log.d("resultkeystask", "onActivityResult: " + task_key + time_key);
                taskList.add(new Task(task_key, time_key));

                adapter.notifyDataSetChanged();
            }
        }
    }
}
