//File name: BuildingFragment.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: Handles displaying information about individual buildings and uses building_fragment.xml
//Last Edited: 05/06/2016

package com.example.bmathis.interactivemap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.maps.SupportMapFragment;
import java.util.HashMap;
import java.util.List;

public class BuildingFragment extends Fragment implements View.OnClickListener,ExpandableListView.OnChildClickListener
{
    TextView returnText;
    ExpandableListView listView;
    FragmentTransaction transaction;
    SupportMapFragment mapFragment;
    MapsActivity mapsActivity;
    TextView buildingNameField;
    View view;
    String buildingName;
    String information;
    String[] headingText;
    String[] degreeFocusArray;
    String[] departmentArray;
    String[] eventsArray;
    String buildingHours;
    List<String> info;
    List<String> headings;
    List<String> degrees;
    List<String> departments;
    List<String> events;
    List<String> hours;
    HashMap<String,List<String>> childList;
    DefaultExpandableListAdapter adapter;
    ScrollView mScrollView;

    //==================================================================================================
//Handles creating the view and building information for BuildingFragment class
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mapsActivity.eventBoolean = true;
        info = new ArrayList<String>();
        headings = new ArrayList<String>();
        degrees = new ArrayList<String>();
        departments = new ArrayList<String>();
        events = new ArrayList<String>();
        hours = new ArrayList<String>();
        childList = new HashMap<String,List<String>> ();
        headingText = getResources().getStringArray(R.array.list_headers);
        listView = (ExpandableListView) view.findViewById(R.id.listView);
        headings.add(headingText[0]);
        info.add(information);
        childList.put(headingText[0], info);
        if(!degreeFocusArray[0].equals("N/A"))                                                      //If degree focus applies to current building
        {
            headings.add(headingText[1]);
            for (int n = 0; n < degreeFocusArray.length; n = n + 2)
                degrees.add(degreeFocusArray[n]);
            childList.put(headingText[1], degrees);
        }
        if(!departmentArray[0].equals("N/A"))                                                       //If department applies to current building
        {
            headings.add(headingText[2]);
            for (int n = 0; n < departmentArray.length; n = n + 2)
                departments.add(departmentArray[n]);
            childList.put(headingText[2], departments);
        }
        headings.add(headingText[3]);
        for (int n = 0; n < eventsArray.length; n++)
            events.add(eventsArray[n]);
        childList.put(headingText[3], events);
        if(!buildingHours.equals("N/A"))                                                            //If building hours applies to current building
        {
            headings.add(headingText[4]);
            hours.add(buildingHours);
            childList.put(headingText[4], hours);
        }
        adapter = new DefaultExpandableListAdapter(mapsActivity, headings, childList);
        listView.setAdapter(adapter);
        buildingNameField = (TextView) view.findViewById(R.id.nameLabel);
        buildingNameField.setText(buildingName);
        mScrollView = (ScrollView)view.findViewById(R.id.buildingScrollView);
        mScrollView.post(new Runnable()
        {
            public void run()
            {
                mScrollView.scrollTo(0, 0);
                for(int n = 0; n < adapter.getGroupCount(); n++)
                {
                    if(listView.isGroupExpanded(n))
                        listView.collapseGroup(n);
                }
            }
        });
        adapter.setListView(listView);
        listView.setOnChildClickListener(this);
        returnText = (TextView) view.findViewById(R.id.returnText);
        returnText.setOnClickListener(this);
    }
    //==================================================================================================
//Prepares the view for BuildingFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.building_fragment, container, false);                      // Inflate the layout for this fragment
        return view;
    }
    //==================================================================================================
//Populates the different fields for the building fragment
    public void setFields(String name,String tempInfo,String[] degreeFocus, String[] departments,String[] tempEvents, String hours, SupportMapFragment map,MapsActivity activity)
    {
        mapFragment = map;
        mapsActivity = activity;
        buildingName = name;
        degreeFocusArray = degreeFocus;
        departmentArray = departments;
        buildingHours = hours;
        eventsArray = tempEvents;
        information = tempInfo;
    }
    //==================================================================================================
//Handles items in the BuildingFragment being clicked
    public void onClick(View view)
    {
        if (view.getId() == R.id.returnText)
        {
            transaction = mapsActivity.getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.slide_down_enter, R.anim.slide_down_exit);
            transaction.replace(R.id.mapFrame, mapFragment);
            mapsActivity.mapButton.setVisibility(View.VISIBLE);
            mapsActivity.feedButton.setVisibility(View.VISIBLE);
            mapsActivity.eventBoolean = false;
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
    //==================================================================================================
//Opens a given web page in the devices default browser
    public void openWebPage(String url)
    {
        if(!url.trim().equals(""))
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }
    }
    //==================================================================================================
//Handles when an item in the ExpandableListView is clicked
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
    {
        if (headings.get(groupPosition).equals("Degree Focus"))
            openWebPage(degreeFocusArray[childPosition * 2 + 1]);                                   //Open the link that corresponds to the degree clicked
        else if(headings.get(groupPosition).equals("Departments"))
            openWebPage(departmentArray[childPosition * 2 + 1]);                                    //Open the link that corresponds to the department clicked
        return false;
    }
}