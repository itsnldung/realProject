package de.dung.realproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class TrainingActivity extends AppCompatActivity {
    private int setNumber = 0;
    private int repNumber = 0;
    private double weight = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_layout);


        EditText repsNumber = findViewById(R.id.repsNumber);
        ImageButton minusRepButton = findViewById(R.id.minusRepButton);
        ImageButton plusRepButton = findViewById(R.id.plusRepButton);

        EditText setsNumber = findViewById(R.id.setsNumber);
        ImageButton minusSetButton = findViewById(R.id.minusSetButton);
        ImageButton plusSetButton = findViewById(R.id.plusSetButton);

        EditText weightNumber = findViewById(R.id.weightNumber);
        Button button25 = findViewById(R.id.button25);
        Button button20 = findViewById(R.id.button20);
        Button button15 = findViewById(R.id.button15);
        Button button10 = findViewById(R.id.button10);
        Button button5 = findViewById(R.id.button5);
        Button button2_5 = findViewById(R.id.button2_5);


        minusRepButton.setOnClickListener(v -> {
            if (repNumber > 0) {
                repNumber--;
            }
            repsNumber.setText(String.valueOf(repNumber));
        });
        plusRepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repNumber++;
                repsNumber.setText(String.valueOf(repNumber));
            }
        });

        minusSetButton.setOnClickListener(v -> {
            if (setNumber > 0) {
                setNumber--;
            }
            setsNumber.setText(String.valueOf(setNumber));
        });
        plusSetButton.setOnClickListener(v -> {
            setNumber++;
            setsNumber.setText(String.valueOf(setNumber));
        });

        repsNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                repNumber = Integer.parseInt(s.toString());
            }
        });

        setsNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setNumber = Integer.parseInt(s.toString());
            }
        });
        weightNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                weight = Double.parseDouble(editable.toString());
            }
        });
        button25.setOnClickListener(new CustomClickListener() {
            @Override
            public void OnDoubleClick(View v) {
                if (weight - 25 * 2 >= 0) {
                    weight -= 25 * 2;
                } else {
                    weight = 0;
                }
                weightNumber.setText(String.valueOf(weight));
            }

            @Override
            public void OnSingleClick(View v) {
                weight += 25;
                weightNumber.setText(String.valueOf(weight));
            }
        });
        button20.setOnClickListener(new CustomClickListener() {
            @Override
            public void OnDoubleClick(View v) {
                if (weight - 20 * 2 >= 0) {
                    weight -= 20 * 2;
                } else {
                    weight = 0;
                }
                weightNumber.setText(String.valueOf(weight));
            }

            @Override
            public void OnSingleClick(View v) {
                weight += 20;
                weightNumber.setText(String.valueOf(weight));
            }
        });
        button15.setOnClickListener(new CustomClickListener() {
            @Override
            public void OnDoubleClick(View v) {
                if (weight - 15 * 2 >= 0) {
                    weight -= 15 * 2;
                } else {
                    weight = 0;
                }
                weightNumber.setText(String.valueOf(weight));
            }

            @Override
            public void OnSingleClick(View v) {
                weight += 15;
                weightNumber.setText(String.valueOf(weight));
            }
        });
        button10.setOnClickListener(new CustomClickListener() {
            @Override
            public void OnDoubleClick(View v) {
                if (weight - 10 * 2 >= 0) {
                    weight -= 10 * 2;
                } else {
                    weight = 0;
                }
                weightNumber.setText(String.valueOf(weight));
            }

            @Override
            public void OnSingleClick(View v) {
                weight += 10;
                weightNumber.setText(String.valueOf(weight));
            }
        });
        button5.setOnClickListener(new CustomClickListener() {
            @Override
            public void OnDoubleClick(View v) {
                if (weight - 5 * 2 >= 0) {
                    weight -= 5 * 2;
                } else {
                    weight = 0;
                }
                weightNumber.setText(String.valueOf(weight));
            }

            @Override
            public void OnSingleClick(View v) {
                weight += 5;
                weightNumber.setText(String.valueOf(weight));
            }
        });
        button2_5.setOnClickListener(new CustomClickListener() {
            @Override
            public void OnDoubleClick(View v) {
                if (weight - 2.5 * 2 >= 0) {
                    weight -= 2.5 * 2;
                } else {
                    weight = 0;
                }
                weightNumber.setText(String.valueOf(weight));
            }

            @Override
            public void OnSingleClick(View v) {
                weight += 2.5;
                weightNumber.setText(String.valueOf(weight));
            }
        });
    }
}
