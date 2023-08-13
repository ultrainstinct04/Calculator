package com.ankidroid.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button AC,erase,off,divide,multiply,subtract,add,point,equals,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,btn_00;

    TextView result;

    double x1= 0.0F;
//    char ch;

    int count= 0;
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result.append("1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result.append("2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("9");
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("0");
            }
        });

        btn_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("00");
            }
        });

        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1 = 0;
                result.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1 = calculate(s);
                s = "+";
                //x1 += Integer.parseInt(result.getText().toString());
                result.setText("");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1 = calculate(s);
                s = "-";
                result.setText("");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1 = calculate(s);
                s = "*";
                result.setText("");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1 = calculate(s);
                s = "/";
                result.setText("");
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.onBackPressed();
                //finish();
            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st;
                st = result.getText().toString();
                st = st.substring(0,st.length()-1);
                result.setText(st);
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!result.getText().toString().contains(".")) {
                    result.append(".");
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1 = calculate(s);
                String z = String.valueOf(x1);
                if(z.charAt(z.length()-1) == '0'){
                    int b = (int)x1;
                    result.setText(Integer.toString(b));
                }
                else
                result.setText(Double.toString(x1));
                x1 = 0;
                s = "";
            }
        });

    }
    public void init(){
        AC=findViewById(R.id.AC);
        erase=findViewById(R.id.erase);
        off=findViewById(R.id.off);
        divide=findViewById(R.id.divide);
        multiply=findViewById(R.id.multiply);
        subtract=findViewById(R.id.subtract);
        add=findViewById(R.id.add);
        point=findViewById(R.id.point);
        equals=findViewById(R.id.equals);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);
        btn_0=findViewById(R.id.btn_0);
        btn_00=findViewById(R.id.btn_00);

        result = findViewById(R.id.Result);
    }

    public double calculate(String c){

        switch(c){
            case "":
                x1 = Double.parseDouble(result.getText().toString());
                return x1;

            case "+":
                return x1 + Double.parseDouble(result.getText().toString());

            case "-":
                return x1 - Double.parseDouble(result.getText().toString());

            case "*":
                double d = x1 * Double.parseDouble(result.getText().toString());
                d = d*Math.pow(10,5);
                d = Math.floor(d);
                d = d/Math.pow(10,5);
                return d;

            case "/":
                double di = x1 / Double.parseDouble(result.getText().toString());
                di = di*Math.pow(10,5);
                di = Math.floor(di);
                di = di/Math.pow(10,5);
                return di;
        }
        return 0;
    }
}