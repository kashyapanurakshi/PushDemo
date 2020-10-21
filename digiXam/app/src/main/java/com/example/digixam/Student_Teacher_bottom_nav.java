package com.example.digixam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Student_Teacher_bottom_nav extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__teacher_bottom_nav);

        bottomNavigationView = findViewById(R.id.studentTeacherBottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
    }

    public BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.home: selectedFragment = new HomeFragment();
                break;

                case R.id.student: selectedFragment = new StudentFragment();
                    break;

                case R.id.teacher: selectedFragment = new TeacherFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,selectedFragment).commit();

            return true;
        }
    };
}