package org.mobi.bluemoon.ui.view.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.activeandroid.query.Select;

import org.mobi.bluemoon.BootstrapApplication;
import org.mobi.bluemoon.R;
import org.mobi.bluemoon.db.Unfall;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailsFragment extends Fragment {

    @Bind(R.id.verletzteJa)
    protected CheckBox verletzeJa;
    @Bind(R.id.verletzteNein)
    protected CheckBox verletzteNein;

    @Bind(R.id.sachschadenJa)
    protected CheckBox sachschadenJa;
    @Bind(R.id.sachschadenNein)
    protected CheckBox sachschadenNein;

    @Bind(R.id.gegenstaendeJa)
    protected CheckBox gegenstaendeJa;
    @Bind(R.id.gegenstaendeNein)
    protected CheckBox gegenstaendeNein;

    Unfall unfall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BootstrapApplication.component().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.verletzungen, container, false);
        ButterKnife.bind(this, view);

        verletzeJa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Verletzte")
                            .setMessage("Sobald Verletzte involviert sind muss zwingend die Polizei alarmiert werden.")
                            .setPositiveButton("Polizei alarmieren", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setNegativeButton("bereits alarmiert", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }

            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        saveUnfall();
    }

    private void loadUnfall() {
        unfall = new Select().from(Unfall.class).where("unfallId == 1").orderBy("id DESC").executeSingle();
    }

    @Override
    public void onResume() {
        super.onResume();
       // loadUnfall();
        /*if (unfall != null) {
            verletzeJa.setChecked(unfall.getVerletzte());
            verletzteNein.setChecked(!unfall.getVerletzte());

            sachschadenJa.setChecked(unfall.getSachschaden_dritte_fahrzeug());
            sachschadenNein.setChecked(!unfall.getSachschaden_dritte_fahrzeug());
            gegenstaendeJa.setChecked(unfall.getGegenstaende());
            gegenstaendeNein.setChecked(!unfall.getGegenstaende());
        }*/
    }

    @Override
    public void onStop() {
        super.onStop();
        saveUnfall();
    }

    private void saveUnfall() {
        loadUnfall();
        if(unfall == null) {
            unfall = new Unfall();
        }
        unfall.setVerletzte(verletzeJa.isChecked());
        unfall.setSachschaden_dritte_fahrzeug(sachschadenJa.isChecked());
        unfall.setGegenstaende(gegenstaendeJa.isChecked());
        unfall.save();
    }



}
