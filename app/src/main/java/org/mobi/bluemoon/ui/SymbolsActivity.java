package org.mobi.bluemoon.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import com.activeandroid.query.Select;

import org.mobi.bluemoon.BootstrapApplication;
import org.mobi.bluemoon.R;
import org.mobi.bluemoon.db.Fahrer;

import java.util.ArrayList;

import butterknife.Bind;

public class SymbolsActivity extends BootstrapActivity {

    @Bind(R.id.symbolsView) protected GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    ImageAdapter imageAdapter;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.symbols);

       /* if (getIntent() != null && getIntent().getExtras() != null) {
            newsItem = (News) getIntent().getExtras().getSerializable(NEWS_ITEM);
        }*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        BootstrapApplication.component().inject(this);

        Bitmap vorfahrtIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.vorfahrt);
        Bitmap verbotIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.verbot);
        Bitmap pedestrian = BitmapFactory.decodeResource(this.getResources(), R.drawable.pedestrian);


        gridArray.add(new Item(vorfahrtIcon,"Vorfahrt"));
        gridArray.add(new Item(verbotIcon,"Fahrverbot"));
        gridArray.add(new Item(pedestrian,"Fussgänger"));



        imageAdapter = new ImageAdapter(this, R.layout.grid_item, gridArray);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Toaster.showLong(getActivity(), "test onClickListener");
                // DO something

                // should pass the pic to the previous activity
                getIntent().putExtra("position",id);


                setResult(RESULT_OK, getIntent());
//---close the activity---
                finish();

            }
        });

    }

}
