package com.example.daggerproject;

import com.example.daggerproject.login.LoginActivity;
import com.example.daggerproject.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class , LoginModule.class})
public interface ApplicationComponent {

    void inject (LoginActivity target);
}
