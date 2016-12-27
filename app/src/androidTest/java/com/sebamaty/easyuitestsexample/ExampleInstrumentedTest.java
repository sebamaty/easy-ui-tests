package com.sebamaty.easyuitestsexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.sebamaty.easyuitests.UiTestsHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void assertWelcomeText() throws Exception {
        UiTestsHelper.assertTextOnViewWithId(R.id.welcome_text_view, "Hello World!");
    }
}

