package de.dung.realproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerciseLogbookActivity extends AppCompatActivity {
    private ArrayList<Exercise> exerciseList;
    private String[] exerciseNamesArray_pushDay = {"Incline bench press", "Banded pushups", "Dips",
            "Overhead triceps extension", "Triceps extension", "Single hand triceps extension",
    "Skull crusher"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise_logbook);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.exercise_logbook_recyclerView);
        setUpExercise();
        ExerciseLogbookRecycleViewAdapter adapter = new ExerciseLogbookRecycleViewAdapter(this,exerciseList);
        recyclerView.setAdapter(adapter);

    }

    private void setUpExercise(){
        exerciseList = new ArrayList<>();
        for (String s : exerciseNamesArray_pushDay) {
            exerciseList.add(new Exercise(s));
        }
    }
}