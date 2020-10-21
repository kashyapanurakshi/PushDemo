package com.example.daggerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.daggerexample.car.Car;
import com.example.daggerexample.dagger.CarComponent;

import com.example.daggerexample.dagger.DaggerCarComponent;
import com.example.daggerexample.dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.builder()
                .horsePower(160)
                .engineCapacity(1400)
                .build();
        //car = component.getCar();
        component.inject(this);
        car.drive();
    }
}
