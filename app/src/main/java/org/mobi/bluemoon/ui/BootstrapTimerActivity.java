package org.mobi.bluemoon.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.mobi.bluemoon.BootstrapApplication;
import org.mobi.bluemoon.R;
import org.mobi.bluemoon.core.PauseTimerEvent;
import org.mobi.bluemoon.core.ResumeTimerEvent;
import org.mobi.bluemoon.core.StopTimerEvent;
import org.mobi.bluemoon.core.TimerPausedEvent;
import org.mobi.bluemoon.core.TimerService;
import org.mobi.bluemoon.core.TimerTickEvent;
import org.mobi.bluemoon.util.TimeUtil;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import butterknife.Bind;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class BootstrapTimerActivity extends BootstrapFragmentActivity  {

    @Inject
    Bus eventBus;

    @Bind(R.id.spinner_condition)
    protected Spinner testSpinner;

    @Bind(R.id.spinner_condition2)
    protected Spinner testSpinner2;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BootstrapApplication.component().inject(this);

        setContentView(R.layout.settings);

        setTitle(R.string.settings);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_condition = ArrayAdapter.createFromResource(this,
                R.array.location_array, android.R.layout.simple_spinner_item);

        adapter_condition.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        testSpinner.setAdapter(adapter_condition);
        testSpinner2.setAdapter(adapter_condition);
    }


    private void sendHttpRequest() {
/*
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);*/


    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            // Source:
            // http://developer.android.com/training/implementing-navigation/ancestral.html
            // This is the home button in the top left corner of the screen.
            case android.R.id.home:
                final Intent upIntent = NavUtils.getParentActivityIntent(this);
                // If parent is not properly defined in AndroidManifest.xml upIntent will be null
                // TODO hanlde upIntent == null
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Starts the timer service
     */
    private void startTimer() {
        if (!isTimerServiceRunning()) {
            final Intent i = new Intent(this, TimerService.class);
            startService(i);

          //  setButtonVisibility(GONE, VISIBLE, GONE, VISIBLE);
        }
    }

    /**
     * Posts a {@link StopTimerEvent} message to the {@link Bus}
     */
    private void produceStopEvent() {
        eventBus.post(new StopTimerEvent());
    }

    /**
     * Posts a {@link PauseTimerEvent} message to the {@link Bus}
     */
    private void producePauseEvent() {
        eventBus.post(new PauseTimerEvent());
    }

    /**
     * Posts a {@link ResumeTimerEvent} message to the {@link Bus}
     */
    private void produceResumeEvent() {
        eventBus.post(new ResumeTimerEvent());
    }

    @Subscribe
    public void onTimerPausedEvent(final TimerPausedEvent event) {
        if (event.isTimerIsPaused()) {
           // setButtonVisibility(GONE, VISIBLE, VISIBLE, GONE);
        } else if (isTimerServiceRunning()) {
           // setButtonVisibility(GONE, VISIBLE, GONE, VISIBLE);
        }
    }

    /**
     * Called by {@link Bus} when a tick event occurs.
     *
     * @param event The event
     */
    @Subscribe
    public void onTickEvent(final TimerTickEvent event) {
        setFormattedTime(event.getMillis());
    }

    /**
     * Called by {@link Bus} when a tick event occurs.
     *
     * @param event The event
     */
    @Subscribe
    public void onPauseEvent(final PauseTimerEvent event) {
       // setButtonVisibility(GONE, VISIBLE, VISIBLE, GONE);
    }

    /**
     * Called by {@link Bus} when a tick event occurs.
     *
     * @param event The event
     */
    @Subscribe
    public void onResumeEvent(final ResumeTimerEvent event) {
       // setButtonVisibility(GONE, VISIBLE, GONE, VISIBLE);
    }

    /**
     * Called by {@link Bus} when a tick event occurs.
     *
     * @param event The event
     */
    @Subscribe
    public void onStopEvent(final StopTimerEvent event) {
        //setButtonVisibility(VISIBLE, GONE, GONE, GONE);
        setFormattedTime(0); // Since its stopped, zero out the timer.
    }

    /**
     * Checks to see if the timer service is running or not.
     *
     * @return true if the service is running otherwise false.
     */
    private boolean isTimerServiceRunning() {
        final ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (TimerService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


    /**
     * Sets the formatted time
     *
     * @param millis the elapsed time
     */
    private void setFormattedTime(long millis) {
        final String formattedTime = TimeUtil.formatTime(millis);
        //chronometer.setText(formattedTime);
    }


}
