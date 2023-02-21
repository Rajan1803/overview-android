package com.example.overviewofandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btnID);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });

        Log.d("method Call", "onCreate: ");




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("method Call", "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("method Call", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("method Call", "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("method Call", "onRestart: ");
    }

    @Override
    protected void onStop() {
        Log.d("method Call", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("method Call", "onDestroy: ");
    }
}