package com.First.ISportsC.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void setTitle() {
        String chatroom_id = "12345";
        String title = "Soccer";
        String outputID;
        String outputTitle;

        Game game = new Game();

        outputID = game.setTitle(chatroom_id);
        outputTitle = game.setTitle(title);

        assertSame(outputID,"12345");
        assertSame(outputTitle,"12345");
    }

    @Test
    public void getChatroom_id() {
        String chatroom_id = "12345";
        String title = "Soccer";
        assertSame(chatroom_id,"12345");
        assertSame(title,"12345");
    }

    @Test
    public void setChatroom_id() {
        String chatroom_id = "12345";
        String title = "Soccer";
        String outputID;
        String outputTitle;

        Game game = new Game();

        outputID = game.setChatroom_id(chatroom_id);
        outputTitle = game.setChatroom_id(title);

        assertSame(outputID,"12345");
        assertSame(outputTitle,"12345");
    }

    @Test
    public void toString1() {
        String chatroom_id = "12345";
        String title = "Soccer";
        assertSame(chatroom_id,"12345");
        assertSame(title,"12345");
    }

    @Test
    public void describeContents() {
        assertEquals(0,0);
    }

    @Test
    public void writeToParcel() {
        String chatroom_id = "12345";
        String title = "Soccer";
        assertSame(chatroom_id,"12345");
        assertSame(title,"12345");
    }
}