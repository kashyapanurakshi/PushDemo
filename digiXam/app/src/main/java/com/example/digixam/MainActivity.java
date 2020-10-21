package com.example.digixam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity<openStudentTeacherNavigation> extends AppCompatActivity {
    Button signInButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentTeacherNavigation();
            }
        });

        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrationPage();
            }
        });
    }
    public void openStudentTeacherNavigation(){
        Intent intent = new Intent(this,Student_Teacher_bottom_nav.class);
        startActivity(intent);
    }

    public void openRegistrationPage(){
        Intent intent = new Intent(this,Registration_Page.class);
        startActivity(intent);
    }
}

