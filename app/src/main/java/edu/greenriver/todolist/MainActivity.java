package edu.greenriver.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView_toDo;
    private ListView listView_completed;
    private EditText editText_add;
    private ArrayList<String> addList;
    private ArrayAdapter<String> adapter;
    private ArrayList<ItemView> itemList;
    private Button btn_add_toDo;

    private ToDoAdapter toDoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        addToList();
    }


    private void addToList() {
        btn_add_toDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentItem = editText_add.getText().toString();

                if (!currentItem.isEmpty()){
                    itemList.add(new ItemView(currentItem));
                    toDoAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void initialize(){
        editText_add = findViewById(R.id.editTextListItem);
        btn_add_toDo = findViewById(R.id.buttonAdd);
        listView_toDo = findViewById(R.id.listToDo);
        listView_completed = findViewById(R.id.listCompleted);
        itemList = new ArrayList<ItemView>();
        addList = new ArrayList<>();
        //adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, addList);
        toDoAdapter = new ToDoAdapter(this, itemList);
        listView_toDo.setAdapter(toDoAdapter);

    }


}