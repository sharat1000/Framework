package testExecution;

import drivers.WebActions;

public class ExecutionSuite extends WebActions {

	public static void main(String[] args) throws Exception {	
		WebActions newWebActions1 = new WebActions();
		newWebActions1.executeTestSuite();
	}	
}