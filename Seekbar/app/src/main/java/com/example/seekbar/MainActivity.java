package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seek_bar();
    }
    public void seek_bar(){
        seekBar = findViewById(R.id.seek);
        textView = findViewById(R.id.text);
        textView.setText("Covered : "+seekBar.getProgress()+"/"+seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        textView.setText("Covered : "+progress+"/"+seekBar.getMax());
                        Toast.makeText(MainActivity.this,"SeekBar in progress",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this,"SeekBar in StartTracking",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textView.setText("Covered : "+progress_value+"/"+seekBar.getMax());
                        Toast.makeText(MainActivity.this,"SeekBar in onStopTracking",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
