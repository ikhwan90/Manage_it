package com.manage_it.DietManagers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.manage_it.Activities.DietManager;
import com.manage_it.R;

import java.util.ArrayList;
import java.util.List;

public class AddPlanActivity extends AppCompatActivity {

    String Text;
    DietManagerDBHelper mdatabasehelper;
    private Spinner spinner;
    private EditText fname, findi;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_add_plan);

 //       Toolbar toolbarCompletedTasks = (Toolbar) findViewById(R.id.toolbar_diet_add_plan);
   //     setSupportActionBar(toolbarCompletedTasks);
     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner = findViewById(R.id.spinner);
        fname = findViewById(R.id.foodname);
        findi = findViewById(R.id.indi);
        button = findViewById(R.id.add);

        mdatabasehelper = new DietManagerDBHelper(this);

        List<String> type = new ArrayList<>();
        type.add("Select Type");
        type.add("Breakfast");
        type.add("Lunch");
        type.add("Snacks");
        type.add("Dinner");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text = spinner.getSelectedItem().toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Intent intent = getIntent();
        final String m = intent.getStringExtra("Key");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Text != "Select Type" && fname.getText().toString() != "" && fname.getText().length() != 0 && fname.getText().toString() != null) {
                    String name = fname.getText().toString();
                    String indi = findi.getText().toString();
                    AddData(m, name, indi, Text);
                }
            }
        });

    }

    private void AddData(String m, String name, String indi, String text) {
        boolean insertdata = mdatabasehelper.adddata(m, name, indi, text);
        if (insertdata) {
            Toast.makeText(getApplicationContext(), "Item added successfully ", Toast.LENGTH_LONG).show();
            Intent i = new Intent(AddPlanActivity.this, DietPlanDetailsActivity.class);
            i.putExtra("Key", m);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong ", Toast.LENGTH_LONG).show();
        }
    }

}
