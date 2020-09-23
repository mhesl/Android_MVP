package com.example.daggerproject.login;

public class LoginModel implements LoginActivityMVP.Model {

    LoginRepository repository;


    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        repository.saveUser(new User(firstName , lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
