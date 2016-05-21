//File name: EventMakerActivity.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: Handles displaying fragment to submit an event and uses activity_event_maker.xml
//Last Edited: 05/06/2016

package com.example.bmathis.interactivemap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

public class EventMakerActivity extends Fragment implements View.OnClickListener
{
    View view;
    MapsActivity mapsActivity;
    Spinner startHours, startMinutes, endHours, endMinutes, startMonth,
            startDay, startYear, endMonth, endDay, endYear, location, startTimeDay, endTimeDay;
    int closestLocation;
    EditText eventName, description, name, fees, phoneNumber, email;
    CheckBox[] attend;
    Button okButton, cancelButton;
    ScrollView mScrollView;

    //==================================================================================================
//Handles creating the view and resetting fields for EventMakerActivity
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mapsActivity.eventBoolean = true;
        mScrollView = (ScrollView)view.findViewById(R.id.activityScrollView);
        mScrollView.post(new Runnable()
        {
            public void run()
            {
                mScrollView.scrollTo(0, 0);
            }
        });
        startMonth = (Spinner) view.findViewById(R.id.startMonthSpinner);

        ArrayAdapter<CharSequence> calendarAdapter = ArrayAdapter.createFromResource(mapsActivity,  // Create an ArrayAdapter using the string array and a default spinner layout
                R.array.CalendarMonths, android.R.layout.simple_spinner_item);
        calendarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startMonth.setAdapter(calendarAdapter);
        startMonth.setSelection(0);
        startDay = (Spinner) view.findViewById(R.id.startDaySpinner);
        ArrayAdapter<CharSequence> calendarDayAdapter = ArrayAdapter.createFromResource
                (mapsActivity,R.array.CalendarDays, android.R.layout.simple_spinner_item);          // Create an ArrayAdapter using the string array and a default spinner layout
        calendarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startDay.setAdapter(calendarDayAdapter);
        startDay.setSelection(0);
        startYear = (Spinner) view.findViewById(R.id.startYearSpinner);
        ArrayAdapter<CharSequence> calendarYearAdapter = ArrayAdapter.createFromResource
                (mapsActivity,R.array.CalendarYears, android.R.layout.simple_spinner_item);         // Create an ArrayAdapter using the string array and a default spinner layout
        calendarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startYear.setAdapter(calendarYearAdapter);
        startYear.setSelection(0);
        startHours = (Spinner) view.findViewById(R.id.from_time_spinner);
        ArrayAdapter<CharSequence> hoursAdapter = ArrayAdapter.createFromResource(mapsActivity,     // Create an ArrayAdapter using the string array and a default spinner layout
                R.array.Hours, android.R.layout.simple_spinner_item);
        hoursAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startHours.setAdapter(hoursAdapter);                                                        // Specify the layout to use when the list of choices appears
        startHours.setSelection(0);
        startMinutes = (Spinner) view.findViewById(R.id.to_time_spinner);
        ArrayAdapter<CharSequence> minutesAdapter = ArrayAdapter.createFromResource(mapsActivity,   // Create an ArrayAdapter using the string array and a default spinner layout
                R.array.Minutes, android.R.layout.simple_spinner_item);
        minutesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startMinutes.setAdapter(minutesAdapter);
        startMinutes.setSelection(0);
        startTimeDay = (Spinner) view.findViewById(R.id.startTimeDay);
        ArrayAdapter<CharSequence> timeDayAdapter = ArrayAdapter.createFromResource(mapsActivity,   // Create an ArrayAdapter using the string array and a default spinner layout
                R.array.Time, android.R.layout.simple_spinner_item);
        timeDayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startTimeDay.setAdapter(timeDayAdapter);
        startTimeDay.setSelection(0);
        endMonth = (Spinner) view.findViewById(R.id.endMonthSpinner);
        endMonth.setAdapter(calendarAdapter);
        endMonth.setSelection(0);
        endDay = (Spinner) view.findViewById(R.id.endDaySpinner);
        endDay.setAdapter(calendarDayAdapter);
        endDay.setSelection(0);
        endYear = (Spinner) view.findViewById(R.id.endYearSpinner);
        endYear.setAdapter(calendarYearAdapter);
        endYear.setSelection(0);
        endHours = (Spinner) view.findViewById(R.id.endHourSpinner);
        endHours.setAdapter(hoursAdapter);                                                          // Specify the layout to use when the list of choices appears
        endHours.setSelection(0);
        endMinutes = (Spinner) view.findViewById(R.id.endMinuteSpinner);
        endMinutes.setAdapter(minutesAdapter);
        endMinutes.setSelection(0);
        endTimeDay = (Spinner) view.findViewById(R.id.endTimeDay);
        endTimeDay.setAdapter(timeDayAdapter);
        endTimeDay.setSelection(0);
        location = (Spinner) view.findViewById(R.id.eventLocationSpinner);
        ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(mapsActivity,  // Create an ArrayAdapter using the string array and a default spinner layout
                R.array.locations, android.R.layout.simple_spinner_item);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(locationAdapter);
        location.setSelection(closestLocation);
        eventName = (EditText) view.findViewById(R.id.EventNameET);
        eventName.setText("");
        description = (EditText) view.findViewById(R.id.EventDescET);
        description.setText("");
        name = (EditText) view.findViewById(R.id.nameEditText);
        name.setText("");
        fees = (EditText) view.findViewById(R.id.feesTextView);
        phoneNumber = (EditText) view.findViewById(R.id.phoneEditText);
        phoneNumber.setText("");
        email = (EditText) view.findViewById(R.id.emailEditText);
        email.setText("");
        attend = new CheckBox[5];
        attend[0] = (CheckBox) view.findViewById(R.id.studentCheckBox);
        attend[1] = (CheckBox) view.findViewById(R.id.facultyCheckBox);
        attend[2] = (CheckBox) view.findViewById(R.id.staffCheckBox);
        attend[3] = (CheckBox) view.findViewById(R.id.alumniCheckBox);
        attend[4] = (CheckBox) view.findViewById(R.id.communityCheckBox);
        okButton = (Button) view.findViewById(R.id.okButton);
        cancelButton = (Button) view.findViewById(R.id.cancelButton);
        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        setPresentationData(); // this method is only used for the final presentation to cut down on time
    }
    //==================================================================================================
