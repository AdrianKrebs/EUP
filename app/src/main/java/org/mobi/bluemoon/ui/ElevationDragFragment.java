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

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageButton;


import org.mobi.bluemoon.R;

import butterknife.Bind;

public class ElevationDragFragment extends Fragment {


    protected ImageButton rotation_button;

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

        final DragFrameLayout dragLayout = ((DragFrameLayout) rootView.findViewById(R.id.main_layout));

        rotation_button = (ImageButton) rootView.findViewById(R.id.rotation_button);
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

        return rootView;
    }


}