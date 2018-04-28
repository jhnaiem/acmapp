package com.example.jahid.acm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jahid.acm.model.Adapter;

public class EventHistoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventsdesign);

        this.getSupportFragmentManager().beginTransaction().add(R.id.container,new EventsFragment()).commit();

    }






}
