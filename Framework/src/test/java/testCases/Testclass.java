package testCases;

import org.testng.annotations.Test;

import businessFunctions.ReusableFunctions;

public class Testclass extends ReusableFunctions { 
	
	
	
	public void method1() {
		System.out.println("inside method1");
		
	}
	
	@Test
	public void method2() {
		System.out.println("inside method2");
		
	}
	
	@Test
	public void method3() {
		System.out.println("inside method3");
		
	}

}
