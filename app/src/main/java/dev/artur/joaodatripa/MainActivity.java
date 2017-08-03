/**
 * Copyright (C) 2017 VOTU RFID Solutions.
 * <p>
 * Licensed under no license, Version 1.0
 * <p>
 * Author: Artur de Araujo
 * in: 02/08/2017
 */
package dev.artur.joaodatripa;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import dev.artur.joaodatripa.Adapters.MyPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the elevation of the ActionBar to show no shadow.
        getSupportActionBar().setElevation(0);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);


        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, new OrderMenuFragment())
//                .commit();
    }

}
