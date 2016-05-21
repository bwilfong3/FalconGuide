//File name: FeedFragment.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: This file contains the logic for the event feed. Contained within this
//                  fragment are the data structures for all of the event attributes, as well as
//                  the information from the user settings. This information pertains to the
//                  date range of events to be shown and the categories of events to be shown.
//                  It is also responsible for creating the CustomListAdapter and using it in
//                  for the feed_fragment.xml file.
//Last Edited: 05/08/2016

package com.example.bmathis.interactivemap;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


public class FeedFragment extends ListFragment implements AdapterView.OnItemClickListener{

    ArrayList<String> titleList;
    ArrayList<String> descriptionList;
    ArrayList<Integer> imgIdList;
    ArrayList<String> locationList;
    ArrayList<String> startTimeList;
    ArrayList<String> endTimeList;
    ArrayList<String> categories;
    ArrayList<Date> dates;

    MapsActivity mapsActivity;

    CustomListAdapter adapter;

    // these are flags that determine whether or not a particular category should be shown.
    // by default, they are all shown.
    boolean alumni = true;
    boolean athletics = true;
    boolean libArts = true;
    boolean faculty = true;
    boolean falcon = true;
    boolean graduate = true;
    boolean business = true;
    boolean education = true;
    boolean nursing = true;
    boolean fineArts = true;
    boolean registrar = true;
    boolean sciTech = true;
    boolean special = true;
    boolean students = true;
    SimpleDateFormat sdf;
    int dateRange = 1; // by default, the date range is set at 1 month. You can change it in the settings

    Calendar temp;
    Date dateLimit;

    //boolean

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        temp = Calendar.getInstance();
        temp.add(Calendar.MONTH, dateRange); // get a calendar x month(s) later than today's date
        dateLimit = temp.getTime();

        adapter = new CustomListAdapter(this.getActivity(), titleList, descriptionList, imgIdList,
                locationList, startTimeList, endTimeList, categories, dates, this);
        setListAdapter(adapter); // the customlistadapter handles showing all list items coming into view

        getListView().setOnItemClickListener(this);
    }

    //==============================================================================================

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(
                R.layout.feed_fragment, container, false); // show activity with feed_fragment layout
    }

    //==============================================================================================

    public void onItemClick(AdapterView parent, View view, int position, long id)
    {
        mapsActivity.findBuilding(locationList.get(position)); // will zoom in to the associated location
                                                               // on the map if applicable
    };
    //==================================================================================================
    void setMapsActivity(MapsActivity tempMapActivity)
    {
        mapsActivity = tempMapActivity;
    } // way to pass info b/t fragments
    //==================================================================================================
    String[] getEvents(String name) // this grabs all the events that pertain to certain locations
                                    // and fills their info into the BuildingFragment event field.
    {
        Vector<String> events;
        String[] eventArray;
        int size;
        events = new Vector();
        size = locationList.size();
        for(int n = 0; n < size; n++)
        {
            if(locationList.get(n).contains(name) || name.contains(locationList.get(n)))
                events.add("Event name: " + titleList.get(n) + "\n\nLocation: " + locationList.get(n) + "\n\nTime: " + startTimeList.get(n) + " - "
                        + endTimeList.get(n) + "\n\nDescription: " + descriptionList.get(n) + "\n");
        }
        if(events.size() == 0)
            events.add("No current events at this location");
        size = events.size();
        eventArray = new String[size];
        for(int n = 0; n < size; n++)
            eventArray[n] = events.elementAt(n);
        return eventArray;
    }

    //==============================================================================================
    // This method is called by SettingsFragment every time the user clicks "save."
    // It simply updates the fields that we use for filtering
    public void updateSettings(boolean alumni, boolean athletics, boolean libArts, boolean faculty,
                               boolean falcon, boolean graduate, boolean business, boolean education,
                               boolean nursing, boolean fineArts, boolean registrar, boolean sciTech,
                               boolean special, boolean students, int dateRange ) {
        this.alumni = alumni;
        this.athletics = athletics;
        this.libArts = libArts;
        this.faculty = faculty;
        this.falcon = falcon;
        this.graduate = graduate;
        this.business = business;
        this.education = education;
        this.nursing = nursing;
        this.fineArts = fineArts;
        this.registrar = registrar;
        this.sciTech = sciTech;
        this.special = special;
        this.students = students;
        this.dateRange = dateRange;
    }

    //==============================================================================================
    // These data structures NEED to be constructed before the FeedFragment comes into view.
    // However, you cannot specify a constructor for Fragments and Activities. Android suggests
    // that you use onCreate(). Unfortunately, we can only call onCreate() when the user brings
    // this fragment into view. So we gave this fragment a method to instantiate the data structures
    // so we can fill them up when the app starts. Then, the populated data structures are used in onCreate()
    public void buildFeedStructures()
    {
        titleList = new ArrayList<String>();
        descriptionList = new ArrayList<String>();
        categories = new ArrayList<String>();
        imgIdList = new ArrayList<Integer>();
        locationList = new ArrayList<String>();
        startTimeList = new ArrayList<String>();
        endTimeList = new ArrayList<String>();
        dates = new ArrayList<Date>();
        sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
    }

    //==============================================================================================
    // this method is called by ConnectionHandler so it can populate the data structures
    // as it is getting the data from the server.
    public void addFeedItem(String eventTitle, String eventDescription, String category,
                            String location, String startTime, String endTime)
    {
        try {
            dates.add(sdf.parse(startTime.substring(5, 15))); // add the date object for checking later
            titleList.add(eventTitle); // add all events to the beginning of the list
            descriptionList.add(eventDescription);
            categories.add(category);
            determineImage(category);
            locationList.add(location);
            startTimeList.add(startTime);
            endTimeList.add(endTime);
        }
        catch(ParseException p)
        {
            Log.d("debug", "Error parsing date. Event not added.");
        }
    }

    //==================================================================================================
    // this method takes the category of a particular event and tries to assign an image
    // that's related to the category. If nothing can be found, a default image is specified
    private void determineImage(String category)
    {
        int imageID;

        switch(category)
        {
            case "Athletics" :
                imageID = R.drawable.baseball_icon;
                break;

            case "Registrar" :
                imageID = R.drawable.education_icon;
                break;

            case "Faculty & Staff" :
                imageID = R.drawable.faculty_icon;
                break;

            case "School of Fine Arts" :
                imageID = R.drawable.music_icon;
                break;

            case "Student Life" :
                imageID = R.drawable.student_icon;
                break;

            default :
                imageID = R.drawable.falcon_icon;
        }

        imgIdList.add(imageID);
    }
}

