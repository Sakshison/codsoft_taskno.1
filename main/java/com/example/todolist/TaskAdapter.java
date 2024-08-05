package com.example.todolist;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

    public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
        private List<task> taskList;

        public static class TaskViewHolder extends RecyclerView.ViewHolder {
            public TextView title;
            public CheckBox completed;

            public TaskViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.taskTitle);
                completed = itemView.findViewById(R.id.taskCompleted);
            }
        }

        public TaskAdapter(List<task> taskList) {
            this.taskList = taskList;
        }

        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
            return new TaskViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
            task currentTask = taskList.get(position);
            holder.title.setText(currentTask.getTitle());
            holder.completed.setChecked(currentTask.isCompleted());
        }

        @Override
        public int getItemCount() {
            return taskList.size();
        }
    }