//Prepares the view for EventMakerActivity
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.activity_event_maker, container, false);                   // Inflate the layout for this fragment
        return view;
    }

    //==================================================================================================
//Prepares and sends information in fields to server
    void sendEvent() {
        String fullMessage;
        String currentField;
        currentField = eventName.getText().toString().trim();
        if (!currentField.equals(""))
        {
            fullMessage = currentField + ">>>";
            fullMessage = fullMessage + startMonth.getSelectedItem().toString() + " " +
                    startDay.getSelectedItem().toString() + " " + startYear.getSelectedItem()
                    .toString() + ">>>";
            fullMessage = fullMessage + startHours.getSelectedItem().toString() + ":" +
                    startMinutes.getSelectedItem().toString() + startTimeDay.getSelectedItem()
                    .toString() + ">>>";
            fullMessage = fullMessage + endMonth.getSelectedItem().toString() + " " +
                    endDay.getSelectedItem().toString() + " " + endYear.getSelectedItem()
                    .toString() + ">>>";
            fullMessage = fullMessage + endHours.getSelectedItem().toString() + ":" +
                    endMinutes.getSelectedItem().toString() + endTimeDay.getSelectedItem()
                    .toString() + ">>>";
            for (int i = 0; i < 5; i++)
            {
                if (attend[i].isChecked())
                    fullMessage = fullMessage + attend[i].getText().toString() + ",";
            }
            if(fullMessage.contains(","))
                fullMessage.substring(0,fullMessage.lastIndexOf(","));
            fullMessage = fullMessage + ">>>";
            fullMessage = fullMessage + location.getSelectedItem().toString() + ">>>";
            currentField = fees.getText().toString().trim();
            if (currentField.equals(""))
                currentField = "0";
            fullMessage = fullMessage + currentField + ">>>";
            currentField = description.getText().toString().trim();
            if (!currentField.equals(""))
            {
                fullMessage = fullMessage + currentField + ">>>";
                currentField = name.getText().toString().trim();
                if (!currentField.equals(""))
                {
                    fullMessage = fullMessage + currentField + ">>>";
                    currentField = phoneNumber.getText().toString().trim();
                    if (!currentField.equals(""))
                    {
                        fullMessage = fullMessage + currentField + ">>>";
                        currentField = email.getText().toString().trim();
                        if (!currentField.equals(""))
                        {
                            fullMessage = fullMessage + currentField + ">>>";
                            mapsActivity.sendEmailEvent(fullMessage);                               // passes the information back to the maps to pass to the thread
                            Toast.makeText(mapsActivity, "Event has been sent for approval",
                                    Toast.LENGTH_SHORT).show();
                            FragmentTransaction transaction = mapsActivity.
                                    getSupportFragmentManager().beginTransaction();
                            transaction.setCustomAnimations(R.anim.slide_up_enter, R.anim.slide_up_exit);
                            transaction.replace(R.id.mapFrame, mapsActivity.mapFragment);
                            mapsActivity.mapButton.setVisibility(View.VISIBLE);
                            mapsActivity.feedButton.setVisibility(View.VISIBLE);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else
                            Toast.makeText(mapsActivity, "Email field must be filled",
                                    Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(mapsActivity, "Phone field must be filled",
                                Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(mapsActivity, "Name field must be filled",
                            Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(mapsActivity, "Description field must be filled",
                        Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(mapsActivity, "Event name field must be filled",
                    Toast.LENGTH_SHORT).show();
    }
    //==================================================================================================
//Handles items in the EventMakerActivity being clicked
    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.okButton)
            sendEvent();
        else
        {
            FragmentTransaction transaction = mapsActivity.getSupportFragmentManager()
                    .beginTransaction();
            transaction.setCustomAnimations(R.anim.slide_up_enter, R.anim.slide_up_exit);
            transaction.replace(R.id.mapFrame, mapsActivity.mapFragment);
            mapsActivity.mapButton.setVisibility(View.VISIBLE);
            mapsActivity.feedButton.setVisibility(View.VISIBLE);
            mapsActivity.eventBoolean = false;
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
    //==================================================================================================
//Handles items in the EventMakerActivity being clicked
    public void setFields(MapsActivity ma)
    {
        mapsActivity = ma;
        closestLocation = 0;
    }
    //==================================================================================================
    private void setPresentationData() { // this method will auto-fill some fields so that we don't have
                                         // to actually fill them out for the presentation.
        eventName.setText("Final Presentation");
        location.setSelection(5);
        startMonth.setSelection(4);
        startDay.setSelection(8);
        startTimeDay.setSelection(1);
        endMonth.setSelection(4);
        endDay.setSelection(8);
        endHours.setSelection(2);
        endTimeDay.setSelection(1);
        attend[0].setChecked(true);
        attend[1].setChecked(true);
        description.setText("The final presentation for the joint classes, Software Engineering " +
                            "and project management will be held in the Engineering Tech building " +
                            "in room 208. All project participants such as stakeholders and sponsors " +
                            "are encouraged to attend.");
        name.setText("Benjamin Wilfong");
        phoneNumber.setText("123-456-7890");
        email.setText("ultimate_brony@mylittleponyextreme.com");
    }
}