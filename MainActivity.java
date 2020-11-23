package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    Button btn_add, btn_subtract, btn_multiply, btn_divide;
    Button btn_clear, btn_decimal, btn_equals;

    TextView resultView;

    Double firstVal = 0.0;
    Double secondVal = 0.0;

    enum Operation {
        NONE,
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    Operation currentOperation = Operation.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise all the views
        initViews();
    }

    private void initViews() {

        btn_0 = findViewById(R.id.num_0);
        btn_1 = findViewById(R.id.num_1);
        btn_2 = findViewById(R.id.num_2);
        btn_3 = findViewById(R.id.num_3);
        btn_4 = findViewById(R.id.num_4);
        btn_5 = findViewById(R.id.num_5);
        btn_6 = findViewById(R.id.num_6);
        btn_7 = findViewById(R.id.num_7);
        btn_8 = findViewById(R.id.num_8);
        btn_9 = findViewById(R.id.num_9);
        btn_add = findViewById(R.id.add);
        btn_subtract = findViewById(R.id.minus);
        btn_multiply = findViewById(R.id.multiply);
        btn_divide = findViewById(R.id.divide);
        btn_clear = findViewById(R.id.clear);
        btn_decimal = findViewById(R.id.dot);
        btn_equals = findViewById(R.id.equals);
        resultView = findViewById(R.id.resultView);

        // set click listener on buttons
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_equals.setOnClickListener(this);
        btn_decimal.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String currentText = resultView.getText().toString();

        switch (v.getId()) {
            case R.id.num_0:
                resultView.setText(currentText + "0");
                break;
            case R.id.num_1:
                resultView.setText(currentText + "1");
                break;
            case R.id.num_2:
                resultView.setText(currentText + "2");
                break;
            case R.id.num_3:
                resultView.setText(currentText + "3");
                break;
            case R.id.num_4:
                resultView.setText(currentText + "4");
                break;
            case R.id.num_5:
                resultView.setText(currentText + "5");
                break;
            case R.id.num_6:
                resultView.setText(currentText + "6");
                break;
            case R.id.num_7:
                resultView.setText(currentText + "7");
                break;
            case R.id.num_8:
                resultView.setText(currentText + "8");
                break;
            case R.id.num_9:
                resultView.setText(currentText + "9");
                break;
            case R.id.add:
                if (!currentText.equals("")) {
                    if (currentOperation == Operation.NONE) {
                        currentOperation = Operation.ADD;
                        firstVal = Double.parseDouble(currentText);
                        resultView.setText("");
                    } else {
                        secondVal = Double.parseDouble(currentText);

                        resultView.setText("");
                        firstVal = performOperation();
                        currentOperation = Operation.ADD;
                    }
                }
                break;
            case R.id.minus:
                if (!currentText.equals("")) {
                    if (currentOperation == Operation.NONE) {
                        currentOperation = Operation.SUBTRACT;
                        firstVal = Double.parseDouble(currentText);
                        resultView.setText("");
                    } else {
                        secondVal = Double.parseDouble(currentText);

                        resultView.setText("");
                        firstVal = performOperation();
                        currentOperation = Operation.SUBTRACT;
                    }
                }
                break;
            case R.id.multiply:
                if (!currentText.equals("")) {
                    if (currentOperation == Operation.NONE) {
                        currentOperation = Operation.MULTIPLY;
                        firstVal = Double.parseDouble(currentText);
                        resultView.setText("");
                    } else {
                        secondVal = Double.parseDouble(currentText);

                        resultView.setText("");
                        firstVal = performOperation();
                        currentOperation = Operation.MULTIPLY;
                    }
                }
                break;
            case R.id.divide:
                if (!currentText.equals("")) {
                    if (currentOperation == Operation.NONE) {
                        currentOperation = Operation.DIVIDE;
                        firstVal = Double.parseDouble(currentText);
                        resultView.setText("");
                    } else {
                        secondVal = Double.parseDouble(currentText);

                        resultView.setText("");
                        firstVal = performOperation();
                        currentOperation = Operation.DIVIDE;
                    }
                }
                break;
            case R.id.clear:
                resultView.setText("");
                firstVal = 0.0;
                secondVal = 0.0;
                currentOperation = Operation.NONE;
                break;
            case R.id.equals:

                // setting second value
                if (!currentText.equals("")) {
                    if (firstVal != 0.0) {
                        secondVal = Double.parseDouble(currentText);
                    }
                }

                if (firstVal != 0.0 && secondVal != 0.0) {

                    resultView.setText("" + performOperation());

                    firstVal = 0.0;
                    secondVal = 0.0;
                    currentOperation = Operation.NONE;
                } else if (firstVal != 0.0) {
                    resultView.setText("" + firstVal);
                    firstVal = 0.0;
                    currentOperation = Operation.NONE;
                }
                break;
            case R.id.dot:
                if (!currentText.contains(".")) {
                    resultView.setText(currentText + ".");
                }
                break;
            default:
                break;
        }
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        return a / b;
    }

    private double performOperation() {
        switch (currentOperation) {
            case ADD:
                return add(firstVal, secondVal);
            case SUBTRACT:
                return subtract(firstVal, secondVal);
            case MULTIPLY:
                return multiply(firstVal, secondVal);
            case DIVIDE:
                return divide(firstVal, secondVal);
        }
        return 0.0;
    }
}