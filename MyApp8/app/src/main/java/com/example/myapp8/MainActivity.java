package com.example.myapp8;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import static java.lang.String.valueOf;


public class MainActivity extends AppCompatActivity {

    Button button = findViewById(R.id.button);
    TextView textView = findViewById(R.id.textview);
    EditText editText1 = findViewById(R.id.edittext1);
    EditText editText2 = findViewById(R.id.edittext2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        int e1 = Integer.parseInt(valueOf(editText1.getResources()));
        int e2 = Integer.parseInt(valueOf(editText2.getResources()));
        int sum = e1+e2;
        textView.setText(sum);
    }

}
