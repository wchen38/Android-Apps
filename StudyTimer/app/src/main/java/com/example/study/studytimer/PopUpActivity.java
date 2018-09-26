package com.example.study.studytimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PopUpActivity extends AppCompatActivity {

    private Button done_btn;
    private TextView popup_close_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.custom_pop_up_layout);

         // click for done button
        done_btn = findViewById(R.id.done_btn_id);
        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new android.content.Intent(PopUpActivity.this,
                        MainActivity.class);
                startActivity(myIntent);
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
