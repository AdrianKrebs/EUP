package org.mobi.bluemoon.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.mobi.bluemoon.R;
import org.mobi.bluemoon.core.News;

import butterknife.Bind;

import static org.mobi.bluemoon.core.Constants.Extra.NEWS_ITEM;

public class ProfileActivity extends BootstrapActivity {


    @Bind(R.id.name) protected EditText name;
    @Bind(R.id.adresse) protected EditText adresse;
    @Bind(R.id.email) protected  EditText email;
    @Bind(R.id.marke) protected EditText marke;

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

}
