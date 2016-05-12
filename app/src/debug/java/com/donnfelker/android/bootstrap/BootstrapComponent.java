package org.mobi.bluemoon;

import org.mobi.bluemoon.authenticator.BootstrapAuthenticatorActivity;
import org.mobi.bluemoon.core.TimerService;
import org.mobi.bluemoon.ui.BootstrapActivity;
import org.mobi.bluemoon.ui.BootstrapFragmentActivity;
import org.mobi.bluemoon.ui.BootstrapTimerActivity;
import org.mobi.bluemoon.ui.view.fragments.DetailsFragment;
import org.mobi.bluemoon.ui.MainActivity;
import org.mobi.bluemoon.ui.NavigationDrawerFragment;
import org.mobi.bluemoon.ui.OverviewFragment;
import org.mobi.bluemoon.ui.ProfileActivity;
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

    void inject(DetailsFragment target);

    void inject(OverviewFragment target);

    void inject(NavigationDrawerFragment target);

    void inject(UserActivity target);

    void inject(UserListFragment target);

    void inject(ProfileActivity target);

    void inject(TimerService target);

    void inject(BootstrapFragmentActivity target);
    void inject(BootstrapActivity target);


}
