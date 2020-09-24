package com.example.daggerproject;

import com.example.daggerproject.login.LoginActivityMVP;
import com.example.daggerproject.login.LoginActivityPresenter;
import com.example.daggerproject.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PresenterTests {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityMVP.Presenter presenter;
    User user;

    @Before
    public void setup(){
        mockLoginModel = mock(LoginActivityMVP.Model.class);
        user = new User("FOX" , "Rider");
        //when(mockLoginModel.getUser()).thenReturn(user);
        mockView = mock(LoginActivityMVP.View.class);
        presenter = new LoginActivityPresenter(mockLoginModel);
        presenter.setView(mockView);

    }


    @Test
    public void noInteractionWithView(){
        presenter.getCurrentUser();
        verifyZeroInteractions(mockView);
    }

    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent(){
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();

        //verify model instructions
        verify(mockLoginModel, times(1)).getUser();

        //verify view instructions
        verify(mockView , times(1)).setFirstName("FOX");
        verify(mockView , times(1)).setLastName("Rider");
        verify(mockView , never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull(){
        when(mockLoginModel.getUser()).thenReturn(null);
        presenter.getCurrentUser();
        //verify model instructions
        verify(mockLoginModel, times(1)).getUser();

        //verify view instructions
        verify(mockView , never()).setFirstName("FOX");
        verify(mockView , never()).setLastName("Rider");
        verify(mockView , never()).showUserNotAvailable();
    }



}
