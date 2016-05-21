//File name: DialogHandler.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: Creates a dialog for user to decide whether to create event or not
//Last Edited: 05/06/2016

package com.example.bmathis.interactivemap;

import android.content.DialogInterface;

public class DialogHandler implements DialogInterface.OnClickListener
{
    MapsActivity mapsActivity;
    //==================================================================================================
//Default constructor for DialogHandler
    DialogHandler(MapsActivity tempActivity)
    {
        mapsActivity = tempActivity;
    }
    //==================================================================================================
//Handles user choice in Dialog
    @Override
    public void onClick(DialogInterface dialog, int which)
    {
        if(which == 0)
        {
            mapsActivity.makeEvent(dialog);
        }
        else
            dialog.dismiss();
    }
}
