package org.mobi.bluemoon.ui.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.activeandroid.query.Select;

import org.mobi.bluemoon.R;
import org.mobi.bluemoon.db.Fahrzeug;
import org.mobi.bluemoon.db.Versicherungsunternehmen;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class VerischerungsunternehmenFragment extends Fragment {

    DrawableView drawableView;
    DrawableViewConfig config;

    Versicherungsunternehmen verischerungA;
    Versicherungsunternehmen verischerungB;

    @Bind(R.id.vu_nameA)
    protected EditText vu_nameA;
    @Bind(R.id.vertragsnummer_a)
    protected EditText vertragsnummer_a;
    @Bind(R.id.telefon_oder_emailA)
    protected EditText telefon_oder_emailA;
    @Bind(R.id.vu_nameB)
    protected EditText vu_nameB;
    @Bind(R.id.vertragsnummerB)
    protected EditText vertragsnummerB;
    @Bind(R.id.telefon_Oder_EmailB)
    protected EditText telefon_Oder_EmailB;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.verischerungsunternehmen, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        saveVerischerungsUnternehmen();
    }

    private void loadVersicherung() {
        verischerungA = new Select().from(Versicherungsunternehmen.class).where("versicherungsunternehmenId == 1").executeSingle();
        verischerungB = new Select().from(Versicherungsunternehmen.class).where("versicherungsunternehmenId == 2").executeSingle();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadVersicherung();
        if (verischerungA != null) {
            vu_nameA.setText(verischerungA.getName());
            vertragsnummer_a.setText(verischerungA.getVertragsnummer());
            telefon_oder_emailA.setText(verischerungA.getEmail());
        }
        if(verischerungB != null) {
            vu_nameB.setText(verischerungB.getName());
            vertragsnummerB.setText(verischerungB.getVertragsnummer());
            telefon_Oder_EmailB.setText(verischerungB.getEmail());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        saveVerischerungsUnternehmen();
    }

    private void saveVerischerungsUnternehmen() {
        verischerungA = new Versicherungsunternehmen();
        verischerungA.setVersicherungsunternehmenId(1);
        verischerungA.setName(vu_nameA.getText().toString());
        verischerungA.setVertragsnummer(vertragsnummer_a.getText().toString());
        verischerungA.setEmail(telefon_oder_emailA.getText().toString());
        verischerungA.save();
        verischerungB = new Versicherungsunternehmen();
        verischerungB.setVersicherungsunternehmenId(2);
        verischerungB.setName(vu_nameB.getText().toString());
        verischerungB.setVertragsnummer(vertragsnummerB.getText().toString());
        verischerungB.setEmail(telefon_Oder_EmailB.getText().toString());
        verischerungB.save();
    }


}
