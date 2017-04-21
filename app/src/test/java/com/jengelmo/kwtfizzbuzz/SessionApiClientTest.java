package com.jengelmo.kwtfizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionApiClientTest {

    SessionApiClient.Clock clock;
    SessionApiClient sessionApiClient;

    @Before
    public void setUp() throws Exception {
        clock = mock(SessionApiClient.Clock.class);

        sessionApiClient = new SessionApiClient(new SessionApiClient.FakeExecutor(), clock);
    }

    @Test
    public void shouldLoginFailWhenUserIsWrongAndPassIsOkay() throws Exception {
        LogInCallbackFake logInCallbackFake = new LogInCallbackFake();

        sessionApiClient.login("wrong", "pedro", logInCallbackFake);

        assertTrue(logInCallbackFake.onErrorCalled);
        assertFalse(logInCallbackFake.onSuccessCalled);
    }

    @Test
    public void shouldLoginFailWhenUsernameIsOkayAndPassIsWrong() throws Exception {
        LogInCallbackFake logInCallbackFake = new LogInCallbackFake();

        sessionApiClient.login("kini", "wrong", logInCallbackFake);

        assertTrue(logInCallbackFake.onErrorCalled);
        assertFalse(logInCallbackFake.onSuccessCalled);
    }

    @Test
    public void shouldLoginSuccessWhenUsernameAndPassAreCorrect() throws Exception {
        LogInCallbackFake logInCallbackFake = new LogInCallbackFake();

        sessionApiClient.login("kini", "pedro", logInCallbackFake);

        assertTrue(logInCallbackFake.onSuccessCalled);
        assertFalse(logInCallbackFake.onErrorCalled);
    }

    @Test
    public void shouldLogoutSuccessWhenClockIsEven() throws Exception {
        LogOutCallbackFake logOutCallbackFake = new LogOutCallbackFake();
        when(clock.getTime()).thenReturn(Long.valueOf(2));

        sessionApiClient.logout(logOutCallbackFake);

        assertTrue(logOutCallbackFake.onSuccessCalled);
        assertFalse(logOutCallbackFake.onErrorCalled);
    }

    @Test
    public void shouldLogoutFailWhenClockIsOdd() throws Exception {
        LogOutCallbackFake logOutCallbackFake = new LogOutCallbackFake();
        when(clock.getTime()).thenReturn(Long.valueOf(3));

        sessionApiClient.logout(logOutCallbackFake);

        assertTrue(logOutCallbackFake.onErrorCalled);
        assertFalse(logOutCallbackFake.onSuccessCalled);
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

    private class LogOutCallbackFake implements SessionApiClient.LogOutCallback {

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
