package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTime();
    }

    public void showTime(){
        timePicker = findViewById(R.id.time);
        button = findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getBaseContext(),timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
