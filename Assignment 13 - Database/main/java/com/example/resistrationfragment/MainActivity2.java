package com.example.resistrationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView title = (TextView) findViewById(R.id.pageTitle);
        title.setText("Registered Users");

        AppCompatImageButton save , done , prev;

        prev = (AppCompatImageButton) findViewById(R.id.prev);
        save = (AppCompatImageButton) findViewById(R.id.save);
        done = (AppCompatImageButton) findViewById(R.id.done);

        save.setVisibility(View.INVISIBLE);
        done.setVisibility(View.INVISIBLE);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this , MainActivity.class));
            }
        });



    }
}