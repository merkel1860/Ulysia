package com.example.ulysia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextOperand_1;
    EditText editTextOperand_2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingControls();
        setUpButtons();
    }

    private void setUpButtons() {
        Button button = findViewById(R.id.addID);
        button.setOnClickListener(this);

        button = findViewById(R.id.divID);
        button.setOnClickListener(this);

        button = findViewById(R.id.subsID);
        button.setOnClickListener(this);

        button = findViewById(R.id.mulID);
        button.setOnClickListener(this);
    }

    private void bindingControls() {
        editTextOperand_1 = findViewById(R.id.oprand1ID);
        editTextOperand_2 = findViewById(R.id.operand2ID);
        textView = findViewById(R.id.resultID);
    }

    @Override
    public void onClick(View view) {
        Button button = findViewById(view.getId());
        float op1;
        float op2;
        op1 = getDecimalValue(editTextOperand_1.getText().toString());
        op2 = getDecimalValue(editTextOperand_2.getText().toString());
        switch (button.getId()) {
            case R.id.addID:
                textView.setText("Result = "+addOperation(op1, op2));
                break;
        }
    }

    private float getDecimalValue(String s) {
        if (!s.isEmpty()) {
            return Float.valueOf(s);
        }
        return 0;
    }

    private float addOperation(float op1, float op2) {
        return op1 + op2;
    }
}