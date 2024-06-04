package TestNG_March.Maven_Project_5282024;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class MyTestNGExample {

	@BeforeClass
	public void inaugration() {
		System.out.println("Run All Methods");
	}
	@AfterClass
	public void complete() {
		System.out.println(" All testing completed");
	}
	
	@BeforeMethod
	public void openBrowser() {
		System.out.println("opening the browser");
	}
	@Test(invocationCount=3)
	public void testSomething() {
		System.out.println("testing something");
	}
	@Ignore
	@Test //(priority=1)
	public void testanything() {
		System.out.println("Testing anything");
	}
	@Test(enabled=false)
	public void testwatever() {
		System.out.println("Testing anything");
	}
	@AfterMethod
	public void closeBrowser() {
		System.out.println("closing browser");
	}
	
}
