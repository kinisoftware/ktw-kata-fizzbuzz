package com.jengelmo.kwtfizzbuzz;

public class SessionApiClient {

    interface LogInCallback {
        void onSuccess();

        void onError();
    }

    interface LogOutnCallback {
        void onSuccess();

        void onError();
    }


    public void login(String username, String pass, LogInCallback logInCallback) {
        if (username.equals("Kini") && pass.equals("pedroguapo")) {
            logInCallback.onSuccess();
        }
        logInCallback.onError();
    }

    public void logout(LogOutnCallback logOutnCallback) {
        if (System.currentTimeMillis() % 2 == 0) {
            logOutnCallback.onSuccess();
        }
        logOutnCallback.onError();
    }
}
