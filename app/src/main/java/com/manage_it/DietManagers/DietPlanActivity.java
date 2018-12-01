package com.manage_it.DietManagers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.manage_it.Activities.DietManager;
import com.manage_it.R;

public class DietPlanActivity extends AppCompatActivity {


    private CardView w1, w2, w3, w4, w5, w6, w7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_diet_plan);

  //      Toolbar toolbarCompletedTasks = (Toolbar) findViewById(R.id.toolbar_diet_plan);
    //    setSupportActionBar(toolbarCompletedTasks);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        w1 = (CardView) findViewById(R.id.w1);
        w2 = (CardView) findViewById(R.id.w2);
        w3 = (CardView) findViewById(R.id.w3);
        w4 = (CardView) findViewById(R.id.w4);
        w5 = (CardView) findViewById(R.id.w5);
        w6 = (CardView) findViewById(R.id.w6);
        w7 = (CardView) findViewById(R.id.w7);

        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DietPlanActivity.this, DietPlanDetailsActivity.class);

                i.putExtra("Key", "Monday");
                startActivity(i);

            }
        });
        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DietPlanActivity.this, DietPlanDetailsActivity.class);
                i.putExtra("Key", "Tuesday");
                startActivity(i);

            }
        });
        w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DietPlanActivity.this, DietPlanDetailsActivity.class);
                i.putExtra("Key", "Wednesday");
                startActivity(i);
            }
        });
        w4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DietPlanActivity.this, DietPlanDetailsActivity.class);
                i.putExtra("Key", "Thursday");
                startActivity(i);
            }
        });

        w5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DietPlanActivity.this, DietPlanDetailsActivity.class);
                i.putExtra("Key", "Friday");
                startActivity(i);
            }
        });

        w6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DietPlanActivity.this, DietPlanDetailsActivity.class);
                i.putExtra("Key", "Saturday");
                startActivity(i);
            }
        });
        w7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DietPlanActivity.this, DietPlanDetailsActivity.class);
                i.putExtra("Key", "Sunday");
                startActivity(i);
            }
        });
    }

}

