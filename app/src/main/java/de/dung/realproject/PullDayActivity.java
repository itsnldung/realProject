package de.dung.realproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PullDayActivity extends ExerciseRecycleView {
    private String activityName = "Pull Day";

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
        setContentView(R.layout.activity_pull_day);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pullDay_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(activityName);

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

        String[] exerciseArray = {"Deadlift", "Lat pull down", "Pull up", "Cable row", "Meadows row", "Incline dumbbell curl",
                "Cable curl", "Overhand barbell curl"};
        ArrayList<Exercise> exerciseList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.pullDay_recycleView);
        setUpExerciseList(exerciseList, exerciseArray);
        setUpRecycleView(exerciseList, recyclerView, "pullDay");
    }
}