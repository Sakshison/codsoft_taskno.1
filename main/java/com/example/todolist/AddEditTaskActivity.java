package com.example.todolist;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class AddEditTaskActivity extends AppCompatActivity {

    // AddEditTaskActivity.java

        private EditText titleEditText;
        private EditText descriptionEditText;
        private EditText priorityEditText;
        private EditText dueDateEditText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_edit_task);

            titleEditText = findViewById(R.id.editTextTitle);
            descriptionEditText = findViewById(R.id.editTextDescription);
            priorityEditText = findViewById(R.id.editTextPriority);
            dueDateEditText = findViewById(R.id.editTextDueDate);

            Button saveButton = findViewById(R.id.saveButton);
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("title", titleEditText.getText().toString());
                    resultIntent.putExtra("description", descriptionEditText.getText().toString());
                    resultIntent.putExtra("priority", Integer.parseInt(priorityEditText.getText().toString()));
                    resultIntent.putExtra("dueDate", dueDateEditText.getText().toString());
                    resultIntent.putExtra("isCompleted", false);

                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            });
        }
    }


