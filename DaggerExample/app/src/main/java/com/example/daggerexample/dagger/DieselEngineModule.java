package com.example.daggerexample.dagger;

import com.example.daggerexample.car.DieselEngine;
import com.example.daggerexample.car.Engine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public  class DieselEngineModule {
    private int horsepower;

    public DieselEngineModule(int horsepower){
        this.horsepower = horsepower;
    }

    @Provides
    int provideHorsePower(){
        return horsepower;
    }

    @Provides
     Engine provideEngine(DieselEngine engine){
        return engine;
    }
}
