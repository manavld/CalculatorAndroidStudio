package com.example.manav.calculatorandroidstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private String num = ""; // Aixo es el numero actual (el "model")
    private TextView numview;
    private String numcopy = "";
    private String operator = "";
    private double result = 0;
    private boolean end = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numview = findViewById(R.id.curr_num);
        numview.setText(num);
    }

    public void onClickDigit(View view) {
        if(end == true){
            numcopy = "";
            operator = "";
            result = 0;
            num = "";
            Button b = (Button)view;
            num += b.getText().toString().charAt(0);
            numview.setText(num);
            end = false;
        }
        else {
            Button b = (Button) view;
            num += b.getText().toString().charAt(0);
            numview.setText(num);
            end = false;
        }
    }

    //onClickOperator -> memoria numero anterior, memoria operador actual fins que apliques "="
    public void onClickOperator(View view){
        Button b = (Button)view;
        numview.setText("");
        numcopy = num;
        num = "";
        operator = b.getText().toString();
        end = false;
    }

    //onClickEquals
    public void onClickEquals(View view){
        if (operator.equals("+")){
            result = Double.parseDouble(numcopy) + Double.parseDouble(num);
        }
        if (operator.equals("-")){
            result = Double.parseDouble(numcopy) - Double.parseDouble(num);
        }
        if (operator.equals("*")){
            result = Double.parseDouble(numcopy) * Double.parseDouble(num);
        }
        if (operator.equals("/")){
            result = Double.parseDouble(numcopy) / Double.parseDouble(num);
        }

        num = String.valueOf(result);
        numview.setText(num);
        end = true;
    }

    //onClickDot
    public void onClickDot(View view){
        while (!num.contains(".")){
            num += ".";
        }
        end = false;
    }
}
