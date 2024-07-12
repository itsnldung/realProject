package de.dung.realproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PushDayActivity extends ExerciseRecycleView {

    private String activityName = "Push Day";

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_day);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pushDay_recycleView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /* TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(getActivityName());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Disable default title
        }
*/
        getSupportActionBar().setTitle(getActivityName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });

        String[] exercisesArray = {"Incline bench press", "Banded pushup", "Dips","Shoulder barbell press",
                "Side raise",
                "Overhead triceps extension", "Triceps extension", "Single hand triceps extension",
                "Skull crusher"};


        RecyclerView recyclerView = findViewById(R.id.pushDay_recycleView);
        ArrayList<Exercise> exercisesList = new ArrayList<>();
        setUpExerciseList(exercisesList, exercisesArray);
        setUpRecycleView(exercisesList, recyclerView,"pushDay");
    }
}
