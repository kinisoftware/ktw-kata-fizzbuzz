package com.jengelmo.kwtfizzbuzz;

public class SessionApiClient {

    private final Executor executor;

    public SessionApiClient(Executor executor) {
        this.executor = executor;
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

    public void logout(final LogOutnCallback logOutnCallback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (System.currentTimeMillis() % 2 == 0) {
                    logOutnCallback.onSuccess();
                } else {
                    logOutnCallback.onError();
                }
            }
        });
    }

    interface Executor {
        void execute(Runnable runnable);
    }

    interface LogInCallback {
        void onSuccess();

        void onError();
    }


    interface LogOutnCallback {
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
