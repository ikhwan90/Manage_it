package com.manage_it.Activities;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.manage_it.DietManagers.DietPlanActivity;
import com.manage_it.DietManagers.DrinksActivity;
import com.manage_it.DietManagers.ExerciseActivity;
import com.manage_it.DietManagers.FoodSuggestionsActivity;
import com.manage_it.R;

public class DietManager extends AppCompatActivity {

    ImageButton img1, img2, img3, img4;
    private CardView cardView1, cardView2, cardView3, cardView4;
    private Intent i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_manager);

  //      Toolbar toolbarDietMain = (Toolbar) findViewById(R.id.toolbar_diet_manager);
    //    setSupportActionBar(toolbarDietMain);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardView1 = (CardView) findViewById(R.id.card1);
      //  cardView2 = (CardView) findViewById(R.id.card2);
        cardView3 = (CardView) findViewById(R.id.card3);
        cardView4 = (CardView) findViewById(R.id.card4);

        img1 = (ImageButton) findViewById(R.id.diet_plan);
     //   img2 = (ImageButton) findViewById(R.id.sugges);
        img3 = (ImageButton) findViewById(R.id.simpleexe);
        img4 = (ImageButton) findViewById(R.id.fatdrink);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(DietManager.this, DietPlanActivity.class);
                startActivity(i);
            }
        });

/*        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(DietManager.this, FoodSuggestionsActivity.class);
                startActivity(i);
            }
        });
*/
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(DietManager.this, ExerciseActivity.class);
                startActivity(i);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(DietManager.this, DrinksActivity.class);
                startActivity(i);
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

/*        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(DietManager.this, FoodSuggestionsActivity.class);
                startActivity(i);
            }
        });
*/
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(DietManager.this, ExerciseActivity.class);
                startActivity(i);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(DietManager.this, DrinksActivity.class);
                startActivity(i);
            }
        });
    }

}
