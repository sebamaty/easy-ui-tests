package com.sebamaty.easyuitests;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;

public class UiTestsHelper {

    public static void clickOnView(int viewId) {
        Espresso.onView(ViewMatchers.withId(viewId)).perform(ViewActions.click());
    }

    public static void clickOnViewWithText(String text) {
        Espresso.onView(ViewMatchers.withText(text)).perform(ViewActions.click());
    }

    public static void scrollToAndClickOnView(int viewId) {
        Espresso.onView(ViewMatchers.withId(viewId)).perform(ViewActions.scrollTo(), ViewActions.click());
    }

    public static void scrollToAndClickOnViewWithText(String text) {
        Espresso.onView(ViewMatchers.withText(text)).perform(ViewActions.scrollTo(), ViewActions.click());
    }

    public static void checkIfViewIsDisplayed(int viewId) {
        Espresso.onView(ViewMatchers.withId(viewId)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    public static void checkIfViewIsNotDisplayed(int viewId) {
        Espresso.onView(ViewMatchers.withId(viewId)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())));
    }

    public static void checkIfViewWithTextIsDisplayed(String text) {
        Espresso.onView(ViewMatchers.withText(text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    public static void checkIfViewWithTextIsNotDisplayed(String text) {
        Espresso.onView(ViewMatchers.withText(text)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())));
    }

    public static void assertTextOnViewWithId(int viewId, String text) {
        Espresso.onView(ViewMatchers.withId(viewId)).check(ViewAssertions.matches(ViewMatchers.withText(text)));
    }

    public static void replaceTextOnView(int viewId, String text) {
        Espresso.onView(ViewMatchers.withId(viewId)).perform(ViewActions.replaceText(text));
    }

    public static void clickOnItemInListView(int listViewId, int itemPosition) {
        Espresso.onData(Matchers.anything())
                .inAdapterView(ViewMatchers.withId(listViewId))
                .atPosition(itemPosition)
                .perform(ViewActions.click());
    }

    public static void assertTextOnListViewItem(String text) {
        Espresso.onData(Matchers.allOf(Matchers.is(Matchers.instanceOf(String.class)), Matchers.is(text))).check(ViewAssertions.matches(ViewMatchers.withText(text)));
    }

    public static void assertTextOnRecyclerViewItem(int recyclerViewId, int position, int childViewId, String text) {
        Espresso.onView(withRecyclerView(recyclerViewId)
                .atPositionOnView(position, childViewId))
                .check(ViewAssertions.matches(ViewMatchers.withText(text)));
    }

    public static void clickOnItemInRecyclerView(int recyclerViewId, int position) {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(recyclerViewId), ViewMatchers.isCompletelyDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, ViewActions.click()));
    }

    public static void scrollToPositionInRecyclerView(int recyclerViewId, int position) {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(recyclerViewId), ViewMatchers.isCompletelyDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, ViewActions.scrollTo()));
    }

    public static void clickOnItemChildInRecyclerView(int recyclerViewId, int position, int childViewId) {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(recyclerViewId), ViewMatchers.isCompletelyDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, ChildViewAction.clickChildViewWithId(childViewId)));
    }

    private static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    public static void isButtonSelected(int buttonId) {
        Espresso.onView(ViewMatchers.withId(buttonId)).check(ViewAssertions.matches(ViewMatchers.isSelected()));
    }
}
