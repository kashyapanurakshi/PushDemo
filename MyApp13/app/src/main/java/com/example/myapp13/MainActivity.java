package com.example.myapp13;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    public static Button button_sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addClickButtonListener();
    }
    public void addClickButtonListener(){
        button_sel = findViewById(R.id.button);

        button_sel.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        AlertDialog.Builder ad_builder = new AlertDialog().Builder(this);
                        ad_builder.setMessage("Do you want to close this app?")
                                .setCancelable(true).setNegativeButton();
                    }
                }
        );
    }

}
