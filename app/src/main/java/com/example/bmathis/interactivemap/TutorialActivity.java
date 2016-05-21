//File name: TutorialActivity.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: This activity is shown on the application's first load and can be selected
//                  from the settings page. It shows a how-to with pictures on how to use the
//                  application and its features.
//Last Edited: 05/08/2016

package com.example.bmathis.interactivemap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class TutorialActivity extends AppCompatActivity implements View.OnClickListener {

    Button gotItButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); // hide actionbar junk
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.tutorial_activity_layout);

        gotItButton = (Button) findViewById(R.id.gotItButton);
        gotItButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {} // disable back button so they have to read it and can't just back out
                                   // empty method so nothing happens

    @Override
    public void onClick(View v)
    {
        finish();
    } // if they click the one listener, the button, it will close
}
