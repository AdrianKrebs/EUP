/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mobi.bluemoon.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import org.mobi.bluemoon.R;

import java.io.ByteArrayOutputStream;

import butterknife.Bind;

public class ElevationDragFragment extends Fragment {


    private static final int REQUEST_ID = 12345;
    protected ImageButton rotation_button;
    ImageButton add_button;
    DragFrameLayout dragLayout;

    int numClicks = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sketch, container, false);

        /* Find the {@link View} to apply z-translation to. */
        final View floatingShape = rootView.findViewById(R.id.circle);
        final View car2 = rootView.findViewById(R.id.car2);

        dragLayout = ((DragFrameLayout) rootView.findViewById(R.id.main_layout));

        rotation_button = (ImageButton) rootView.findViewById(R.id.rotation_button);
        add_button = (ImageButton) rootView.findViewById(R.id.addSymbolBtn);
        rotation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dragLayout.getSelectedView().setPivotX(dragLayout.getSelectedView().getWidth() / 2);
                dragLayout.getSelectedView().setPivotY(dragLayout.getSelectedView().getHeight() / 2);
                dragLayout.getSelectedView().setRotation(30 * numClicks);
                numClicks++;
            }
        });
        dragLayout.setDragFrameController(new DragFrameLayout.DragFrameLayoutController() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onDragDrop(boolean captured) {
                floatingShape.animate()
                        .translationZ(captured ? 50 : 0)
                        .setDuration(100);
            }
        });

        dragLayout.addDragView(floatingShape);
        dragLayout.addDragView(car2);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SymbolsActivity.class);

                // request id is needed here
                startActivityForResult(intent, REQUEST_ID);


            }
        });

        return rootView;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ID) {
            if (resultCode == Activity.RESULT_OK) {
                AppCompatImageView imageView = new AppCompatImageView(getContext());
              //  int positon = Integer.parseInt(data.getExtras().get("data").toString());
            //    if (positon == 1) {

                    imageView.setImageResource(R.drawable.vorfahrt);

                    imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));

//                LayoutInflater vi = (LayoutInflater) getContext().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View root = vi.inflate(R.layout.sketch, null);
                dragLayout.addView(imageView);
                imageView.setZ(10f);
                dragLayout.addDragView(imageView);
                imageView.setVisibility(View.VISIBLE);



            }
        }
    }


}