package com.example.vector

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import com.example.vector.presentation.main.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// This espresso test will pass through app flow and certify no crashes appear!

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.numberField),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("25"), closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withText("Verificar"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatButton2 = onView(
            allOf(
                withText("Histórico de Consulta"),
                childAtPosition(
                    allOf(
                        withId(R.id.bottom),
                        childAtPosition(
                            withClassName(`is`("android.widget.RelativeLayout")),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val appCompatTextView = onView(
            allOf(
                withText("<"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.support.v7.widget.Toolbar")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatTextView.perform(click())

        val appCompatButton3 = onView(
            allOf(
                withText("Redefinir Lista"),
                childAtPosition(
                    allOf(
                        withId(R.id.bottom),
                        childAtPosition(
                            withClassName(`is`("android.widget.RelativeLayout")),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val appCompatButton4 = onView(
            allOf(
                withText("Histórico de Consulta"),
                childAtPosition(
                    allOf(
                        withId(R.id.bottom),
                        childAtPosition(
                            withClassName(`is`("android.widget.RelativeLayout")),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())

        val appCompatTextView2 = onView(
            allOf(
                withText("Apagar"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.support.v7.widget.Toolbar")),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatTextView2.perform(click())

        val appCompatTextView3 = onView(
            allOf(
                withText("<"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.support.v7.widget.Toolbar")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatTextView3.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
