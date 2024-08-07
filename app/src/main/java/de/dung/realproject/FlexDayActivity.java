package de.dung.realproject;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlexDayActivity extends ExerciseRecycleView {
    String activityName = "Flex Day";

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
        setContentView(R.layout.activity_flex_day);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.flexDay_constraint_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getActivityName());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });


/*
        TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(getActivityName());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Disable default title
        }*/




        String[] exerciseArray = {"Incline bench press","Dips","Shoulder press","Side raises","Overhead triceps extension"
        ,"Triceps extension", "Single hand triceps extension", "Incline dumbbell curl","Cable curl", "Hanging leg raise",
        "Cable crunch","Abs roll-out", "Side crunch", "Plank"};
        ArrayList<Exercise> exerciseList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.flexDay_recycleView);
        setUpExerciseList(exerciseList,exerciseArray);
        setUpRecycleView(exerciseList,recyclerView, "flexDay");
    }
}