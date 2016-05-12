

package org.mobi.bluemoon;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;


/**
 * bluemoon application
 */
public abstract class BootstrapApplication extends Application {

    private static BootstrapApplication instance;
    private org.mobi.bluemoon.BootstrapComponent component;

    /**
     * Create main application
     */
    public BootstrapApplication() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);

        init();

        instance = this;

        // Perform injection
        //Injector.init(this, )
        component = DaggerComponentInitializer.init();

        onAfterInjection();
    }
    public static org.mobi.bluemoon.BootstrapComponent component() {
        return instance.component;
    }

    protected abstract void onAfterInjection();

    protected abstract void init();

    public static BootstrapApplication getInstance() {
        return instance;
    }

    public org.mobi.bluemoon.BootstrapComponent getComponent() {
        return component;
    }

    public final static class DaggerComponentInitializer {

        public static org.mobi.bluemoon.BootstrapComponent init() {
            return DaggerBootstrapComponent.builder()
                    .androidModule(new AndroidModule())
                    .bootstrapModule(new BootstrapModule())
                    .build();
        }

    }
}
