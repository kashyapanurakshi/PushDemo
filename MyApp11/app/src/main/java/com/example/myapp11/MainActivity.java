package com.example.myapp11;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import java.lang.StringBuffer;

import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public RadioGroup radio_g;
    public Button button_sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addOnClickListener();
    }
    public void addOnClickListener(){
        radio_g = findViewById(R.id.radioGroup);
        button_sel = findViewById(R.id.button);

        button_sel.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        StringBuffer result = new StringBuffer();
                        result.append("Cow : ").append(radioButtonCow.isChecked());
                        result.append(" Cat : ").append(radioButtonCat.isChecked());
                        result.append(" Dog : ").append(radioButtonDog.isChecked());

                        Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }
}
