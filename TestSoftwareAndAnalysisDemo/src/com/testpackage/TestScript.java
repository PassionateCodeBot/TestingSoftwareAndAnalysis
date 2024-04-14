package com.testpackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.testcoverage.Task;
import com.testcoverage.TaskManager;

public class TestScript {
		
	
	
	@Test
	public void test1WithEmptyList() {	
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));
		String expectedOutput = "No tasks found.";
		TaskManager taskManager = new TaskManager();
		taskManager.displayTasks();
		Assert.assertEquals(expectedOutput, outputStreamCaptor.toString()
      	      .trim());
	}

	@Test
	public void test2WithValidList() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task = new Task("Task test", "description test", "2024/01/01", "Low");
		 
		taskManager.addTask(task);
		String expectedOutput = ("Tasks:\r\n"
        		+ task.toString()).stripTrailing();
		taskManager.displayTasks();
		String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test3WithIndexLessThanZero() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task = new Task("Task test", "description test", "2024/01/01", "Low");
		taskManager.editTask(-1, task);
		String expectedOutput = "Invalid task index.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test4WithIndexZero() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		Task taskUpdated = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.editTask(0, taskUpdated);
		// check task updated
        String expectedOutput = "Task updated successfully.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test5WithUpdate() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");
		Task task2 = new Task("Task2", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		taskManager.addTask(task2);

		Task taskUpdated = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.editTask(2, taskUpdated);
		String expectedOutput = "Invalid task index.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test6WithIndexLessThanZeroCompleteTask() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		taskManager.markTaskAsComplete(-1);
		
		String expectedOutput = "Invalid task index.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test7WithIndexZeroCompleteTask() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		taskManager.markTaskAsComplete(0);
		
		String expectedOutput = "Task marked as complete.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test8WithValidInvalidCompleteTask() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");
		Task task2 = new Task("Task2", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		taskManager.addTask(task2);

		taskManager.markTaskAsComplete(2);
		
		String expectedOutput = "Invalid task index.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test9WithIndexLessThanZeroDeleteTask() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		taskManager.deleteTask(-1);
		String expectedOutput = "Invalid task index.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test10WithIndexZeroDeleteTask() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task = new Task("Task test", "description test", "2024/10/10", "Low");
		taskManager.addTask(task);

		taskManager.deleteTask(0);
		String expectedOutput = "Task deleted successfully.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void test11WithValidInvalidDeleteTask() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
	
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");
		Task task2 = new Task("Task2", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		taskManager.addTask(task2);

		taskManager.deleteTask(2);
		
		String expectedOutput = "Invalid task index.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void test12WithUpdateTitle() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		TaskManager taskManager = new TaskManager();
		System.setOut(new PrintStream(outputStreamCaptor));
		Task task1 = new Task("Task1", "description test", "2024/10/10", "Low");

		taskManager.addTask(task1);
		var description  = task1.getDescription();
		task1.setDescription(description);

		Task taskUpdated = new Task("Task test", description + "_new", "2024/10/10", "Low");
		taskManager.editTask(1, taskUpdated);
		String expectedOutput = "Invalid task index.";
        String actualOutput = outputStreamCaptor.toString().stripTrailing();
        Assert.assertEquals(expectedOutput, actualOutput);
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
