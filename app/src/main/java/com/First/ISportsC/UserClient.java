package com.First.ISportsC;

import android.app.Application;

import com.First.ISportsC.models.User;

public class UserClient extends Application {

    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
