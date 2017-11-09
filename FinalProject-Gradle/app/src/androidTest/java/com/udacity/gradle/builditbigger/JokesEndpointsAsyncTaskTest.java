package com.udacity.gradle.builditbigger;


import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Amir on 11/7/2017.
 */

public class JokesEndpointsAsyncTaskTest extends AndroidTestCase {

    String mResult;

    public void testNonEmptyJokeString(){
        mResult = "";
        CountDownLatch signal = new CountDownLatch(1);

        final JokesEndpointsAsyncTask jokesEndpointsAsyncTask = new JokesEndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String joke) {
                mResult = joke;
            }
        };
        jokesEndpointsAsyncTask.execute(getContext());

        try {
            signal.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue("Result: " + mResult, mResult.length() > 0);
    }
}