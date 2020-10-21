package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 1","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 3","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 5","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 7","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 9","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 11","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 13","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 15","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 17","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 19","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 21","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 23","Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background,"Line 25","Line 2"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
