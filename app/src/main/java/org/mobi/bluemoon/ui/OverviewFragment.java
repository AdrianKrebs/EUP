package org.mobi.bluemoon.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.mobi.bluemoon.BootstrapApplication;
import org.mobi.bluemoon.R;
import org.mobi.bluemoon.util.Toaster;

import java.util.ArrayList;

import butterknife.Bind;

import static org.mobi.bluemoon.core.Constants.Extra.NEWS_ITEM;

public class OverviewFragment extends Fragment {

    @Bind(R.id.gridView1) protected GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    ImageAdapter imageAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BootstrapApplication.component().inject(this);
      /*  if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.overview, container, false);
        Bitmap homeIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.follow);
        Bitmap userIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.note);
        Bitmap walletIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.wallet);

        gridArray.add(new Item(homeIcon,"Profil"));
        gridArray.add(new Item(userIcon,"Protokoll"));
        gridArray.add(new Item(walletIcon, "Digital Wallet"));

        gridView = (GridView) view.findViewById(R.id.gridView1);
        imageAdapter = new ImageAdapter(view.getContext(), R.layout.grid_item, gridArray);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toaster.showLong(getActivity(), "test onClickListener");
                // DO something
                if (position == 0) {
                    // open ProfileActivity
                    startActivity(new Intent(getActivity(), ProfileActivity.class));//.putExtra(NEWS_ITEM, news));
                }

            }
        });

        return view;
    }


}
