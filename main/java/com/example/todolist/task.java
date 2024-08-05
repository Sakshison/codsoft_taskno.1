package com.example.todolist;

public class task {
    // Task.java
        private String title;
        private String description;
        private int priority;
        private String dueDate;
        private boolean isCompleted;

        public task(String title, String description, int priority, String dueDate, boolean isCompleted) {
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.dueDate = dueDate;
            this.isCompleted = isCompleted;
        }

        // Getters and setters for all fields
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public int getPriority() { return priority; }
        public void setPriority(int priority) { this.priority = priority; }

        public String getDueDate() { return dueDate; }
        public void setDueDate(String dueDate) { this.dueDate = dueDate; }

        public boolean isCompleted() { return isCompleted; }
        public void setCompleted(boolean completed) { isCompleted = completed; }
    }


