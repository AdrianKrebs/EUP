package org.mobi.bluemoon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.mobi.bluemoon.BootstrapApplication;
import org.mobi.bluemoon.db.Fahrer;
import org.mobi.bluemoon.db.Fahrzeug;
import org.mobi.bluemoon.db.Unfall;
import org.mobi.bluemoon.db.Unfallumstaende;
import org.mobi.bluemoon.db.Versicherungsunternehmen;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

/**
 * Base activity for a Bootstrap activity which does not use fragments.
 */
public abstract class BootstrapActivity extends AppCompatActivity {

    @Inject protected Bus bus;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BootstrapApplication.component().inject(this);

        Configuration.Builder config = new Configuration.Builder(this);
        config.addModelClasses(Fahrer.class, Fahrzeug.class, Unfall.class, Unfallumstaende.class, Versicherungsunternehmen.class);
        ActiveAndroid.initialize(config.create());
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Override
    public void setContentView(final int layoutResId) {
        super.setContentView(layoutResId);

        // Used to inject views with the Butterknife library
        ButterKnife.bind(this);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            // This is the home button in the top left corner of the screen.
            case android.R.id.home:
                // Don't call finish! Because activity could have been started by an
                // outside activity and the home button would not operated as expected!
                final Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.addFlags(FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(homeIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
