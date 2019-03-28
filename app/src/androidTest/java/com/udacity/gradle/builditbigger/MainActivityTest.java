package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.v4.util.Pair;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.*;

import com.udacity.gradle.builditbigger.MainActivity.EndpointsAsyncTask;
import com.udacity.gradle.jokes.Joker;

import java.util.concurrent.ExecutionException;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testClick() throws ExecutionException, InterruptedException {
        EndpointsAsyncTask endpointsAsyncTask = mActivityRule.getActivity().new EndpointsAsyncTask();

        String joke = endpointsAsyncTask.execute(new Pair<Context, String>(mActivityRule.getActivity(), new Joker().getJoke())).get();
        assertNotNull(joke);
        assertThat(joke, not(isEmptyString()));
    }

}