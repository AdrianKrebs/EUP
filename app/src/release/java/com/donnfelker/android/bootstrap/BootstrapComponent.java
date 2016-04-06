package org.mobi.bluemoon;

import org.mobi.bluemoon.authenticator.BootstrapAuthenticatorActivity;
import org.mobi.bluemoon.core.TimerService;
import org.mobi.bluemoon.ui.BootstrapActivity;
import org.mobi.bluemoon.ui.BootstrapFragmentActivity;
import org.mobi.bluemoon.ui.BootstrapTimerActivity;
import org.mobi.bluemoon.ui.CheckInsListFragment;
import org.mobi.bluemoon.ui.MainActivity;
import org.mobi.bluemoon.ui.NavigationDrawerFragment;
import org.mobi.bluemoon.ui.NewsActivity;
import org.mobi.bluemoon.ui.NewsListFragment;
import org.mobi.bluemoon.ui.UserActivity;
import org.mobi.bluemoon.ui.UserListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AndroidModule.class,
                BootstrapModule.class
        }
)
public interface BootstrapComponent {

    void inject(BootstrapApplication target);

    void inject(BootstrapAuthenticatorActivity target);

    void inject(BootstrapTimerActivity target);

    void inject(MainActivity target);

    void inject(CheckInsListFragment target);

    void inject(NavigationDrawerFragment target);

    void inject(NewsActivity target);

    void inject(NewsListFragment target);

    void inject(UserActivity target);

    void inject(UserListFragment target);

    void inject(TimerService target);

    void inject(BootstrapFragmentActivity target);
    void inject(BootstrapActivity target);


}
