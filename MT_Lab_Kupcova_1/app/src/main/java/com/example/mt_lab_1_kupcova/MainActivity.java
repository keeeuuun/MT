package com.example.mt_lab_1_kupcova;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    GridView gridView;

    int[] game_field = {1, 0, 1, 0, 2, 3, 2, 3, 0, 1, 0, 1, 2, 2, 3, 3};
    int[] resources = {
            R.drawable.ic_1,
            R.drawable.ic_2,
            R.drawable.ic_3,
            R.drawable.ic_wb_cloudy_black_24dp
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_view);

        final GridAdapter gridAdapter = new GridAdapter(this.getBaseContext(), game_field, resources);
        gridView.setAdapter(gridAdapter);

    }

}
