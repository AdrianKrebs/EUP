package org.mobi.bluemoon.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.EditText;

import com.activeandroid.query.Select;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import org.mobi.bluemoon.R;
import org.mobi.bluemoon.db.Fahrer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Set;

import butterknife.Bind;

public class ProfileActivity extends BootstrapActivity {


    @Bind(R.id.name)
    protected EditText name;
    @Bind(R.id.adresse)
    protected EditText adresse;
    @Bind(R.id.email)
    protected EditText email;


    @Bind(R.id.nummer)
    protected EditText nummer;

    @Bind(R.id.klasse)
    protected EditText klasse;

    @Bind(R.id.geburtsdatum)
    protected EditText geburtsdatum;

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
        nummer.setHint("0087632482384");
        klasse.setHint("B");
        geburtsdatum.setHint("11.11.1975");

        PdfReader reader = null;
        try {
            reader = new PdfReader(getResources().openRawResource(R.raw.formular));
        } catch (IOException e) {
            e.printStackTrace();
        }

        AcroFields fields = reader.getAcroFields();

        Set<String> fldNames = fields.getFields().keySet();

        for (String fldName : fldNames) {
            System.out.println( fldName + ": " + fields.getField( fldName ) );
        }
        File pdfFile = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), "pdfdemo");
        if (!pdfFile.exists()) {
            pdfFile.mkdir();
            Log.i("Success", "Pdf Directory created");
        }
        try {
            OutputStream output = new FileOutputStream(pdfFile);

            PdfStamper stamper = new PdfStamper(reader, output);
            AcroFields acroFields = stamper.getAcroFields();
            loadFahrer();
            if(fahrerA != null) {
                acroFields.setField("NAME", fahrerA.getName());
                acroFields.setField("address", fahrerA.getStrasse());
                acroFields.setField("Ort", fahrerA.getLand());
            }
            acroFields.setField("Datum des Unfalls", new Date().toString());
            acroFields.setField("Zeit",String.valueOf(new Date().getTime()));
            stamper.setFormFlattening(true);
            stamper.close();
            emailNote(pdfFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void viewPdf(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
       // intent.setDataAndType(Uri.fromFile(myFile), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }


    private void emailNote(File pdfFile)
    {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_SUBJECT,"Unfall_Protocol");
        email.putExtra(Intent.EXTRA_TEXT, "Unfall_Protocol");
        Uri uri = Uri.parse(pdfFile.getAbsolutePath());
        email.putExtra(Intent.EXTRA_STREAM, uri);
        email.putExtra(Intent.EXTRA_EMAIL,new String[] { "naresharjun@gmail.com" });
        email.setType("message/rfc822");
        startActivity(email);
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

            nummer.setText(fahrerA.getFuehrerscheinnummer());
            geburtsdatum.setText(fahrerA.getGeburtsdatum());
            klasse.setText(fahrerA.getKlasse());
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
        fahrerA.setEmail(email.getText().toString());

        fahrerA.setKlasse(klasse.getText().toString());
        fahrerA.setGeburtsdatum(geburtsdatum.getText().toString());
        fahrerA.setFuehrerscheinnummer(nummer.getText().toString());
        fahrerA.save();
    }

}
