package com.example.happyhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private EditText nam, years;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nam = findViewById(R.id.nam);
        years =findViewById(R.id.years);

        if (savedInstanceState != null){
            String name = savedInstanceState.getString("name");
            String Age = savedInstanceState.getString("age");

            nam.setText(name);
            years.setText(Age);
        }

        Button LoginButton = (Button) findViewById(R.id.loginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Credentials.class));

            }
        });
        Log.d(TAG,"onCreate");
    }

    // Called after onCreate has finished, use to restore UI state
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        //print a log
        Log.d(TAG,"onRestore");
    }

    // Called before subsequent visible lifetimes an activity process.
    @Override
    public void onRestart(){
        super.onRestart();
        // Load changes knowing that the activity has already been visible within this process.
        //print a log
        Log.d(TAG,"onRestart");
    }

    // Called at the start of the visible lifetime.
    @Override
    public void onStart(){
        super.onStart();
        // Apply any required UI change now that the Activity is visible.
        //print a log
        Log.d(TAG,"onStart");
    }

    // Called at the start of the active lifetime.
    @Override
    public void onResume(){
        super.onResume();
        // Resume any paused UI updates, threads, or processes required by the activity but suspended when it was inactive.
        //print a log
        Log.d(TAG,"onResume");
    }
    // Called to save UI state changes at the end of the active lifecycle.
    @Override
    public void onSaveInstanceState(Bundle outState) {


        String name = nam.getText().toString().trim();
        String Age = years.getText().toString().trim();

        outState.putString("name", name);
        outState.putString("age", Age);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is killed and restarted.
        super.onSaveInstanceState(outState);

        //print a log
        Log.d(TAG,"onSavedInt");
    }
    // Called at the end of the active lifetime.
    @Override
    public void onPause(){
        //Suspend UI updates, threads, or CPU intensive processes that don’t need to be updated when the Activity isn’t
        // the active foreground activity.
        super.onPause();
        //print a log
        Log.d(TAG,"onPause");
    }
    // Called at the end of the visible lifetime.
    @Override
    public void onStop(){
        // Suspend remaining UI updates, threads, or processing that a'int required when the Activity isn’t visible.
        // Persist all edits or state changes as after this call the process is likely to be killed.
        super.onStop();
        //print a log
        Log.d(TAG,"onStop");
    }

    // Called at the end of the full lifetime.
    @Override
    public void onDestroy(){
        // Clean up any resources including ending threads, closing database connections etc.
        super.onDestroy();
        //print a log
        Log.d(TAG,"onDestroy");
    }


}
