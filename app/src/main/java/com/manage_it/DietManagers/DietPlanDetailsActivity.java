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

public class DietPlanDetailsActivity extends AppCompatActivity {

    ListView list;
    DietManagerDBHelper mdatabasehelper;
    ArrayList<String> listdata = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> id = new ArrayList<>();
    int Menu_DELETE = 0;
    private FloatingActionButton fab;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_diet_plan_details);

  //      Toolbar toolbarCompletedTasks = (Toolbar) findViewById(R.id.toolbar_diet_plan_details);
    //    setSupportActionBar(toolbarCompletedTasks);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        key = intent.getStringExtra("Key");


        list = findViewById(R.id.list);
        fab = findViewById(R.id.donefab);
        mdatabasehelper = new DietManagerDBHelper(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DietPlanDetailsActivity.this, AddPlanActivity.class);
                i.putExtra("Key", key);
                startActivity(i);
                finish();
            }
        });

        registerForContextMenu(list);

        popuplist(key);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.list) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.add(Menu.NONE, Menu_DELETE, Menu.NONE, "Delete");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = item.getItemId();

        if (index == Menu_DELETE) {
            int deletePost = info.position;
            if (deletePost > -1) {
                mdatabasehelper.deletex(String.valueOf(id.get(deletePost)));
                listdata.remove(deletePost);
                arrayAdapter.notifyDataSetChanged();
                arrayAdapter.notifyDataSetInvalidated();
            }
        } else {
            Toast.makeText(this, "Unable To Perform This Action", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void popuplist(final String key) {
        Cursor data = mdatabasehelper.getdata(key);
        while (data.moveToNext()) {
            listdata.add("\nType : " + data.getString(1) + "\n\n" + "Item : " + data.getString(3)
                    + "\n\n" + "Ingredients : " + data.getString(4));
            id.add(data.getString(0));
        }

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listdata);
        list.setAdapter(arrayAdapter);

    }


}
