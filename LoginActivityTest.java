package com.First.ISportsC.ui;

import android.arch.lifecycle.ReportFragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.First.ISportsC.R;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static com.google.common.util.concurrent.Runnables.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;

@RunWith(PowerMockRunner.class)

import android.arch.lifecycle.ReportFragment;
import android.widget.SimpleCursorAdapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginActivityTest {


    @Test
    public void testOnCreate() {
            mockStatic(ReportFragment.class);
            LoginActivity activity = spy(new LoginActivity());
            doNothing().when(activity).initScreen();
            doNothing().when(activity).setContentView(R.layout.activity_login);
            doReturn(mock(AppCompatDelegate.class)).when(activity).getDelegate();

            activity.onCreate(null);

            verify(activity,times(1)).setContentView(R.layout.activity_login);
            verify(activity,times(1)).initScreen();
    }

    @Test
    public void testOnStart() throws Exception{
        View output;
        Class<LoginActivity> expected = LoginActivity.class;

        LoginActivity login = new LoginActivity();


    }

    @Test
    public void onStop() throws Exception{
        View output;

        Class<LoginActivity> expected = LoginActivity.class;

        LoginActivity login = new LoginActivity();
    }

    @Test
    public void onClick() throws Exception {
        View output;

        Class<LoginActivity> expected = LoginActivity.class;

        LoginActivity login = new LoginActivity();
    }
    }
}