package de.dung.realproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PullDayActivity extends ExerciseRecycleView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pull_day);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pullDay_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] exerciseArray = {"Deadlift", "Lat pull down", "Pull up", "Cable row", "Meadows row", "Incline dumbbell curl",
                "Cable curl", "Overhand-grip barbell curl"};
        ArrayList<Exercise> exerciseList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.pullDay_recycleView);
        setUpExerciseList(exerciseList, exerciseArray);
        setUpRecycleView(exerciseList, recyclerView);
    }
}