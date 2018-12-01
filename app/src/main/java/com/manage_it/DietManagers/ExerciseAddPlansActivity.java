package com.manage_it.DietManagers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.manage_it.Activities.DietManager;
import com.manage_it.R;

public class ExerciseAddPlansActivity extends AppCompatActivity {

    private Spinner Workout, Days, Time;
    private Button Save;
    private String WorkoutText, DaysText, TimeText;
    private DietManagerDBHelper mdatabasehelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_exercise_add_plans);

        Toolbar toolbarCompletedTasks = (Toolbar) findViewById(R.id.toolbar_exercise_add_plans);
        setSupportActionBar(toolbarCompletedTasks);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mdatabasehelper = new DietManagerDBHelper(this);

        Workout = (Spinner) findViewById(R.id.spinner_addplan);

        Days = (Spinner) findViewById(R.id.spinner_adddays);

        Time = (Spinner) findViewById(R.id.spinner_addtimezone);

        Time.setVisibility(View.INVISIBLE);

        Workout.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                WorkoutText = Workout.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(ExerciseAddPlansActivity.this, "Please Select Workout Plan", Toast.LENGTH_SHORT).show();
            }
        });
        Days.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                DaysText = Days.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(ExerciseAddPlansActivity.this, "Please Select Day", Toast.LENGTH_SHORT).show();

            }
        });

        Time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TimeText = Time.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Save = (Button) findViewById(R.id.saveplan);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!WorkoutText.equals("Select Excercise") && !DaysText.equals("Select Day")) {
                    AddWorkoutPlan(WorkoutText, DaysText);
                } else {
                    Toast.makeText(ExerciseAddPlansActivity.this, "Please Select Workout Plan and Day", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void AddWorkoutPlan(String workoutText, String daysText) {

        boolean data = mdatabasehelper.workplan(workoutText, daysText);
        if (data) {
            Toast.makeText(getApplicationContext(), "Added successfully ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ExerciseAddPlansActivity.this, ExercisePlansActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong ", Toast.LENGTH_LONG).show();
        }
    }

}
