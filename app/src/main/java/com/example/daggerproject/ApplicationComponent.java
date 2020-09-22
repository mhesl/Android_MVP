package com.example.daggerproject;

import com.example.daggerproject.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject (LoginActivity target);
}
