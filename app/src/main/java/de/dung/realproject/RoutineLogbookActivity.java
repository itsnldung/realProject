package de.dung.realproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RoutineLogbookActivity extends AppCompatActivity {

    List<ListItem> list;
    ListView listView;

    public static class ListItem {
        String name;
        Class<? extends AppCompatActivity> activity;

        public ListItem(String name, Class<? extends AppCompatActivity> activity) {
            this.name = name;
            this.activity = activity;
        }

        @NonNull
        @Override
        public String toString() {
            return name;
        }
    }
    private String activityName = "Logbook";

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.routine_logbook_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(getActivityName());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Disable default title
        }*/
        getSupportActionBar().setTitle(getActivityName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());


        list = new ArrayList<>();
        list.add(new ListItem("Leg day", LegDayActivity.class));
        list.add(new ListItem("Push day", PushDayActivity.class));
        list.add(new ListItem("Pull day", PullDayActivity.class));
        list.add(new ListItem("Flex day", FlexDayActivity.class));

        listView = findViewById(R.id.logBook_listView);

        ArrayAdapter<ListItem> adapter = new ArrayAdapter<>(this, R.layout.list_item_view, R.id.textView, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(RoutineLogbookActivity.this, list.get(position).activity);
                startActivity(intent);
            }
        });
    }
}


