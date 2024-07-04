package de.dung.realproject;

import android.os.Bundle;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PushDayActivity extends ExerciseRecycleView {
    private final String[] exercisesArray = {"Incline bench press", "Banded pushup", "Dips","Shoulder barbell press",
            "Side raise",
            "Overhead triceps extension", "Triceps extension", "Single hand triceps extension",
            "Skull crusher"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_day);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pushDay_recycleView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.pushDay_recycleView);
        ArrayList<Exercise> exercisesList = new ArrayList<>();
        setUpExerciseList(exercisesList, exercisesArray);
        setUpRecycleView(exercisesList, recyclerView);
    }
}
