package com.manage_it.DietManagers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.manage_it.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class FoodSuggestionsActivity extends AppCompatActivity {

    String food_url = "https://api.myjson.com/bins/pm7ps";
    ListView listdiet;
    private FoodAdapter mFoodAdapter;
    private ArrayList<Food> mExampleList = new ArrayList<>();

    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_manager_food_suggestions);
        listdiet = (ListView) findViewById(R.id.list_diet);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute(food_url);
            }
        });

//        Toolbar toolbarCompletedTasks = (Toolbar) findViewById(R.id.toolbar_food_suggestions);
  //      setSupportActionBar(toolbarCompletedTasks);
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    class ReadJSON extends AsyncTask<String, Integer, String> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(FoodSuggestionsActivity.this);
            dialog.setMessage("Loading, please wait");
            dialog.setTitle("Connecting server");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            dialog.cancel();
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject foodObject = jsonArray.getJSONObject(i);
                    mExampleList.add(new Food(
                            foodObject.getString("thumbnail"),
                            foodObject.getString("title"),
                            foodObject.getString("ingredients"),
                            foodObject.getString("href")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mFoodAdapter = new FoodAdapter(getApplicationContext(), R.layout.diet_manager_food_item, mExampleList);
            listdiet.setAdapter(mFoodAdapter);

            listdiet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mExampleList.get(position).getMurl()));
                    startActivity(browserIntent);
                }
            });
        }
    }


}
