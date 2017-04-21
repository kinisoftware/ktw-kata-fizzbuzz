package com.jengelmo.kwtfizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SessionApiClientTest {

    @Test
    public void shouldLoginFailWhenUserIsEmpty() throws Exception {
        SessionApiClient sessionApiClient = new SessionApiClient(new SessionApiClient.FakeExecutor());
        LogInCallbackFake logInCallbackFake = new LogInCallbackFake();

        sessionApiClient.login("", "pass", logInCallbackFake);

        assertTrue(logInCallbackFake.onErrorCalled);
        assertFalse(logInCallbackFake.onSuccessCalled);
    }

    private class LogInCallbackFake implements SessionApiClient.LogInCallback {

        boolean onSuccessCalled;
        boolean onErrorCalled;

        @Override
        public void onSuccess() {
            onSuccessCalled = true;
        }

        @Override
        public void onError() {
            onErrorCalled = true;
        }
    }
}
