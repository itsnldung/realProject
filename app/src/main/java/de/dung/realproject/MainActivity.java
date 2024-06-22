package de.dung.realproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*CharSequence[] options = new CharSequence[]{"Bike", "Running"};

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Workouts")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();*/

        Button logBook = findViewById(R.id.logBook);
        logBook.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LogbookActivity.class);
            startActivity(intent);
        });

        Button quickStart = findViewById(R.id.quickStart);
        quickStart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TrainingActivity.class);
            startActivity(intent);
        });
    }
}