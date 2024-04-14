package com.testcoverage;

import java.util.ArrayList;
import java.util.List;

public class TaskManager_Mutant {
	private List<Task> tasks;

	public TaskManager_Mutant() {
		this.tasks = new ArrayList<>();
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void displayTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks found.");
			return;
		}
		System.out.println("Tasks:");
		for (Task task : tasks) {
			System.out.println(task);
		}
	}

	public void editTask(int index, Task updatedTask) {
		if (index >= 0 && index < tasks.size()) {
			var count = tasks.size();
			//tasks.set(index, updatedTask);
			if (count <= tasks.size()) {
				System.out.println("Task updated successfully.");
			} else {
				System.out.println("Invalid task index.");
			}
		} else {
			System.out.println("Invalid task index.");
		}
	}

	public void deleteTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			int count = tasks.size();
			tasks.remove(index);
			if (count > tasks.size()) {
				System.out.println("Task deleted successfully.");
			} else {
				System.out.println("Invalid task index.");
			}
			
		} else {
			System.out.println("Invalid task index.");
		}
	}

	public void markTaskAsComplete(int index) {
		if (index >= 0 && index < tasks.size()) {
			Task task = tasks.get(index);
			task.setCompleted(true);
			tasks.set(index, task);
			System.out.println("Task marked as complete.");
		} else {
			System.out.println("Invalid task index.");
		}
	}
}