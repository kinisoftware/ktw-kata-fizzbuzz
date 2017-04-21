package com.jengelmo.kwtfizzbuzz;

/**
 * Created by jengelmo on 21/04/17.
 */
class ThreadExecutor implements SessionApiClient.Executor {

    @Override
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
