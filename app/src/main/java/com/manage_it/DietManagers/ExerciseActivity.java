package com.manage_it.DietManagers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.manage_it.Activities.DietManager;
import com.manage_it.R;

public class ExerciseActivity extends AppCompatActivity {

    private WebView webView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_exercise);

        Toolbar exerciseTasks = (Toolbar) findViewById(R.id.toolbar_exercise);
        setSupportActionBar(exerciseTasks);
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.excerciseWeb);
        webView.setPadding(0, 0, 0, 0);
        webView.setInitialScale(getScale());
        webView.setBackgroundColor(Color.WHITE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setBackgroundColor(Color.WHITE);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                webView.setPadding(0, 0, 0, 0);
                webView.setInitialScale(getScale());
                webView.setBackgroundColor(Color.WHITE);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
                if (i == 1) {
                    webView.loadUrl("file:///android_asset/sixteenexercise/index.html");

                }
                if (i == 2) {
                    webView.loadUrl("file:///android_asset/chest/chest.html");

                }
                if (i == 3) {
                    webView.loadUrl("file:///android_asset/arms/arms.html");
                }
                if (i == 4) {
                    Intent ToPlans = new Intent(ExerciseActivity.this, ExercisePlansActivity.class);
                    startActivity(ToPlans);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private int getScale() {
        Point point = new Point();
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        display.getSize(point);
        int width = point.x;
        Double val = new Double(width) / new Double(377);
        val = val * 100d;
        return val.intValue();
    }


}