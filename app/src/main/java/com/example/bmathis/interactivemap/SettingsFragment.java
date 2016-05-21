//File name: MapsActivity.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: This activity contains the widgets and logic of the settings page. Users
//                  can specify what types of events they want to see and what range of events are
//                  shown. Users may also access the tutorial page from this screen.
//Last Edited: 05/08/2016

package com.example.bmathis.interactivemap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

import java.io.DataOutputStream;


public class SettingsFragment extends android.support.v4.app.Fragment implements View.OnClickListener
{
    View view;
    MapsActivity mapsActivity;
    FeedFragment feedFragment;
    FragmentTransaction transaction;
    SupportMapFragment mapFragment;
    TextView returnText;
    TextView aboutText;
    Button saveButton;
    boolean eventBoolean;
    CheckBox alumniCheckBox;
    CheckBox athleticCheckBox;
    CheckBox liberalArtsCheckBox;
    CheckBox facultyCheckBox;
    CheckBox falconCenterCheckBox;
    CheckBox graduateStudiesCheckBox;
    CheckBox businessCheckBox;
    CheckBox educationCheckBox;
    CheckBox nursingCheckBox;
    CheckBox fineArtsCheckBox;
    CheckBox registrarCheckBox;
    CheckBox scitechCheckBox;
    CheckBox specialEventsCheckBox;
    CheckBox studentLifeCheckBox;
    Spinner spinner;
    ScrollView mScrollView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        // get the widget items from settings_layout.xml
        returnText = (TextView)view.findViewById(R.id.settingsReturn);
        aboutText = (TextView)view.findViewById(R.id.aboutText);
        saveButton  = (Button)view.findViewById(R.id.saveSettingsButton);
        alumniCheckBox = (CheckBox)view.findViewById(R.id.alumniCheckBox);;
        athleticCheckBox = (CheckBox)view.findViewById(R.id.athleticsCheckBox);
        liberalArtsCheckBox = (CheckBox)view.findViewById(R.id.liberalArtsCheckBox);
        facultyCheckBox = (CheckBox)view.findViewById(R.id.facultyCheckBox);
        falconCenterCheckBox = (CheckBox)view.findViewById(R.id.falconCenterCheckBox);
        graduateStudiesCheckBox = (CheckBox)view.findViewById(R.id.graduateStudiesCheckBox);
        businessCheckBox = (CheckBox)view.findViewById(R.id.athleticsCheckBox);
        educationCheckBox = (CheckBox)view.findViewById(R.id.educationCheckBox);
        nursingCheckBox = (CheckBox)view.findViewById(R.id.nursingCheckBox);
        fineArtsCheckBox = (CheckBox)view.findViewById(R.id.fineArtsCheckBox);
        registrarCheckBox = (CheckBox)view.findViewById(R.id.registrarCheckBox);
        scitechCheckBox = (CheckBox)view.findViewById(R.id.scitechCheckBox);
        specialEventsCheckBox = (CheckBox)view.findViewById(R.id.specialEventsCheckBox);
        studentLifeCheckBox = (CheckBox)view.findViewById(R.id.studentLifeCheckBox);
        spinner = (Spinner)mapsActivity.findViewById(R.id.range);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mapsActivity,                      // Create an ArrayAdapter using the string array and a default spinner layout
                R.array.Days, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        eventBoolean = mapsActivity.getEventBoolean();
        mScrollView = (ScrollView)view.findViewById(R.id.settingScrollView);
        mScrollView.post(new Runnable()
        {
            public void run()
            {
                mScrollView.scrollTo(0, 0);
            }
        });
        returnText.setOnClickListener(this);
        aboutText.setOnClickListener(this);
        saveButton.setOnClickListener(this);
    }
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(
                R.layout.settings_layout, container, false);
        return view;
    }
    //==================================================================================================
    public void setFields(String name,String tempInfo,String[] degreeFocus, String[] departments,
                          String[] tempEvents, String hours, SupportMapFragment map,MapsActivity activity,
                          FeedFragment f)
    {
        mapFragment = map;
        mapsActivity = activity;
        feedFragment = f;
        // buildingName = name;
        //degreeFocusArray = degreeFocus;
        //departmentArray = departments;
        //buildingHours = hours;
        //eventsArray = tempEvents;
        //information = tempInfo;
    }
    //==================================================================================================
    public void onClick(View view)
    {
        if (view.getId() == R.id.settingsReturn) // return back to last fragment
        {
            // update the flags in the feedFragment so we know what to show and not show.
            android.support.v4.app.FragmentManager.BackStackEntry entry;

            mapsActivity.menuItem.setVisible(true);
            mapsActivity.getSupportFragmentManager().popBackStackImmediate(); // now it will go back to the
                                                                              // fragment that called the settings

            if(!eventBoolean)
            {
                mapsActivity.mapButton.setVisibility(View.VISIBLE);
                mapsActivity.feedButton.setVisibility(View.VISIBLE);
            }
        }
        else if(view.getId() == R.id.aboutText)
            startActivity(new Intent(mapsActivity, TutorialActivity.class));
        else if(view.getId() == R.id.saveSettingsButton) {
            // if the save button is clicked, update the settings in the feed fragment
            feedFragment.updateSettings(alumniCheckBox.isChecked(),
                    athleticCheckBox.isChecked(),
                    liberalArtsCheckBox.isChecked(),
                    facultyCheckBox.isChecked(),
                    falconCenterCheckBox.isChecked(),
                    graduateStudiesCheckBox.isChecked(),
                    businessCheckBox.isChecked(),
                    educationCheckBox.isChecked(),
                    nursingCheckBox.isChecked(),
                    fineArtsCheckBox.isChecked(),
                    registrarCheckBox.isChecked(),
                    scitechCheckBox.isChecked(),
                    specialEventsCheckBox.isChecked(),
                    studentLifeCheckBox.isChecked(),
                    spinner.getSelectedItemPosition() + 1);
            // since the order is 0,1,2,3,4,5 for 1,2,3,4,5,6 months, just pass the index + 1
            // for number of months.

            // show a dialog
            Toast.makeText(mapsActivity, "Settings have been saved", Toast.LENGTH_SHORT).show();
        }
    }
}