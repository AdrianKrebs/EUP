package org.mobi.bluemoon.ui.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import org.mobi.bluemoon.R;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class FahrzeugFragment extends Fragment {

    DrawableView drawableView;
    DrawableViewConfig config;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fahrzeug, container, false);

        EditText markeA = ( EditText ) view.findViewById( R.id.marke_fahrzeug_a );
        EditText markeB = ( EditText ) view.findViewById( R.id.marke_fahrzeug_b );
        EditText kennzeichenA = ( EditText ) view.findViewById( R.id.kenn_fahrzeug_a );
        EditText kennzeichenB = ( EditText ) view.findViewById( R.id.kenn_fahrzeug_b );

        //TODO your action markeA.getText()

        return view;
    }


}
