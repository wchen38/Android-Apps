package com.example.study.studytimer;

public class Task {
    String task_name, num_hours;

    public Task(String task_name, String num_hours) {
        this.task_name = task_name;
        this.num_hours = num_hours;
    }

    public String getTask_name() {
        return task_name;
    }

    public String getNum_hours() {
        return num_hours;
    }
}
