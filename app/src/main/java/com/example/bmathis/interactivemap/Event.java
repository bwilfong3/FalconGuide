//File name: Event.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: Holds information about a single event on campus
//Last Edited: 05/06/2016

package com.example.bmathis.interactivemap;

import com.google.android.gms.maps.model.Marker;

public class Event
{
    String location;
    String eventName;
    String description;
    String category;
    String eventDate;
    boolean clickable;
    Marker buildingMarker;

    //==================================================================================================
//Default Constructor for Event class
    Event(String tempLocation, String tempEventName, String tempDescription, String tempCategory,String tempDate,CampusInfo info)
    {
        location = tempLocation;
        eventName = tempEventName;
        description = tempDescription;
        category = tempCategory;
        eventDate = tempDate;
        buildingMarker = info.checkIfClickable(location);
        if(buildingMarker == null)
            clickable = false;
        else
            clickable = true;
    }
    //==================================================================================================
//Returns location of event
    String getLocation()
    {
        return location;
    }
    //==================================================================================================
//Returns location of event
    String getEventName()
    {
        return eventName;
    }
    //==================================================================================================
//Returns location of event
    String getDescription()
    {
        return description;
    }
    //==================================================================================================
//Returns location of event
    String getCategory()
    {
        return category;
    }
    //==================================================================================================
//Returns location of event
    String getEventDate()
    {
        return eventDate;
    }
    //==================================================================================================
//Returns whether event is on map
    boolean getClickable()
    {
        return clickable;
    }
    //==================================================================================================
//Returns marker associated with event
    Marker getMarker()
    {
        return buildingMarker;
    }
}
