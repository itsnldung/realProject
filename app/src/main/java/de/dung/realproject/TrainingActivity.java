package de.dung.realproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class TrainingActivity extends AppCompatActivity {
     private int setNumber = 0;
    private int repNumber =0;
    private int weight =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_layout);




        EditText repsNumber = findViewById(R.id.repsNumber);
        ImageButton minusRepButton =  findViewById(R.id.minusRepButton);
        ImageButton plusRepButton = findViewById(R.id.plusRepButton);

        TextView setsNumber = findViewById(R.id.setsNumber);
        ImageButton minusSetButton = findViewById(R.id.minusSetButton);
        ImageButton plusSetButton = findViewById(R.id.plusSetButton);

        TextView weightNumber = findViewById(R.id.weightNumber);


        minusRepButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(repNumber > 0){
                    repNumber--;
                }
                repsNumber.setText(String.valueOf(repNumber));
            }
        });
        plusRepButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repNumber++;
                repsNumber.setText(String.valueOf(repNumber));
            }
        });

        minusSetButton.setOnClickListener(v -> {
            if(setNumber >0){
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

    }

}
