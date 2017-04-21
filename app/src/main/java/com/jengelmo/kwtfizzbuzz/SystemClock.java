package com.jengelmo.kwtfizzbuzz;

/**
 * Created by jengelmo on 21/04/17.
 */
class SystemClock implements SessionApiClient.Clock {

    @Override
    public long getTime() {
        return System.currentTimeMillis();
    }
}
