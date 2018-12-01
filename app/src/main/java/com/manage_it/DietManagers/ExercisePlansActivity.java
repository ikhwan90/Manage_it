package com.manage_it.DietManagers;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.manage_it.Activities.DietManager;
import com.manage_it.R;

import java.util.ArrayList;

public class ExercisePlansActivity extends AppCompatActivity {

    DietManagerDBHelper mdatabasehelper;
    ArrayList<String> Wlistdata = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> id = new ArrayList<>();
    int MENU_DELETE = 0;
    private ListView listworkout;
    private FloatingActionButton doneplan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_exercise_plans);

        Toolbar toolbarCompletedTasks = (Toolbar) findViewById(R.id.toolbar_exercise_plans);
        setSupportActionBar(toolbarCompletedTasks);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listworkout = (ListView) findViewById(R.id.listworkout);
        doneplan = (FloatingActionButton) findViewById(R.id.doneplan);
        mdatabasehelper = new DietManagerDBHelper(this);

        doneplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExercisePlansActivity.this, ExerciseAddPlansActivity.class);
                startActivity(i);
                finish();
            }
        });

        registerForContextMenu(listworkout);
        listpop();

    }

    private void listpop() {
        Cursor workdata = mdatabasehelper.getworkoutdata();
        while (workdata.moveToNext()) {

            Wlistdata.add("\nWorkout : " + workdata.getString(1) + "\n\n " + "Day : " + workdata.getString(2));
            id.add(workdata.getString(0));
        }

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Wlistdata);
        listworkout.setAdapter(arrayAdapter);
    }

    //menu on list click
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.listworkout) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.add(Menu.NONE, MENU_DELETE, Menu.NONE, "Delete");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = item.getItemId();

        if (index == MENU_DELETE) {
            int deletePost = info.position;
            if (deletePost > -1) {
                mdatabasehelper.deleteworkout(String.valueOf(id.get(deletePost)));
                Wlistdata.remove(deletePost);
                arrayAdapter.notifyDataSetChanged();
                arrayAdapter.notifyDataSetInvalidated();
            }
        } else {
            Toast.makeText(this, "Unable To Perform This Action", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


}