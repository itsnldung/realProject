package de.dung.realproject;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LegDayActivity extends ExerciseRecycleView {
    String activityName = "Leg Day";

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leg_day);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.legDay_constraint_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /*  TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(getActivityName());
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Disable default title
        }*/

        getSupportActionBar().setTitle(getActivityName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });

        String[] exerciseArray = {"Squat", "Leg extension", "Hamstring leg curl", "Single leg deadlift"
                , "Bulgarian split squat", "Hip thrust", "Pistol squat", "Hanging leg raise", "Cable crunch", "Abs rollout"};
        ArrayList<Exercise> exercisesList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.legDay_recycleView);
        setUpExerciseList(exercisesList, exerciseArray);
        setUpRecycleView(exercisesList, recyclerView, "legDay");
    }
}