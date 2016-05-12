package org.mobi.bluemoon.ui;

import android.os.Bundle;
import android.widget.EditText;

import com.activeandroid.query.Select;

import org.mobi.bluemoon.R;
import org.mobi.bluemoon.db.Fahrer;

import butterknife.Bind;

public class ProfileActivity extends BootstrapActivity {


    @Bind(R.id.name)
    protected EditText name;
    @Bind(R.id.adresse)
    protected EditText adresse;
    @Bind(R.id.email)
    protected EditText email;
    @Bind(R.id.marke)
    protected EditText marke;

    Fahrer fahrerA;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile);

       /* if (getIntent() != null && getIntent().getExtras() != null) {
            newsItem = (News) getIntent().getExtras().getSerializable(NEWS_ITEM);
        }*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        name.setHint("Hans Muster");
        adresse.setHint("Musterweg 12");
        email.setHint("maxmuster@email.com");
        marke.setHint("Opel");
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveFahrer();
    }

    private void loadFahrer() {
        fahrerA = new Select().from(Fahrer.class).orderBy("id DESC").executeSingle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadFahrer();
        if (fahrerA != null) {
            name.setText(fahrerA.getName());
            adresse.setText(fahrerA.getStrasse());
            email.setText(fahrerA.getEmail());
            marke.setText(fahrerA.getKlasse());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveFahrer();
    }

    private void saveFahrer() {
        fahrerA = new Fahrer();
        fahrerA.setName(name.getText().toString());
        fahrerA.setStrasse(adresse.getText().toString());
        fahrerA.setKlasse(marke.getText().toString());
        fahrerA.setEmail(email.getText().toString());
        fahrerA.save();
    }

}
