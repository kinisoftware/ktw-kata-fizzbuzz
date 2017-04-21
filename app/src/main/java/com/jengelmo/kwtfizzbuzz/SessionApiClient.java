package com.jengelmo.kwtfizzbuzz;

public class SessionApiClient {

    private final Executor executor;
    private final Clock clock;

    public SessionApiClient(Executor executor, Clock clock) {
        this.executor = executor;
        this.clock = clock;
    }

    public void login(final String username, final String pass, final LogInCallback logInCallback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (username.equals("kini") && pass.equals("pedro")) {
                    logInCallback.onSuccess();
                } else {
                    logInCallback.onError();
                }
            }
        });
    }

    public void logout(final LogOutCallback logOutCallback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (clock.getTime() % 2 == 0) {
                    logOutCallback.onSuccess();
                } else {
                    logOutCallback.onError();
                }
            }
        });
    }

    interface Clock {
        long getTime();
    }

    interface Executor {
        void execute(Runnable runnable);
    }

    interface LogInCallback {
        void onSuccess();

        void onError();
    }


    interface LogOutCallback {
        void onSuccess();

        void onError();
    }

    static class FakeExecutor implements Executor {
        @Override
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

}
