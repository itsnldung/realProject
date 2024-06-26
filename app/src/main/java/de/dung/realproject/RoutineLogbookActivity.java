package de.dung.realproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RoutineLogbookActivity extends AppCompatActivity {

    List<String> str;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routine_logbook_layout);

        str = new ArrayList<>();
        str.add("Leg day");
        str.add("Push day");
        str.add("Pull day");
        str.add("Flex day");

        listView = findViewById(R.id.logbook);

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.list_item_view, R.id.textView, str);

        listView.setAdapter(adapter);
        listView.setClickable(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    Intent intent = new Intent
                            (RoutineLogbookActivity.this, ExerciseLogbookActivity.class);
                    startActivity(intent);
                }
            }
        });



    }
}


