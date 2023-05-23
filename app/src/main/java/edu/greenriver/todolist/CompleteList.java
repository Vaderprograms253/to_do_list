package edu.greenriver.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class CompleteList extends AppCompatActivity {

    private TextView textView_complete;
    private ListView listView_complete;

    private ArrayList<String> completeList;
    private ArrayList<String> testList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_list);
        initialize();

        Intent intent = getIntent();
        completeList =(ArrayList<String>) getIntent().getSerializableExtra("complete list");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, completeList);
        listView_complete.setAdapter(adapter);
    }

    private void initialize(){
        textView_complete = findViewById(R.id.textViewComplete);
        listView_complete = findViewById(R.id.listViewCompleted);
        testList = new ArrayList<>();
        testList.add("Test");
        testList.add("Testing");
    }
}