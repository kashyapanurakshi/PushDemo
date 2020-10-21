package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExampleFragment fragment = ExampleFragment.newInstance("example text",123);
        

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}
