package com.example.myapp10;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb_dog;
    private CheckBox cb_cat;
    private CheckBox cb_cow;
    private Button button_sel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addOnClickListener();
    }

    public void addOnClickListener(){
        cb_dog = findViewById(R.id.checkbox_dog);
        cb_cat = findViewById(R.id.checkbox_cat);
        cb_cow = findViewById(R.id.checkbox_cow);
        button_sel = findViewById(R.id.button);


        button_sel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StringBuffer result = new StringBuffer();
                        result.append("Dog : ").append(cb_dog.isChecked());
                        result.append("Cat : ").append(cb_cat.isChecked());
                        result.append("Cow : ").append(cb_cow.isChecked());

                        Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
}
