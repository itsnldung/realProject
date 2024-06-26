package de.dung.realproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerciseLogbookRecycleViewAdapter extends RecyclerView.Adapter
        <ExerciseLogbookRecycleViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Exercise> exerciseList;

    public ExerciseLogbookRecycleViewAdapter(Context context, ArrayList<Exercise> exerciseList){
        this.context = context;
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public ExerciseLogbookRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout here (giving the layout to the rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exercise_recycle_item_view,parent);

        return new ExerciseLogbookRecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseLogbookRecycleViewAdapter.MyViewHolder holder, int position) {
        //assigning values to the views created in the recycle_item_view (row view) based on
        //position of recycle view

        holder.exerciseName.setText(exerciseList.get(position).getName());  // accessing the holder attribute "exerciseName" we set below
        holder.sets.setText(exerciseList.get(position).getSets());
        holder.reps.setText(exerciseList.get(position).getReps());
        holder.rpe.setText(exerciseList.get(position).getRpe());


    }

    @Override
    public int getItemCount() {
        // recycle view just wants to know the size if the list
        return exerciseList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        // get the views from the recycle_item_view (row layout)
        // similar to onCreate Method

        TextView exerciseName;
        EditText reps, sets,rpe;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            exerciseName = itemView.findViewById(R.id.exercise_name);
            reps = itemView.findViewById(R.id.reps_number);
            sets = itemView.findViewById(R.id.sets_number);
            rpe = itemView.findViewById(R.id.rpe_percent);

        }
    }
}


