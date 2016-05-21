//File name: MapsActivity.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: This is our main activity class. It is in charge of all of the map related items,
//                  as well as all of the persisting GUI elements (the settings button, the map
//                  and event buttons). It locks the map to the screen, handles routing, user location,
//                  and so on.
//Last Edited: 05/08/2016


package com.example.bmathis.interactivemap;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import java.util.Vector;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMapClickListener,GoogleMap.OnCameraChangeListener,
        GoogleMap.OnMapLongClickListener,ListView.OnItemClickListener,View.OnClickListener, TextWatcher, GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnInfoWindowLongClickListener, GoogleMap.OnInfoWindowCloseListener, GoogleMap.OnMyLocationButtonClickListener,ActivityCompat.OnRequestPermissionsResultCallback

{
    GoogleMap mMap;
    CameraPosition previous;
    private String[] markerList;
    private ArrayList<String> feedList;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList, feedListView;
    ArrayAdapter<String> adapter;
    Button mapButton;
    Button feedButton;
    boolean routingEnabled;
    boolean eventBoolean;
    LinearLayout buttonLayout;
    CampusInfo campusInfo;
    DialogHandler dialogHandler;
    SupportMapFragment mapFragment;
    FeedFragment feedFragment;
    BuildingFragment buildingFragment;
    SettingsFragment settingsFragment;
    EventMakerActivity eventFragment;
    EditText navSearch;
    TextView settingsText;
    ConnectionHandler c;
    MenuItem menuItem;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean mPermissionDenied = false;



    //==================================================================================================
//Constructor for MapsActivity
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drawer_layout_with_list); // load XML file into activity

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext()); // used for checking
                                                                                                   // if the app is on its first load

        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false); // variable for first load

        routingEnabled = false;
        feedFragment = new FeedFragment();
        buildingFragment = new BuildingFragment();
        mapFragment = new SupportMapFragment();
        settingsFragment = new SettingsFragment();
        eventFragment = new EventMakerActivity();
        // programmatically create SupportMapFragment, then
        c = new ConnectionHandler(feedFragment, this); // can't make connections on main thread, handler class
        c.start();

        if(!previouslyStarted)
        {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.commit();
            Log.d("debug", "The app has started for the first time. Show the tutorial.");
            startActivity(new Intent(MapsActivity.this, TutorialActivity.class));
        }
        else
            startActivity(new Intent(MapsActivity.this, TutorialActivity.class));   // still show tutorial activity for presentation purposes

        navSearch = (EditText) findViewById(R.id.NavSearch); // search field for navigation pane filtering
        navSearch.addTextChangedListener(this);

        getSupportFragmentManager().beginTransaction()                                              // add the fragment to the mapFrame from XML
                .add(R.id.mapFrame, mapFragment).commit();
        mapFragment.getMapAsync(this);
        mapButton = (Button) findViewById(R.id.mapButton); // button to switch back to map mode
        mapButton.setOnClickListener(this);
        feedButton = (Button) findViewById(R.id.eventButton); // button to switch to feed mode
        feedButton.setOnClickListener(this);

        markerList = getResources().getStringArray(R.array.locations);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_list);
        mDrawerList.setTextFilterEnabled(true);
        buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout); // used to style how map/feed buttons organized
        adapter = new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, markerList);
        mDrawerList.setAdapter(adapter);                                                            // Set the adapter for the list view
        mDrawerList.setOnItemClickListener(this);
        // Set the list's click listener
        eventBoolean = false;
    }
    //==================================================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // shows the settings button in top-right corner
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    //Prevents hitting the back button
    @Override
    public void onBackPressed()
    {
        return;
    } // disables the back button
    //=================================================================================================
