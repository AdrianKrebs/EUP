package org.mobi.bluemoon.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.viewpagerindicator.TitlePageIndicator;

import org.mobi.bluemoon.R;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Adrian on 5/12/2016.
 */
public class ZeugenFragment extends Fragment {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<ZeugenItem> listItems = new ArrayList<ZeugenItem>();


    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ZeugenAdapter adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter = 0;

    protected Button addBtn;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.zeugen, container, false);
        ListView list = (ListView) view.findViewById(R.id.zeugenListt);
        ImageButton addBtn = (ImageButton) view.findViewById(R.id.addBtn);
        final View layout = inflater.inflate(R.layout.zeugen_item, null, false);

        final EditText adresse = (EditText) layout.findViewById(R.id.adresseZeuge);
        final EditText name = (EditText) layout.findViewById(R.id.nameZeuge);


        adapter = new ZeugenAdapter(getActivity(),
                listItems);
        list.setAdapter(adapter);

        final AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        build.setMessage("Kontaktdaten erfassen");
        build.setTitle("Zeugen");

        build.setView(layout);
        //  final EditText usernameInput=(EditText)layout.findViewById(R.id.dialogusername);
        // final EditText passwordInput=(EditText)layout.findViewById(R.id.dialogpassword);
        build.setPositiveButton("Hinzufügen", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                //OR
                String nameString = name.getText().toString();
                String adressString = adresse.getText().toString();
                listItems.add(new ZeugenItem(nameString, adressString));
                adapter.notifyDataSetChanged();

            }
        });

        build.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // what ever you want to do with No option.
            }
        });
        final AlertDialog alert = build.create();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();

            }
        });


        return view;


    }
}
