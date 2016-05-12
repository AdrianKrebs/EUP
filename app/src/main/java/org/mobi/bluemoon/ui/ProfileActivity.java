package org.mobi.bluemoon.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.activeandroid.query.Select;

import org.mobi.bluemoon.R;
import org.mobi.bluemoon.core.News;
import org.mobi.bluemoon.db.Fahrer;

import butterknife.Bind;

import static org.mobi.bluemoon.core.Constants.Extra.NEWS_ITEM;

public class ProfileActivity extends BootstrapActivity {


    @Bind(R.id.name)
    protected EditText name;
    @Bind(R.id.adresse)
    protected EditText adresse;
    @Bind(R.id.email)
    protected EditText email;
    @Bind(R.id.marke)
    protected EditText marke;

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
        Fahrer fahrerA = new Fahrer();
        fahrerA.setName(name.getText().toString());
        fahrerA.setStrasse(adresse.getText().toString());
        fahrerA.setKlasse(marke.getText().toString());
        fahrerA.setEmail(email.getText().toString());
        fahrerA.save();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fahrer fahrerA = new Select().from(Fahrer.class).orderBy("RANDOM()").executeSingle();
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
        Fahrer fahrerA = new Fahrer();
        fahrerA.setName(name.getText().toString());
        fahrerA.setStrasse(adresse.getText().toString());
        fahrerA.setKlasse(marke.getText().toString());
        fahrerA.setEmail(email.getText().toString());
        fahrerA.save();
    }
}
