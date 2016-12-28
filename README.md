# easy-ui-tests
A helper library for Android that reduces the boilerplate code when writing UI tests with Espresso.

# Usage example
Add the following code to a UI test class:
```java
@Rule
public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

@Test
public void assertWelcomeText() throws Exception {
    UiTestsHelper.assertTextOnViewWithId(R.id.welcome_text_view, "Hello World!");
}
```
# Quick docs
All methods below are static and void
```java
assertTextOnListViewItem(String text)

assertTextOnRecyclerViewItem(int recyclerViewId, int position, int childViewId, String text)

assertTextOnViewWithId(int viewId, String text)

checkIfViewIsDisplayed(int viewId)

checkIfViewIsNotDisplayed(int viewId)

checkIfViewWithTextIsDisplayed(String text)

checkIfViewWithTextIsNotDisplayed(String text)

clickOnItemChildInRecyclerView(int recyclerViewId, int position, int childViewId)

clickOnItemInListView(int listViewId, int itemPosition)

clickOnItemInRecyclerView(int recyclerViewId, int position)

clickOnView(int viewId)

clickOnViewWithText(String text)

isButtonSelected(int buttonId)

replaceTextOnView(int viewId, String text)

scrollToAndClickOnView(int viewId)

scrollToAndClickOnViewWithText(String text)

scrollToPositionInRecyclerView(int recyclerViewId, int position)
```
# Download
```gradle
androidTestCompile 'com.sebamaty:easyuitests:1.0.6'
```
Make sure you have added [JUnit][junit] dependency. Android Studio won't find @Rule annotation and ActivityTestRule class otherwise.
[junit]: https://github.com/junit-team/junit4/wiki/Use-with-Gradle

# License
```
Copyright 2016 Sebastian Matysiak

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
