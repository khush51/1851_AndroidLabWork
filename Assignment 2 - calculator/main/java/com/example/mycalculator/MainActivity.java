package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;

    Button ac , clear , negate , divide , multiply , subtract , add , equals , point , zero , one , two , three , four , five , six , seven , eight , nine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final boolean isAdd = false , isSub = false , isMul = false , isDiv = false , op1 = false, op2 = false;

        final float value1 , value2 , answer;

        result = (TextView) findViewById(R.id.answer);

        ac = (Button) findViewById(R.id.AC);
        clear = (Button) findViewById(R.id.clear);
        negate = (Button) findViewById(R.id.negate);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        subtract = (Button) findViewById(R.id.subtract);
        add = (Button) findViewById(R.id.add);
        equals = (Button) findViewById(R.id.equal);
        point = (Button) findViewById(R.id.point);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);

        answer = Float.parseFloat(result.getText().toString());

        //reset
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result.setText("0.0");

            }
        });

        //clear
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        //negate
        negate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float temp = Float.parseFloat(result.getText().toString());
                temp = 0 - temp ;
                result.setText(String.valueOf(temp));

            }
        });

        //divide
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(op1 == true && op2 == true )
                {

                }

            }
        });

        //multiply
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //subtract
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //add
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //equals
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //point
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //zero
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //one
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //two
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //three
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //four
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //five
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //six
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //seven
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //eight
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //nine
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}