//Sets up map positioning and handles construction of campus attributes
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        campusInfo = new CampusInfo(mMap,this);
        mMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(new CameraPosition(campusInfo.getCampusCenter(), 16, 0, 0)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(campusInfo.getCampusCenter()));               //*********************************************
        Log.d("debug", "Camera Position " + mMap.getCameraPosition());
        //mMap.moveCamera(CameraUpdateFactory.zoomTo(16));                                            //Set map to show only campus in center of screen
        /*CameraPosition temp = mMap.getCameraPosition();
        CameraPosition position = new CameraPosition.Builder()
                .target(temp.target)
                .zoom(temp.zoom)
                .bearing(temp.bearing - 15)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(position));*/
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);                                              //*********************************************
        mMap.getUiSettings().setCompassEnabled(false);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.addPolyline(campusInfo.getCampusBoundaryLine());                                       //Draw the line around campus
        dialogHandler = new DialogHandler(this);
        if(getIntent().hasExtra("marker"))
            makePendingMarker(getIntent());
        mMap.setOnMapLongClickListener(this);
        mMap.setOnCameraChangeListener(this);
        mMap.setOnMapClickListener(this);
        //mMap.setOnMarkerClickListener(this);                                                        //Makes buildings "clickable"
        mMap.setOnInfoWindowLongClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnInfoWindowCloseListener(this);


        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();
        feedFragment.setMapsActivity(this);
       /* mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter()
            {
            @Override
            public View getInfoWindow(Marker marker)
                {
                View view;
                TextView textView;
                view = getLayoutInflater().inflate(R.layout.info_window_layout,null);
                textView = (TextView)view.findViewById(R.id.markerText);
                textView.setText(marker.getTitle());
                return view;
                }
            @Override
            public View getInfoContents(Marker marker)
                {
                return null;
                }
            });*/
    }
    //==================================================================================================
    void findBuilding(String name) // used to associate a building with an event from feed
    {
        LatLng location;
        location = campusInfo.findBuilding(name);
        if(location == null)
            Toast.makeText(this, "Event does not have corresponding location on main campus", Toast.LENGTH_SHORT).show();
        else
        {
            mapButton.performClick();
            mMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(new CameraPosition(location, 18, 0, 0)));
        }
    }
    //==================================================================================================
    private void enableMyLocation() // self explanatory
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            //Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        }
        else if (mMap != null)
        {
            mMap.setMyLocationEnabled(true);
            routingEnabled = true;
        }
    }
    //==================================================================================================
    @Override // also self explanatory. These methods come pretty much straight from the documentation
    public boolean onMyLocationButtonClick() throws SecurityException
    {
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager
                .getBestProvider(criteria, false));
        LatLng latlng;
        if(location != null)
        {
            latlng = new LatLng(location.getLatitude(),location.getLongitude());

            if(campusInfo.checkBoundaries(latlng))
                mMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(new CameraPosition(latlng, 17, 0, 0)));
            else
                Toast.makeText(this, "Location only available on campus", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    //==================================================================================================
    @Override // more user location stuff
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE)
        {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION))
        {
            //Enable the my location layer if the permission has been granted.
            enableMyLocation();
        }
        else
        {
            //Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }
    //==================================================================================================
    @Override // more user location stuff
    protected void onResumeFragments()
    {
        super.onResumeFragments();
        if (mPermissionDenied)
        {
            // Permission was not granted, display error dialog.
            PermissionUtils.PermissionDeniedDialog
                    .newInstance(true).show(getSupportFragmentManager(), "dialog");
            mPermissionDenied = false;
        }
    }

    //==================================================================================================
//Displays a pending event marker on the map. We decided against doing this in the end. Legacy method.
    public void makePendingMarker(Intent intent)
    {
        double[] markerCoordinates;
        markerCoordinates = intent.getDoubleArrayExtra("marker");
        new AlertDialog.Builder(this).setMessage("Event has been sent for approval").show();
        //Marker temp = mMap.addMarker(new MarkerOptions().position(new LatLng(markerCoordinates[0],markerCoordinates[1]))
        //              .title("Pending event")
        //            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        //);
    }
    //==================================================================================================
//Open EventMakerActivity
    public void makeEvent(DialogInterface dialog)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        dialog.dismiss();

        eventFragment.setFields(this); // add location info here

        mapButton.setVisibility(View.INVISIBLE);
        feedButton.setVisibility(View.INVISIBLE);
        transaction.setCustomAnimations(R.anim.slide_down_enter, R.anim.slide_down_exit); // displays animations between transitions
        transaction.replace(R.id.mapFrame, eventFragment); // switch fragments
        transaction.addToBackStack("Event");
        transaction.commit();

    }
    //==================================================================================================
//Open EventMakerActivity
    boolean getEventBoolean()
    {
        return eventBoolean;
    }
    //==================================================================================================
//Handles what happens when buttons are clicked. These buttons switch between map and feed view
    public void onClick(View view)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back

        switch(view.getId())
        {
            case R.id.mapButton:
                // Replace whatever is in the fragment_container view with this fragment,
                mapButton.setBackgroundColor(getResources().getColor(R.color.schoolAccent));
                feedButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                transaction.setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_right_exit);
                transaction.replace(R.id.mapFrame, mapFragment);
                break;

            case R.id.eventButton:
                mapButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                feedButton.setBackgroundColor(getResources().getColor(R.color.schoolAccent));
                transaction.setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_left_exit);
                transaction.replace(R.id.mapFrame, feedFragment);
                break;
        }
        // add the transaction to the back stack so the user can navigate back
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
    //==================================================================================================
    @Override // brings up the settings menu with an animation
    public boolean onOptionsItemSelected(MenuItem item)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(item.getItemId() == R.id.action_settings)
        {
            menuItem = item;
            mapButton.setVisibility(View.INVISIBLE);
            feedButton.setVisibility(View.INVISIBLE);
            //settingsText.setVisibility(View.INVISIBLE);
            settingsFragment.setFields("", null, null, null, null, "", mapFragment,this, feedFragment );
            transaction.setCustomAnimations(R.anim.slide_down_enter, R.anim.slide_down_exit,
                                            R.anim.slide_up_enter,R.anim.slide_up_exit);
            transaction.replace(R.id.mapFrame, settingsFragment);
            item.setVisible(false); // turn off settings button until we return from settings
        }
        // add the transaction to the back stack so the user can navigate back
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();

        return true;
    }
    //==================================================================================================
