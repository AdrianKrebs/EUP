package org.mobi.bluemoon.ui;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import me.panavtec.drawableview.*;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.mobi.bluemoon.R;

import java.util.Random;

public class SignatureFragment extends Fragment {

    DrawableView drawableView;
    DrawableViewConfig config;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // TODO: Put signature and sketch in separeted activity
        // TODO: rotate second car


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.signature, container, false);


        drawableView = (DrawableView) view.findViewById(R.id.paintView);

        Button strokeWidthMinusButton = (Button) view.findViewById(R.id.strokeWidthMinusButton);
        Button strokeWidthPlusButton = (Button) view.findViewById(R.id.strokeWidthPlusButton);
        Button changeColorButton = (Button) view.findViewById(R.id.changeColorButton);
        Button undoButton = (Button) view.findViewById(R.id.undoButton);


        config = new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        config.setShowCanvasBounds(true); // If the view is bigger than canvas, with this the user will see the bounds (Recommended)
        config.setStrokeWidth(20.0f);
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(1080);
        config.setCanvasWidth(1920);
        drawableView.setConfig(config);
        strokeWidthPlusButton.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth() + 10);
            }
        });
        strokeWidthMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth() - 10);
            }
        });
        changeColorButton.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {
                Random random = new Random();
                config.setStrokeColor(
                        Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            }
        });
        undoButton.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {
                drawableView.undo();
            }
        });


        return view;
    }


}
