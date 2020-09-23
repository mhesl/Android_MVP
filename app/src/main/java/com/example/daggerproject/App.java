package com.example.daggerproject;

import android.app.Application;

import com.example.daggerproject.login.LoginModel;
import com.example.daggerproject.login.LoginModule;


public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }


    public ApplicationComponent getComponent(){
        return component;
    }

}
