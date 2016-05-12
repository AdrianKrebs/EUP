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

import org.mobi.bluemoon.BootstrapApplication;
import org.mobi.bluemoon.R;

public class DetailsFragment extends Fragment {

    protected CheckBox repeatChkBx;


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

        //TODO Verletzungen-DB
        repeatChkBx = ( CheckBox ) view.findViewById( R.id.checkBox );

        CheckBox repeatChkBx = ( CheckBox ) view.findViewById( R.id.checkBox );
        repeatChkBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
                            .setNegativeButton("bereit alarmiert", new DialogInterface.OnClickListener() {
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


}
