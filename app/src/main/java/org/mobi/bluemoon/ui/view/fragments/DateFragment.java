package org.mobi.bluemoon.ui.view.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.activeandroid.query.Select;

import org.mobi.bluemoon.R;
import org.mobi.bluemoon.db.Fahrer;
import org.mobi.bluemoon.db.Unfall;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;

public class DateFragment extends Fragment {


    protected EditText dateText;
    protected EditText timeText;

    Unfall unfall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = View.inflate(getActivity(), R.layout.date_page, null);

        dateText = (EditText) view.findViewById(R.id.accidentDate);
        timeText = (EditText) view.findViewById(R.id.accidentTime);

        dateText.setInputType(InputType.TYPE_NULL);
        dateText.requestFocus();

        timeText.setInputType(InputType.TYPE_NULL);
        timeText.requestFocus();


        view.findViewById(R.id.accidentDate).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        view.findViewById(R.id.accidentTime).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeText.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });


        return view;
    }

    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };



    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateText.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onPause() {
        super.onPause();
        saveUnfall();
    }

    private void loadUnfall() {
        unfall = new Select().from(Unfall.class).orderBy("id DESC").executeSingle();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadUnfall();
        if (unfall != null) {
            dateText.setText(unfall.getDatum());
            timeText.setText(unfall.getZeit());
                   }
    }

    @Override
    public void onStop() {
        super.onStop();
        saveUnfall();
    }

    private void saveUnfall() {
        unfall = new Unfall();
        unfall.setDatum(dateText.getText().toString());
        unfall.setZeit(timeText.getText().toString());
        unfall.save();
    }


}



