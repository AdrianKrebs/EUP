package org.mobi.bluemoon.ui.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.activeandroid.query.Select;

import org.mobi.bluemoon.R;
import org.mobi.bluemoon.db.Fahrer;
import org.mobi.bluemoon.db.Fahrzeug;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class FahrzeugFragment extends Fragment {

    DrawableView drawableView;
    DrawableViewConfig config;

    Fahrzeug fahrzeugA;
    Fahrzeug fahrzeugB;

    @Bind(R.id.marke_fahrzeug_a)
    protected EditText marke_fahrzeug_a;
    @Bind(R.id.marke_fahrzeug_b)
    protected EditText marke_fahrzeug_b;
    @Bind(R.id.kenn_fahrzeug_a)
    protected EditText kenn_fahrzeug_a;
    @Bind(R.id.kenn_fahrzeug_b)
    protected EditText kenn_fahrzeug_b;
    @Bind(R.id.land_fahrzeug_a)
    protected EditText land_fahrzeug_a;
    @Bind(R.id.land_fahrzeug_b)
    protected EditText land_fahrzeug_b;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fahrzeug, container, false);
        ButterKnife.bind(this, view);
       return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        saveFahrzeug();
    }

    private void loadFahrzeug() {
        fahrzeugA = Fahrzeug.load(Fahrzeug.class,1);
        fahrzeugB = Fahrzeug.load(Fahrzeug.class,2);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadFahrzeug();
        if (fahrzeugA != null) {
            marke_fahrzeug_a.setText(fahrzeugA.getMarke());
            kenn_fahrzeug_a.setText(fahrzeugA.getKennzeichen());
            land_fahrzeug_a.setText(fahrzeugA.getZulassungLand());
        }
        if(fahrzeugB != null) {
            marke_fahrzeug_b.setText(fahrzeugB.getMarke());
            kenn_fahrzeug_b.setText(fahrzeugB.getKennzeichen());
            land_fahrzeug_b.setText(fahrzeugB.getZulassungLand());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        saveFahrzeug();
    }

    private void saveFahrzeug() {
        fahrzeugA = new Fahrzeug();
        fahrzeugA.setId(Long.valueOf(1));
        fahrzeugA.setZulassungLand(land_fahrzeug_a.getText().toString());
        fahrzeugA.setKennzeichen(kenn_fahrzeug_a.getText().toString());
        fahrzeugA.setMarke(marke_fahrzeug_a.getText().toString());
        fahrzeugA.save();
        fahrzeugB = new Fahrzeug();
        fahrzeugB.setId(Long.valueOf(2));
        fahrzeugB.setZulassungLand(land_fahrzeug_b.getText().toString());
        fahrzeugB.setKennzeichen(kenn_fahrzeug_b.getText().toString());
        fahrzeugB.setMarke(marke_fahrzeug_b.getText().toString());
        fahrzeugB.save();
    }


}
