//File name: DefaultExpandableListAdapter.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: Holds building information that is displayed in BuildingFragment
//Last Edited: 05/06/2016

package com.example.bmathis.interactivemap;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;

public class DefaultExpandableListAdapter extends BaseExpandableListAdapter
{
    private List<String> headers;
    private HashMap<String,List<String>> children;
    private Context context;
    ExpandableListView view;
    //==================================================================================================
//Default constructor for DefaultExpandableListAdapter
    DefaultExpandableListAdapter(Context ctx, List<String> headerNames,HashMap<String,List<String>> childrenHash)
    {
        context = ctx;
        children = childrenHash;
        headers = headerNames;
    }
    //==================================================================================================
//Sets the ListView that contains the adapter
    void setListView(ExpandableListView tempView)
    {
        view = tempView;
    }
    //==================================================================================================
//Returns the number of categories in the adapter
    @Override
    public int getGroupCount()
    {
        return headers.size();
    }
    //==================================================================================================
//Returns the number of children in selected group
    @Override
    public int getChildrenCount(int groupPosition)
    {
        return children.get(headers.get(groupPosition)).size();
    }
    //==================================================================================================
//Returns the header of the selected group
    @Override
    public Object getGroup(int groupPosition)
    {
        return headers.get(groupPosition);
    }
    //==================================================================================================
//Returns the child in the selected group and position in the group
    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return children.get(headers.get(groupPosition)).get(childPosition);
    }
    //==================================================================================================
//Returns the ID of the group position
    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }
    //==================================================================================================
//Returns the ID of the child position at the given group position
    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }
    //==================================================================================================
//Returns that the IDs can change
    @Override
    public boolean hasStableIds()
    {
        return false;
    }
    //==================================================================================================
//Returns the view for the group heading
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        String title;
        title = getGroup(groupPosition).toString();
        if(convertView == null)
        {
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout,null);
        }
        TextView textView;
        textView = (TextView) convertView.findViewById(R.id.parent_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return convertView;
    }
    //==================================================================================================
//Returns the view for the child item at the given group and child position
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        String childTitle;
        childTitle = getChild(groupPosition, childPosition).toString();
        if(convertView == null)
        {
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout,null);
        }
        TextView textView;
        textView = (TextView) convertView.findViewById(R.id.child_item);
        textView.setText(childTitle);
        return convertView;
    }
    //==================================================================================================
//Returns that the items in the list can be clicked
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
    @Override
//==================================================================================================
//Collapses the groups that were expanded and expands the group that was clicked
    public void onGroupExpanded(int groupPosition)
    {
        for (int i = 0; i < getGroupCount(); i++)
        {
            if (i != groupPosition)
                view.collapseGroup(i);
        }
        super.onGroupExpanded(groupPosition);
    }
}
