package com.galaxysoft.aquaplannernetng.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.galaxysoft.aquaplannernetng.R;
import com.galaxysoft.aquaplannernetng.model.TaskAdapter;

public class StatusActivity extends FragmentActivity {

    private TaskAdapter taskAdapter = new TaskAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // ListView viewById = findViewById(R.id.lvMain);
        //viewById.setAdapter(taskAdapter);
        setContentView(R.layout.activity_status);
    }
}
