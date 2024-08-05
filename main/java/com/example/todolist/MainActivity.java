package com.example.todolist;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    // MainActivity.java

        private RecyclerView recyclerView;
        private TaskAdapter adapter;
        private List<task> taskList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            taskList = new ArrayList<>();
            adapter = new TaskAdapter(taskList);
            recyclerView.setAdapter(adapter);

            Button addTaskButton = findViewById(R.id.addTaskButton);
            addTaskButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AddEditTaskActivity.class);
                    startActivityForResult(intent, 1);
                }
            });
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1 && resultCode == RESULT_OK) {
                String title = data.getStringExtra("title");
                String description = data.getStringExtra("description");
                int priority = data.getIntExtra("priority", 0);
                String dueDate = data.getStringExtra("dueDate");
                boolean isCompleted = data.getBooleanExtra("isCompleted", false);

                task newTask = new task(title, description, priority, dueDate, isCompleted);
                taskList.add(newTask);
                adapter.notifyItemInserted(taskList.size() - 1);
            }
        }
    }


