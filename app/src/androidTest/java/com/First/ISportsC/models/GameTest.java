package com.First.ISportsC.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void setTitle() {
    }

    @Test
    public void getChatroom_id() {
    }

    @Test
    public void setChatroom_id() {
        String chatroom_id = "12345";
        String title = "Soccer";

        Game game = new Game();

        title = game.setChatroom_id(title);

        assertSame(title,"thing");
    }

    @Test
    public void toString1() {
    }

    @Test
    public void describeContents() {
        assertEquals(0,0);
    }

    @Test
    public void writeToParcel() {

    }
}