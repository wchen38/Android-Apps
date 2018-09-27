package com.example.study.studytimer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PopUpActivity extends AppCompatActivity {

    private Button done_btn;
    private TextView popup_close_btn;
    private EditText task_ev;
    private EditText time_ev;
    private String task_key, time_key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_pop_up_layout);




         // click for done button
        done_btn = findViewById(R.id.done_btn_id);
        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task_ev = (EditText)findViewById(R.id.task_edit_view);
                time_ev = (EditText)findViewById(R.id.time_edit_view);

                task_key = task_ev.getText().toString();
                time_key = time_ev.getText().toString();

                Intent myIntent = new android.content.Intent(PopUpActivity.this,
                        MainActivity.class);
                myIntent.putExtra("TASK_INFO", task_key);
                myIntent.putExtra("TIME_INFO", time_key);
                setResult(RESULT_OK, myIntent);
                finish();
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        //click for close button
        popup_close_btn = findViewById(R.id.txtclose);
        popup_close_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new android.content.Intent(PopUpActivity.this,
                        MainActivity.class);
                startActivity(myIntent);

            }
        });
    }



}
