package com.example.overviewofandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("method Call", "onCreate: 2");
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("method Call", "onStart: 2 ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("method Call", "onResume: 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("method Call", "onPause: 2");
    }

    @Override
    protected void onStop() {
        Log.d("method Call", "onStop: 2");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("method Call", "onRestart: 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("method Call", "onDestroy: 2");
    }
}