package com.manage_it.DietManagers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.manage_it.Activities.DietManager;
import com.manage_it.R;

public class DrinksDetailActivity extends AppCompatActivity {

    private WebView wx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_drinks_details);

 //       Toolbar toolbarCompletedTasks = (Toolbar) findViewById(R.id.toolbar_drinks_details);
   //     setSupportActionBar(toolbarCompletedTasks);
     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wx = (WebView) findViewById(R.id.exc);
        wx.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra("Key");


        if (message.equals("1")) {
            wx.loadUrl("file:///android_asset/drinksdet/first.html");
        }
        if (message.equals("2")) {
            wx.loadUrl("file:///android_asset/drinksdet/two.html");
        }
        if (message.equals("3")) {
            wx.loadUrl("file:///android_asset/drinksdet/third.html");
        }
        if (message.equals("4")) {
            wx.loadUrl("file:///android_asset/drinksdet/four.html");
        }
        if (message.equals("5")) {
            wx.loadUrl("file:///android_asset/drinksdet/five.html");
        }
        if (message.equals("6")) {
            wx.loadUrl("file:///android_asset/drinksdet/six.html");
        }
        if (message.equals("7")) {
            wx.loadUrl("file:///android_asset/drinksdet/sev.html");
        }
        if (message.equals("8")) {
            wx.loadUrl("file:///android_asset/drinksdet/eit.html");
        }
        if (message.equals("9")) {
            wx.loadUrl("file:///android_asset/drinksdet/nine.html");

        }
    }

}