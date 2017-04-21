package com.jengelmo.kwtfizzbuzz;

public class SessionApiClient {

    public void login(String username, String pass, LogInCallback logInCallback) {
        if (username.equals("kini") && pass.equals("pedro")) {
            logInCallback.onSuccess();
        } else {
            logInCallback.onError();
        }
    }

    public void logout(LogOutnCallback logOutnCallback) {
        if (System.currentTimeMillis() % 2 == 0) {
            logOutnCallback.onSuccess();
        } else {
            logOutnCallback.onError();
        }
    }


    interface LogInCallback {
        void onSuccess();

        void onError();
    }

    interface LogOutnCallback {
        void onSuccess();

        void onError();
    }
}
