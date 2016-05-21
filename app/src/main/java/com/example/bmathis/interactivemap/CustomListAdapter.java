//File name: CustomListAdapter.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: This class handles showing the events on the feedfragment. It has
//                  data structures with parallel indices that contain information
//                  about all of the events. When new "view" of the events comes into the display
//                  whether that be opening the event feed or scrolling through, the getView()
//                  method is called. In this method, events are filtered by the user's preferences
//                  and then shown on the screen.
//Last Edited: 05/08/2016

package com.example.bmathis.interactivemap;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    ArrayList<String> eventTitles;
    ArrayList<String> eventDescriptions;
    ArrayList<String> eventLocations;
    ArrayList<String> eventStartTimes;
    ArrayList<String> eventEndTimes;
    ArrayList<Integer> imgid;
    ArrayList<String> categories;
    ArrayList<Date> dates;
    FeedFragment f;


    public CustomListAdapter(Activity context, ArrayList<String> eventTitles,
                             ArrayList<String> eventDescriptions, ArrayList<Integer> imgid,
                             ArrayList<String> eventLocations, ArrayList<String> eventStartTimes,
                             ArrayList<String> eventEndTimes, ArrayList<String> categories,
                             ArrayList<Date> dates, FeedFragment f) {
        super(context, R.layout.feed_list_item, eventTitles);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.eventTitles=eventTitles;
        this.eventDescriptions = eventDescriptions;
        this.eventLocations = eventLocations;
        this.eventStartTimes = eventStartTimes;
        this.eventEndTimes = eventEndTimes;
        this.categories = categories;
        this.dates = dates;

        this.imgid=imgid;

        this.f = f;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.feed_list_item, null, true); // view of a valid list item
        View nullView = inflater.inflate(R.layout.null_list_item, null, true); // null view to return if item should be filtered

        if(dates.get(position).after(f.dateLimit)) // if the start date is later than the specified date
                return nullView;

        switch(categories.get(position)) {
            case "Alumni" : // the category is alumni
                if(!f.alumni) // if alumni is unchecked in the settings (wanting to NOT see alumni stuff)
                    return nullView;
                    // this is an empty list item. It is not possible to return just NULL,
                    // so return something with no fields.
                break;
            case "Athletics" :
                if(!f.athletics)
                    return nullView;
                break;
            case "College of Liberal Arts" :
                if(!f.libArts)
                    return nullView;
                break;
            case "Faculty & Staff" :
                if(!f.faculty)
                    return nullView;
                break;
            case "Falcon Center" :
                if(!f.falcon)
                    return nullView;
                break;
            case "College of Science & Technology" :
                if(!f.sciTech)
                    return nullView;
                break;
            case "Graduate Studies" :
                if(!f.graduate)
                    return nullView;
                break;
            case "Registrar" :
                if(!f.registrar)
                    return nullView;
                break;
            case "School of Business" :
                if(!f.business)
                    return nullView;
                break;
            case "School of Education, Health & Human Performance" :
                if(!f.education)
                    return nullView;
                break;
            case "School of Fine Arts" :
                if(!f.fineArts)
                    return nullView;
                break;
            case "School of Nursing & Allied Health" :
                if(!f.nursing)
                    return nullView;
                break;
            case "Special Events" :
                if(!f.special)
                    return nullView;
                break;
            case "Student Life" :
                if(!f.students)
                    return nullView;
                break;
        }

        // if none of these conditions returned out of the method, start populating
        // the widgets from feed_list_item.xml with the actual data and return that at the end

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        TextView location = (TextView) rowView.findViewById(R.id.locationView);
        TextView time = (TextView) rowView.findViewById(R.id.startTimeView);

        txtTitle.setText(eventTitles.get(position));
        imageView.setImageResource(imgid.get(position));
        extratxt.setText(eventDescriptions.get(position));
        location.setText(eventLocations.get(position));

        // sometimes events come as "Mon, 5/9/16 - 1:00pm (All Day) to Mon, 5/9/16 - 1:00pm (All Day)"
        // The following code concatenates them into "Mon, 5/9/16 - 1:00pm (All Day)" to eliminate redundancy

        if (eventStartTimes.get(position).equals(eventEndTimes.get(position)))
            time.setText(eventEndTimes.get(position));

        else if (eventStartTimes.get(position).startsWith(eventEndTimes.get(position).substring(0, 14)) &&
                !eventStartTimes.get(position).substring(16).startsWith("(All day)"))
            time.setText(eventStartTimes.get(position) + eventEndTimes.get(position).substring(15)); // append the end time to the start time to remove redunancy
                                                                                                     // but look out for all day events
        return rowView;
    };
}