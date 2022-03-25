package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] History = new String[3];
    Spinner spinner;




    TextView firstnumber;
    TextView secondnumber;
    TextView result;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;

    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button clear;
    Button equals;

    String act;
    boolean fnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> autoBrandAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, History);

        autoBrandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spautoBrands = (Spinner) findViewById(R.id.spinner);
        spautoBrands.setAdapter(autoBrandAdapter);

        spautoBrands.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = spinner.getSelectedItem().toString();
                String[] arrtext = text.split("=");
                


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        History[0] = "";
        History[1] = "";
        History[2] = "";
        act="";
        fnum = true;

        firstnumber = findViewById(R.id.FirstNumber);
        secondnumber = findViewById(R.id.SecondNumber);
        result = findViewById(R.id.Result);

         zero = findViewById(R.id.zero);
         one = findViewById(R.id.one);
         two = findViewById(R.id.two);
         three = findViewById(R.id.three);
         four = findViewById(R.id.four);
         five = findViewById(R.id.five);
         six = findViewById(R.id.six);
         seven = findViewById(R.id.seven);
         eight = findViewById(R.id.eight);
         nine = findViewById(R.id.nine);

         plus = findViewById(R.id.plus);
         minus = findViewById(R.id.minus);
         multiply = findViewById(R.id.multiply);
         divide = findViewById(R.id.divide);
         clear = findViewById(R.id.clear);
         equals = findViewById(R.id.equals);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numText;
                if(fnum){
                    numText =firstnumber.getText().toString();
                    numText+= button.getText().toString();
                    firstnumber.setText(numText);

                }else{

                    numText=secondnumber.getText().toString();
                    numText +=button.getText().toString();
                    secondnumber.setText(numText);
                }
                break;
            case R.id.plus:
                act = "+";
                Button button1 = (Button) view;
                if(act== button1.getText().toString()){
                    act = button1.getText().toString();
                    if(!fnum){
                        fnum=!fnum;
                    }
                }else {
                    fnum=!fnum;
                }
                break;
            case R.id.minus:
                act = "-";
                Button button2 = (Button) view;
                if(act== button2.getText().toString()){
                    act = button2.getText().toString();
                    if(!fnum){
                        fnum=!fnum;
                    }
                }else {
                    fnum=!fnum;
                }
                break;
            case R.id.multiply:
                act = "X";
                Button button3 = (Button) view;
                if(act== button3.getText().toString()){
                    act = button3.getText().toString();
                    if(!fnum){
                        fnum=!fnum;
                    }
                }else {
                    fnum=!fnum;
                }
                break;
            case R.id.divide:
                act = "/";
                Button button4 = (Button) view;
                if(act== button4.getText().toString()){
                    act = button4.getText().toString();
                    if(!fnum){
                        fnum=!fnum;
                    }
                }else {
                    fnum=!fnum;
                }
                break;
            case R.id.equals:
                float firstnum = Float.valueOf(firstnumber.getText().toString());
                float secondnum = Float.valueOf(secondnumber.getText().toString());
                float res;
                if (act == "+"){
                    res = firstnum+secondnum;
                }else if (act == "-"){
                    res = firstnum-secondnum;
                }else if (act == "X"){
                    res = firstnum*secondnum;
                }else if (act == "/"){
                    res = firstnum/secondnum;
                }else{
                    res = 0;
                }
                result.setText(String.valueOf(res));
                break;
            case R.id.clear:
                firstnumber.setText("");
                secondnumber.setText("");
                result.setText("");
                break;
        }
    }
}