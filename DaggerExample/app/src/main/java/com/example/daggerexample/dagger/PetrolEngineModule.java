package com.example.daggerexample.dagger;

import com.example.daggerexample.car.Engine;
import com.example.daggerexample.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
