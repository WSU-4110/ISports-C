package com.First.ISportsC.ui;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ChatroomActivityTest {

    @Rule
    public Object mActivityTestRule;

    private Object ActivityTestRule;
    private Object View = ChatroomActivity.class;

    {
        mActivityTestRule = ActivityTestRule;
    }

    private final ActivityTestRule activityTestRule = new ActivityTestRule();

    public ChatroomActivityTest() {
        ActivityTestRule = null;
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        mActivityTestRule = null;

    }

    @Test
    public void onCreate() {

        Class<ChatroomActivity> output;

        Class<ChatroomActivity> expected = ChatroomActivity.class;

        ChatroomActivity chat = new ChatroomActivity();
        output = new ChatroomActivityTest().ActivityTestRule(expected);


    }

    private Class<ChatroomActivity> ActivityTestRule(Class<ChatroomActivity> expected) {
      return expected;
    }

    @Test
    public void onResume() {
        View output;

        Class<ChatroomActivity> expected = ChatroomActivity.class;

        ChatroomActivity chat = new ChatroomActivity();
    }

    @Test
    public void onDestroy() {
        View output;

        Class<ChatroomActivity> expected = ChatroomActivity.class;

        ChatroomActivity chat = new ChatroomActivity();
    }

    @Test
    public void onCreateOptionsMenu() {
        View output;

        Class<ChatroomActivity> expected = ChatroomActivity.class;

        ChatroomActivity chat = new ChatroomActivity();
    }

    @Test
    public void onOptionsItemSelected() {
        
    }

    @Test
    public void onClick() {
    }
}