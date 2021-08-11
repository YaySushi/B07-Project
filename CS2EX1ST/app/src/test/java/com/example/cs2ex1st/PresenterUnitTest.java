package com.example.cs2ex1st;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class PresenterUnitTest {
    @Mock
    LogInActivity view;

    @Mock
    Model model;

    @Test
    public void validateUser_emptyEmail()
    {
        when(view.getEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("kek");
        Presenter presenter=new Presenter(model,view);
        presenter.validateUser();
        verify(view).displayMessage("Email address cannot be empty.");
    }
    @Test
    public void validateUser_emptyPassword()
    {
        when(view.getEmail()).thenReturn("lol");
        when(view.getPassword()).thenReturn("");
        Presenter presenter=new Presenter(model,view);
        presenter.validateUser();
        verify(view).displayMessage("Password cannot be empty");
    }
    @Test
    public void validateUser_emptyBoth()
    {
        when(view.getEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("");
        Presenter presenter=new Presenter(model,view);
        presenter.validateUser();
        verify(view).displayMessage("Email address cannot be empty.");
    }
    @Test
    public void validateUser_wrongEmail()
    {
        when(view.getEmail()).thenReturn("null@b07.com");
        when(view.getPassword()).thenReturn("kek");
        when(model.checkEmail("null@b07*com")).thenReturn(false);
        Presenter presenter=new Presenter(model,view);
        presenter.validateUser();
        verify(view).displayMessage("Email address is incorrect.");
    }
    @Test
    public void validateUser_wrongPwd()
    {
        when(view.getEmail()).thenReturn("null@b07.com");
        when(view.getPassword()).thenReturn("kek");
        when(model.checkEmail("null@b07*com")).thenReturn(true);
        when(model.checkPassword("null@b07.com","kek")).thenReturn(false);
        Presenter presenter=new Presenter(model,view);
        presenter.validateUser();
        verify(view).displayMessage("Password is incorrect.");
    }
    @Test
    public void validateUser_doctorSuccess()
    {
        when(view.getEmail()).thenReturn("null@b07.com");
        when(view.getPassword()).thenReturn("kek");
        when(model.checkEmail("null@b07*com")).thenReturn(true);
        when(model.checkPassword("null@b07*com","kek")).thenReturn(true);
        when(model.isDoctor("null@b07*com")).thenReturn(true);
        Presenter presenter=new Presenter(model,view);
        presenter.validateUser();
        verify(view).displayMessage("");
    }
    @Test
    public void validateUser_patientSuccess()
    {
        when(view.getEmail()).thenReturn("null@b07.com");
        when(view.getPassword()).thenReturn("kek");
        when(model.checkEmail("null@b07*com")).thenReturn(true);
        when(model.checkPassword("null@b07*com","kek")).thenReturn(true);
        when(model.isDoctor("null@b07*com")).thenReturn(false);
        Presenter presenter=new Presenter(model,view);
        presenter.validateUser();
        verify(view).displayMessage("");
    }
}