//Handles what happens when user clicks somewhere on map
    public void onMapClick(LatLng point) // was used for hard-coding things that required lat longititude
    {
        System.out.println(point.latitude + " " + point.longitude);
    }
    //==================================================================================================
//Handles what happens when user holds somewhere on map, creating events process begins
    public void onMapLongClick(LatLng point)
    {
        String[] choices = {"Create Event","Cancel"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                .setTitle("Do you want to make an event here?")
                .setCancelable(false)
                .setSingleChoiceItems(choices, 2,dialogHandler);
        dialog.create().show();

    }
    //==================================================================================================
    int getEventCount()
    {
        return 0;
    }
    //==================================================================================================
    String getEvents()
    {
        return "";
    }
    //==================================================================================================
//Handles when the map is moved, locks map onto campus
    public void onCameraChange(CameraPosition position)
    {
        if(position.zoom < 16)                                                                      //If user zooms map out past initial zoom level
            mMap.animateCamera(CameraUpdateFactory
                    .zoomTo(16));
        LatLng coordinates = position.target;
        if (!campusInfo.checkBoundaries(coordinates))                                                //Handles user going out of acceptable map boundaries
        {
            System.out.println("out");
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(previous));
        }
        else
            previous = position;                                                                    //Save the position since it was a valid move
    }
    //==================================================================================================
//Handles when the buildings info is "clicked", shows building information screen
    public void onInfoWindowClick(Marker marker)
    {
        Vector<String>[] info;
        int size;
        String name;
        String[] degrees;
        String[] departments;
        String[] events;
        String hours;
        String information;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        info = campusInfo.getBuildingInfo(marker);
        if(info != null)
        {                                                                                       //***************************************************
            name = info[0].elementAt(0);                                                            //Prepares information to be opened in building page
            information = info[1].elementAt(0);
            size = info[2].size();
            degrees = new String[size];
            for(int n = 0; n < size; n++)
                degrees[n] = info[2].elementAt(n);
            // size = info[3].size();
            //events = new String[size];
            //for(int n = 0; n < size; n++)
            //  events[n] = info[3].elementAt(n);
            events = feedFragment.getEvents(name);
            size = info[4].size();
            departments = new String[size];
            for(int n = 0; n < size; n++)
                departments[n] = info[4].elementAt(n);
            hours = info[5].elementAt(0);
            mapButton.setVisibility(View.INVISIBLE);
            feedButton.setVisibility(View.INVISIBLE);
            //settingsText.setVisibility(View.INVISIBLE);
            buildingFragment.setFields(name,information,degrees,departments,events,hours, mapFragment, this);   //****************************************************
            transaction.setCustomAnimations(R.anim.slide_up_enter, R.anim.slide_up_exit);
            transaction.replace(R.id.mapFrame, buildingFragment);
            // add the transaction to the back stack so the user can navigate back
            transaction.addToBackStack(null);
            // Commit the transaction
            transaction.commit();
        }

    }
    //==================================================================================================
//Handles when the buildings info is "held", brings up routing
    public void onInfoWindowLongClick(Marker marker)
    {
        try
        {
            if (routingEnabled)
            {
                LocationManager locationManager = (LocationManager)
                        getSystemService(Context.LOCATION_SERVICE);
                Criteria criteria = new Criteria();
                Location location = locationManager.getLastKnownLocation(locationManager
                        .getBestProvider(criteria, false));

                LatLng latlng;
                if (location != null)
                {
                    latlng = new LatLng(location.getLatitude(), location.getLongitude());
                    campusInfo.route(marker,latlng);
                }
                else
                    Toast.makeText(this, "User location could not be determined", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this, "Routing not available without location permission", Toast.LENGTH_LONG).show();
        }
        catch (SecurityException e)
        {
            Toast.makeText(this, "Routing not available without location permission", Toast.LENGTH_LONG).show();
        }
    }
    //===================================================================
    public void onItemClick(AdapterView parent, View view, int position, long id)
    {
        String temp;
        LatLng tempCoordinates;
        temp = (String)parent.getItemAtPosition(position);
        tempCoordinates = campusInfo.findBuilding(temp);
        if(tempCoordinates != null)
            mMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(new CameraPosition(tempCoordinates, 19, 0, 0)));

        navSearch.setText(""); // clear out search bar when you find something

        //mMap.animateCamera(CameraUpdateFactory.zoomTo(19));                                       // focus on map point
        mDrawerLayout.closeDrawer(Gravity.LEFT);                                                    // shut drawer
    }
    //==================================================================================================

    @Override
    public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
    {
        adapter.getFilter().filter(arg0);
    }

    //==================================================================================================

    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3){};

    //==================================================================================================

    @Override
    public void afterTextChanged(Editable arg0){};

    @Override
    public void onInfoWindowClose(Marker marker)
    {
        campusInfo.hideRouting();
    }

    //==================================================================================================

    public void sendEmailEvent(String msg)
    {
        c.setCommand("001EVENTEMAIL" + ">>>" + msg);
    }
}