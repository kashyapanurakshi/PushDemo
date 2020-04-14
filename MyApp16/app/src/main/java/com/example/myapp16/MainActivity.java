package com.example.myapp16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText = new EditText(this);
    Button button_sel = new Button(this);
    EditText password = new EditText(this);
    TextView attempt = new TextView(this);
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attempt.setText(attempt_counter);
        ButtonListener();
    }
    void ButtonListener(){
        editText = findViewById(R.id.edit);
        password = findViewById(R.id.pass);
        button_sel = findViewById(R.id.button);
        attempt = findViewById(R.id.text5);
        button_sel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editText.getText().toString().equals("username") && password.getText().toString().equals("pass")) {
                            Toast.makeText(MainActivity.this, "Correct username and password", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,userActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Incorrect username and password", Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            attempt.setText(attempt_counter);

                            if(attempt_counter==0)
                                button_sel.setEnabled(false);
                        }
                    }
                }
        );

    }
}
