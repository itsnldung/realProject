package de.dung.realproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class ExerciseRecycleView extends AppCompatActivity {

    protected void setUpExerciseList(ArrayList<Exercise> exerciseList, String[] exerciseArray) {
        for (String s : exerciseArray) {
            exerciseList.add(new Exercise(s));
        }
    }

    protected void setUpRecycleView(List<Exercise> exerciseList, RecyclerView recyclerView, String key) {
        ExerciseRecycleViewAdapter adapter = new ExerciseRecycleViewAdapter(this, exerciseList,key);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}

