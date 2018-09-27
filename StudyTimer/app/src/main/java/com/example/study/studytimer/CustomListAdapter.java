package com.example.study.studytimer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Task>{
    Context mCtx;
    int resource;
    List<Task> taskList;
    ImageButton playSelect;
    private boolean isPressed = false;

    public CustomListAdapter(Context mCtx, int resource, List<Task> taskList) {
        super(mCtx, resource, taskList);
        this.mCtx = mCtx;
        this.resource = resource;
        this.taskList = taskList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);


        View view = inflater.inflate(resource, null);
        TextView tvTask = view.findViewById(R.id.task_view_id);
        TextView tvHour = view.findViewById(R.id.time_view_id);
        playSelect = view.findViewById(R.id.play_pause_id);
        playSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    playSelect.setImageResource(R.drawable.pause_btn);
                } else {
                    playSelect.setImageResource(R.drawable.play_btn);
                }
            }
        });

        Task task = taskList.get(position);
        Log.d("getViewCustomList", "getView: " + task.getTask_name());
        tvTask.setText(task.getTask_name());
        tvHour.setText(task.getNum_hours());

        return view;
    }

}
