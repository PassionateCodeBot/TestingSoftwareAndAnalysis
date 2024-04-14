package com.testpackage;

import org.testng.annotations.Test;
import com.testcoverage.TaskManager;

public class TestScript {

	@Test
	public void Test() {
		TaskManager testObj = new TaskManager();
		
		testObj.displayTasks();
	}

}
