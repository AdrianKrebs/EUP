package org.mobi.bluemoon.ui.view.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import org.mobi.bluemoon.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class FinishFragment extends Fragment {

    DrawableView drawableView;
    DrawableViewConfig config;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.finish, container, false);

        Button sendButton = (Button) view.findViewById(R.id.sendEmail);
        verifyStoragePermissions(this);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PdfReader reader = null;
                try {
                    reader = new PdfReader(getResources().openRawResource(R.raw.formular));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                AcroFields fields = reader.getAcroFields();

                Set<String> fldNames = fields.getFields().keySet();

                for (String fldName : fldNames) {
                    System.out.println(fldName + ": " + fields.getField(fldName));
                }
                File file = new File(Environment.getExternalStorageDirectory() + File.separator + "test.pdf");
                try {
                    OutputStream output = new FileOutputStream(file);

                    PdfStamper stamper = new PdfStamper(reader, output);
                    AcroFields acroFields = stamper.getAcroFields();

                    acroFields.setField("Datum des Unfalls", new Date().toString());
                    acroFields.setField("Zeit", String.valueOf(new Date().getTime()));
                    stamper.setFormFlattening(true);
                    stamper.close();
                    emailNote(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


        return view;
    }


    public static void verifyStoragePermissions(Fragment fragment) {
        int permission = ActivityCompat.checkSelfPermission(fragment.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    fragment.getActivity(),
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    private void viewPdf() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // intent.setDataAndType(Uri.fromFile(myFile), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }


    private void emailNote(File pdfFile) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_SUBJECT, "Unfall_Protocol");
        email.putExtra(Intent.EXTRA_TEXT, "Unfall_Protocol");
        Uri uri = Uri.parse(pdfFile.getAbsolutePath());
        email.putExtra(Intent.EXTRA_STREAM, uri);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"naresharjun@gmail.com"});
        email.setType("message/rfc822");
        startActivity(email);
    }

}
