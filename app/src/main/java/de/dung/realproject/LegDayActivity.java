package de.dung.realproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LegDayActivity extends ExerciseRecycleView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leg_day);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.flexDay_constraint_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] exerciseArray = {"Squat", "Leg extension", "Hamstring leg curl", "Single leg deadlift"
                , "Bulgarian split squat", "Hip thrust", "Pistol squat", "Hanging leg raise", "Cable crunch", "Abs rollout"};
        ArrayList<Exercise> exercisesList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.legDay_recycleView);
        setUpExerciseList(exercisesList, exerciseArray);
        setUpRecycleView(exercisesList, recyclerView);
    }
}