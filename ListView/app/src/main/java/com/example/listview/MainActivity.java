package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] Items = new String[]{"Apple","Mango","Banana","Cherry","Papaya",
            "JackFruit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listMethod();
    }
    public void listMethod(){
        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.items,Items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String)listView.getItemAtPosition(position);
                        Toast.makeText(MainActivity.this,"Item : "+value+" Position : "+position,
                                Toast.LENGTH_LONG).show();

                    }
                }
        );

    }
}
