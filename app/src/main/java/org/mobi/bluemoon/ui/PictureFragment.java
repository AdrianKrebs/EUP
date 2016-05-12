package org.mobi.bluemoon.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import org.mobi.bluemoon.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static android.support.v4.content.PermissionChecker.checkSelfPermission;

/**
 * Created by Adrian on 5/12/2016.
 */
public class PictureFragment extends Fragment {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    private static final int MY_REQUEST_CODE = 42;
    private static int counter = 1;
    Button button;
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    ImageAdapter imageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.picture,
                container, false);

        button = (Button) rootView.findViewById(R.id.btnCapture);
        gridView = (GridView) rootView.findViewById(R.id.picView);

        imageAdapter = new ImageAdapter(rootView.getContext(), R.layout.grid_item, gridArray);
        gridView.setAdapter(imageAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!canAccessCamera()) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            MY_REQUEST_CODE);

                }
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,
                        CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);


            }
        });

        return rootView;

    }


    private boolean canAccessCamera() {
        return (hasPermission(Manifest.permission.CAMERA));
    }

    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED == checkSelfPermission(getActivity(), perm));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                // convert byte array to Bitmap

                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
                        byteArray.length);

                gridArray.add(new Item(bitmap,"Unfallbild "+ counter++));


            }
        }
    }
}
