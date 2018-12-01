package com.manage_it.DietManagers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.manage_it.Activities.DietManager;
import com.manage_it.R;

public class DrinksActivity extends AppCompatActivity {

    ImageButton dr1, dr2, dr3, dr4, dr5, dr6, dr7, dr8, dr9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_drinks);

  //     Toolbar toolbarCompletedTasks = (Toolbar) findViewById(R.id.toolbar_drinks);
    //    setSupportActionBar(toolbarCompletedTasks);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dr1 = (ImageButton) findViewById(R.id.d1);
        dr2 = (ImageButton) findViewById(R.id.d2);
        dr3 = (ImageButton) findViewById(R.id.d3);
        dr4 = (ImageButton) findViewById(R.id.d4);
        dr5 = (ImageButton) findViewById(R.id.d5);
        dr6 = (ImageButton) findViewById(R.id.d6);
        dr7 = (ImageButton) findViewById(R.id.d7);
        dr8 = (ImageButton) findViewById(R.id.d8);
        dr9 = (ImageButton) findViewById(R.id.d9);

        Intent i;
        dr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "1");
                startActivity(intent);

            }
        });

        dr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "2");
                startActivity(intent);

            }
        });

        dr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "3");
                startActivity(intent);

            }
        });

        dr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "4");
                startActivity(intent);

            }
        });

        dr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "5");
                startActivity(intent);
            }
        });

        dr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "6");
                startActivity(intent);
            }
        });

        dr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "7");
                startActivity(intent);
            }
        });

        dr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "8");
                startActivity(intent);
            }
        });

        dr9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, DrinksDetailActivity.class);
                intent.putExtra("Key", "9");
                startActivity(intent);
            }
        });
    }

}