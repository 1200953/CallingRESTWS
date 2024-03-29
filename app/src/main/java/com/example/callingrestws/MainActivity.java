package com.example.callingrestws;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button findAllCoursesBtn = findViewById(R.id.btnFindAll);
        findAllCoursesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CoursesAsyncTask getAllCourses = new CoursesAsyncTask();
                getAllCourses.execute();
            }
        });
    }
    private class CoursesAsyncTask extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground (Void...params){
            return RestClient.findAllCourses();
        }
        @Override
        protected void onPostExecute (String courses){
            TextView resultTextView = findViewById(R.id.tvResult);
            resultTextView.setText(courses);
        }
    }
}

