package edu.greenriver.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView_toDo;
    private EditText editText_add;
    private ArrayList<ItemView> itemList;
    private Button btn_add_toDo;
    private Button btn_complete;
    private Button btn_addSelected;
    private Intent intent;
    private int count;

    private ToDoAdapter toDoAdapter;
    private final String REFERENCE_COMPLETE_ITEMS = "completed";
    private final String REFERENCE_COMPLETE_ITEMS_SET = "complete set";
    ArrayList<String> complete_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        addToDoList();
        removeItem(toDoAdapter);
        goToCompleteList();
        listSelect();
        saveCompleted();
    }

    private void listSelect(){
        listView_toDo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (complete_list.contains(toDoAdapter.getItem(i))){
                    complete_list.remove(toDoAdapter.getItem(i));
                }
                count++;
                view.setBackgroundColor(Color.YELLOW);
                ItemView itemView = toDoAdapter.getItem(i);
                String item = itemView.getItem();
                complete_list.add(item);
                btn_addSelected.setText("Add Selected (" + count+ ")");
            }
        });
    }

    private void saveCompleted(){
        btn_addSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to add selected items?");
                builder.setTitle("Complete Items (" + count + ")");
                builder.setCancelable(true);
                
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

                });

                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

        });
    }

    private void goToCompleteList(){
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CompleteList.class);
                intent.putExtra("complete list", complete_list);
                startActivity(intent);
            }
        });

    }

    private void removeItem(ToDoAdapter adapter){
        listView_toDo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ItemView itemRemoved = adapter.getItem(i);
                adapter.remove(itemRemoved);
                return true;
            }
        });
    }



    private void addToDoList() {

        btn_add_toDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentItem = editText_add.getText().toString();

                if (!currentItem.isEmpty()){
                    itemList.add(new ItemView(currentItem));
                    toDoAdapter.notifyDataSetChanged();
                    editText_add.setText("");
                }
            }
        });
    }

    private void initialize(){
        intent = new Intent(MainActivity.this, CompleteList.class);
        count = 0;
        complete_list = new ArrayList<>();
        editText_add = findViewById(R.id.editTextListItem);
        btn_addSelected = findViewById(R.id.buttonAddSelected);
        btn_add_toDo = findViewById(R.id.buttonAdd);
        btn_complete = findViewById(R.id.buttonCompleteTasks);
        listView_toDo = findViewById(R.id.listToDo);
        itemList = new ArrayList<ItemView>();
        toDoAdapter = new ToDoAdapter(this, itemList);
        listView_toDo.setAdapter(toDoAdapter);

    }


}