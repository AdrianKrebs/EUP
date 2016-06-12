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
import android.content.SharedPreferences;
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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.google.android.gms.vision.Frame;

import org.mobi.bluemoon.R;

import java.io.ByteArrayOutputStream;

import butterknife.Bind;

public class SketchFragment extends Fragment {


    private static final int REQUEST_ID = 12345;
    protected ImageButton rotation_button;
    ImageButton add_button;
    DragFrameLayout dragLayout;
    View floatingShape;

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
        floatingShape = rootView.findViewById(R.id.circle);
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


    @Override
    public void onResume() {
        super.onResume();
        // get positions back here

        // TODO define String in constants gloabally
        SharedPreferences sharedPref = getContext().getSharedPreferences("positions",Context.MODE_PRIVATE);

        for (View v : dragLayout.getAllViews()) {
            int x = sharedPref.getInt(v.getId() + "L", 0);
            int y = sharedPref.getInt(v.getId() + "T", 0);


            if (x > 0 && y > 0) {
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(x, y, 0, 0);
                v.setLayoutParams(params);
            }
        }
        //sharedPref.edit().clear().commit();

    }

    @Override
    public void onStop() {
        super.onStop();


    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ID) {
            if (resultCode == Activity.RESULT_OK) {
                AppCompatImageView imageView = new AppCompatImageView(getContext());
                int position = Integer.parseInt(data.getExtras().get("position").toString());
                if (position == 0) {
                    imageView.setImageResource(R.drawable.vorfahrt);
                } else if (position == 1) {
                    imageView.setImageResource(R.drawable.verbot);
                } else if (position == 2) {
                    imageView.setImageResource(R.drawable.pedestrian);
                }else if (position == 3) {
                    imageView.setImageResource(R.drawable.velo);
                }else if (position == 4) {
                    imageView.setImageResource(R.drawable.bike);
                } else {
                    return;
                }


                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                imageView.setLayoutParams(params);
                imageView.setId(View.generateViewId());
                dragLayout.addView(imageView);
                dragLayout.addDragView(imageView);

                final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)imageView.getLayoutParams();
                lpt.setMargins(300,300,0,0);



            }
        }
    }


}