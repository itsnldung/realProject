package de.dung.realproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExerciseRecycleViewAdapter extends RecyclerView.Adapter
        <ExerciseRecycleViewAdapter.MyViewHolder> {

    private final Context context;
    private final List<Exercise> exerciseList;
    private final SharedPreferences sharedPreferences;


    public ExerciseRecycleViewAdapter(Context context, List<Exercise> exerciseList, String key) {
        this.context = context;
        this.exerciseList = exerciseList;
        this.sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout here (giving the layout to the rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exercise_recycle_item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //assigning values to the views created in the recycle_item_view (row view) based on
        //position of recycle view
        final String SET_NUMBER_KEY = "SET_NUMBER_KEY" + position;
        final String REP_NUMBER_KEY = "REP_NUMBER_KEY" + position;
        final String RPE_NUMBER_KEY = "RPE_NUMBER_KEY" + position;


        final MutableInt setNumber = new MutableInt(Integer.parseInt(sharedPreferences.getString(SET_NUMBER_KEY, "0")));
        final MutableInt repNumber = new MutableInt(Integer.parseInt(sharedPreferences.getString(REP_NUMBER_KEY, "0")));
        final MutableInt rpeNumber = new MutableInt(Integer.parseInt(sharedPreferences.getString(RPE_NUMBER_KEY, "0")));

        holder.exerciseName.setText(exerciseList.get(position).getName());// accessing the holder attribute "exerciseName" we set below

        if (setNumber.value == 0) {
            holder.sets.setText("");
        } else {
            holder.sets.setText(sharedPreferences.getString(SET_NUMBER_KEY, ""));
        }
        if (repNumber.value == 0) {
            holder.reps.setText("");
        } else {
            holder.reps.setText(sharedPreferences.getString(REP_NUMBER_KEY, ""));
        }
        if (rpeNumber.value == 0) {
            holder.rpe.setText("");
        } else {
            holder.rpe.setText(sharedPreferences.getString(RPE_NUMBER_KEY, ""));
        }


        holder.sets.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    setNumber.value = Integer.parseInt(editable.toString());
                    sharedPreferences.edit().putString(SET_NUMBER_KEY, String.valueOf(setNumber.value)).apply();
                }

            }
        });
        holder.reps.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    repNumber.value = Integer.parseInt(editable.toString());
                    sharedPreferences.edit().putString(REP_NUMBER_KEY, String.valueOf(repNumber.value)).apply();
                }
            }
        });
        holder.rpe.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    rpeNumber.value = Integer.parseInt(editable.toString());
                    sharedPreferences.edit().putString(RPE_NUMBER_KEY, String.valueOf(rpeNumber.value)).apply();
                }
            }
        });

        holder.minus_set_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber.value = Math.max(0, setNumber.value - 1);
                holder.sets.setText(String.valueOf(setNumber.value));
            }
        });
        holder.plus_set_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber.value++;
                holder.sets.setText(String.valueOf(setNumber.value));
            }
        });
        holder.plus_rep_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repNumber.value++;
                holder.reps.setText(String.valueOf(repNumber.value));
            }
        });
        holder.minus_rep_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repNumber.value = Math.max(0, repNumber.value - 1);
                holder.reps.setText(String.valueOf(repNumber.value));
            }
        });
    }

    @Override
    public int getItemCount() {
        // recycle view just wants to know the size if the list
        return exerciseList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // get the views from the recycle_item_view (row layout)
        // similar to onCreate Method

        TextView exerciseName;
        EditText reps, sets, rpe;
        ImageView minus_set_button, plus_set_button, minus_rep_button, plus_rep_button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            exerciseName = itemView.findViewById(R.id.exercise_name);
            reps = itemView.findViewById(R.id.reps_number);
            sets = itemView.findViewById(R.id.sets_number);
            rpe = itemView.findViewById(R.id.rpe_percent);
            minus_set_button = itemView.findViewById(R.id.minus_set_button);
            plus_set_button = itemView.findViewById(R.id.plus_set_button);
            minus_rep_button = itemView.findViewById(R.id.minus_rep_button);
            plus_rep_button = itemView.findViewById(R.id.plus_rep_button);

        }
    }
}

abstract class SimpleTextWatcher implements TextWatcher {
    // shorten the 2 unnecessary methods below
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }
}

class MutableInt {
    // create a wrapper class for the Integers so that inner classes can access them
    int value;

    public MutableInt(int value) {
        this.value = value;
    }
}

