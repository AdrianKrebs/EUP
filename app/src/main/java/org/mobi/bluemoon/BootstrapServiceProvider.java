package org.mobi.bluemoon;

import android.accounts.AccountsException;
import android.app.Activity;

import org.mobi.bluemoon.core.BootstrapService;

import java.io.IOException;

public interface BootstrapServiceProvider {
    BootstrapService getService(Activity activity) throws IOException, AccountsException;
}
