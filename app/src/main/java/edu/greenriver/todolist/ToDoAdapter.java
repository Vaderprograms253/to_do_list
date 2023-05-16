package edu.greenriver.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ToDoAdapter extends ArrayAdapter<ItemView> {

    public ToDoAdapter(Context context, ArrayList<ItemView> itemList){
        super(context, 0, itemList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View current = convertView;

        if (current == null){
            current = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
        }

        ItemView currentItem = getItem(position);

        TextView textView = current.findViewById(R.id.textViewList);
        textView.setText(currentItem.getItem());

        return current;

    }
}
