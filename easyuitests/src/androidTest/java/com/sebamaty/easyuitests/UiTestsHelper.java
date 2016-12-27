package com.sebamaty.easyuitests;

import android.support.test.espresso.contrib.RecyclerViewActions;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class UiTestsHelper {

    public static void clickOnView(int viewId) {
        onView(withId(viewId)).perform(click());
    }

    public static void clickOnViewWithText(String text) {
        onView(withText(text)).perform(click());
    }

    public static void scrollToAndClickOnView(int viewId) {
        onView(withId(viewId)).perform(scrollTo(), click());
    }

    public static void scrollToAndClickOnViewWithText(String text) {
        onView(withText(text)).perform(scrollTo(), click());
    }

    public static void checkIfViewIsDisplayed(int viewId) {
        onView(withId(viewId)).check(matches(isDisplayed()));
    }

    public static void checkIfViewIsNotDisplayed(int viewId) {
        onView(withId(viewId)).check(matches(not(isDisplayed())));
    }

    public static void checkIfViewWithTextIsDisplayed(String text) {
        onView(withText(text)).check(matches(isDisplayed()));
    }

    public static void checkIfViewWithTextIsNotDisplayed(String text) {
        onView(withText(text)).check(matches(not(isDisplayed())));
    }

    public static void assertTextOnViewWithId(int viewId, String text) {
        onView(withId(viewId)).check(matches(withText(text)));
    }

    public static void replaceTextOnView(int viewId, String text) {
        onView(withId(viewId)).perform(replaceText(text));
    }

    public static void clickOnItemInListView(int listViewId, int itemPosition) {
        onData(anything())
                .inAdapterView(withId(listViewId))
                .atPosition(itemPosition)
                .perform(click());
    }

    public static void assertTextOnListViewItem(String text) {
        onData(allOf(is(instanceOf(String.class)), is(text))).check(matches(withText(text)));
    }

    public static void assertTextOnRecyclerViewItem(int recyclerViewId, int position, int childViewId, String text) {
        onView(withRecyclerView(recyclerViewId)
                .atPositionOnView(position, childViewId))
                .check(matches(withText(text)));
    }

    public static void clickOnItemInRecyclerView(int recyclerViewId, int position) {
        onView(allOf(withId(recyclerViewId), isCompletelyDisplayed()))
                .perform(actionOnItemAtPosition(position, click()));
    }

    public static void scrollToPositionInRecyclerView(int recyclerViewId, int position) {
        onView(allOf(withId(recyclerViewId), isCompletelyDisplayed()))
                .perform(actionOnItemAtPosition(position, scrollTo()));
    }

    public static void clickOnItemChildInRecyclerView(int recyclerViewId, int position, int childViewId) {
        onView(allOf(withId(recyclerViewId), isCompletelyDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, ChildViewAction.clickChildViewWithId(childViewId)));
    }

    private static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    public static void isButtonSelected(int buttonId) {
        onView(withId(buttonId)).check(matches(isSelected()));
    }
}
