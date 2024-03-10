package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ToDoViewHolder> {

    List<Todo> mTodos;
    public static class ToDoViewHolder extends RecyclerView.ViewHolder{
        public ToDoViewHolder(View itemView) {
            super(itemView);
        }
    }

    public TodoAdapter(List<Todo> todos) {
        mTodos = todos;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        View itemview = holder.itemView;
        TextView titleTextView = itemview.findViewById(R.id.todoTitle);
        String title = mTodos.get(position).title;
        titleTextView.setText(title);
        CheckBox cb = itemview.findViewById(R.id.checkBox);
        boolean isChecked = mTodos.get(position).isChecked;
        cb.setChecked(isChecked);
    }

    @Override
    public int getItemCount() {
        return mTodos.size();
    }
}
