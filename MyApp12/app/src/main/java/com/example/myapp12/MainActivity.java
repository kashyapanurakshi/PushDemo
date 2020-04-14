package com.example.myapp12;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static RatingBar ratingBar;
    public static Button button;
    public static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addRatingBarListener();
        addButtonListener();
    }
    public void addRatingBarListener(){
        ratingBar = findViewById(R.id.rating_bar);

        textView = findViewById(R.id.text);

        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        textView.setText(String.valueOf(rating));
                    }
                }
        );
    }

    public void addButtonListener(){
        button = findViewById(R.id.button_select);
        ratingBar = findViewById(R.id.rating_bar);

        button.setOnClickListener(
          new View.OnClickListener(){
              public void onClick(View v){
                  Toast.makeText(MainActivity.this,String.valueOf(ratingBar.getRating()),Toast.LENGTH_SHORT).show();
              }
          }

        );
    }

}
