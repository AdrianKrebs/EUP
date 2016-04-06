package org.mobi.bluemoon.authenticator;

public interface LogoutService {
    void logout(Runnable onSuccess);
}
