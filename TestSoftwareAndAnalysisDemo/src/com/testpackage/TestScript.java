package com.testpackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import com.testcoverage.Task;
import com.testcoverage.TaskManager;

public class TestScript {
		
	@Test
	public void test1WithEmptyList() {		
		TaskManager taskManager = new TaskManager();
		taskManager.displayTasks();
	}

	@Test
	public void test2WithValidList() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Task test", "description test", "2024/01/01", "Low");
		taskManager.addTask(task);
		taskManager.displayTasks();
	}

	@Test
	public void test3WithIndexLessThanZero() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Task test", "description test", "2024/01/01", "Low");
		taskManager.editTask(-1, task);
	}

	@Test
	public void test4WithIndexZero() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		Task taskUpdated = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.editTask(0, taskUpdated);
	}

	@Test
	public void test5WithUpdate() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");
		Task task2 = new Task("Task2", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		taskManager.addTask(task2);

		Task taskUpdated = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.editTask(2, taskUpdated);
	}

	@Test
	public void test6WithIndexLessThanZeroCompleteTask() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		taskManager.markTaskAsComplete(-1);
	}

	@Test
	public void test7WithIndexZeroCompleteTask() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		taskManager.markTaskAsComplete(0);
	}

	@Test
	public void test8WithValidInvalidCompleteTask() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");
		Task task2 = new Task("Task2", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		taskManager.addTask(task2);

		taskManager.markTaskAsComplete(2);
	}

	@Test
	public void test9WithIndexLessThanZeroDeleteTask() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		taskManager.deleteTask(-1);
	}

	@Test
	public void test10WithIndexZeroDeleteTask() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		taskManager.deleteTask(0);
	}

	@Test
	public void test11WithValidInvalidDeleteTask() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");
		Task task2 = new Task("Task2", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		taskManager.addTask(task2);

		taskManager.deleteTask(2);
	}
	
	@Test
	public void test12WithUpdateTitle() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		var description  = task1.getDescription();
		task1.setDescription(description);

		Task taskUpdated = new Task("Task test", description + "_new", "2024/10/10", "Low");
		taskManager.editTask(1, taskUpdated);
	}

	@Test
	public void test13WithUpdateTitle() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		var title = task1.getTitle();
		task1.setTitle(title);

		Task taskUpdated = new Task(title + "_new", "description test", "2024/10/10", "Low");
		taskManager.editTask(1, taskUpdated);
	}

	@Test
	public void test14WithUpdatePriority() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/05/05", "Low");

		taskManager.addTask(task1);
		var priority = task1.getPriority();
		task1.setPriority(priority);

		Task taskUpdated = new Task("Task1", "description test", "2024/05/05", priority + "_new");
		taskManager.editTask(1, taskUpdated);
	}

	@Test
	public void test15WithUpdateDueDate() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/05/05", "Low");

		taskManager.addTask(task1);
		var dueDate = task1.getDueDate();
		task1.setDueDate(dueDate);

		Task taskUpdated = new Task("Task test", "description updated", dueDate, "Low");
		taskManager.editTask(1, taskUpdated);
	}

	@Test
	public void test16WithUpdateCompleted() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");

		var result = task1.isCompleted();
		taskManager.addTask(task1);
		task1.setCompleted(result);
		taskManager.markTaskAsComplete(1);
	}
	
	@Test
	public void testToString1() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");
		taskManager.addTask(task1);
		taskManager.markTaskAsComplete(1);
		
		String str = task1.toString();
		
		assertNotEquals("Task{title = 'Task1', description = 'description test', dueDate='2024/10/10', priority = 'Low', completed = true }", str);
	}
	
	@Test
	public void testToString2() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");
		taskManager.addTask(task1);
		task1.setCompleted(false);
		String str = task1.toString();
		
		assertNotEquals("Task{title = 'Task1', description = 'description test', dueDate='2024/10/10', priority = 'Low', completed = true }", str);
	}
}
