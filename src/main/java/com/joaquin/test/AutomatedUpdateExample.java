package com.joaquin.test;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomatedUpdateExample {
	
	public static final String TESTLINK_KEY="5edfe6811de33ab8f8db475169bcdb4b";
	public static final String TESTLINK_URL="http://localhost/testlink-1.9.19/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME="SimpleTestLinkProject";//"TratamientoDisputa01";
	public static final String TEST_PLAN_NAME="TestingPlan";//"AutomationTestPlan";
	public static final String TEST_CASE_NAME="testcaseGoogle";//"ValidTest";
	public static final String BUILD_NAME="build2";//"Sprint1Build";

	String notes = null;
	String result = null;
	
	@Test
	public void Test1() throws Exception

	{
		System.setProperty("webdriver.gecko.driver", "C:\\\\DriverFirefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String result = "";

		try {

		    driver.get("http://www.google.com");
		    driver.findElement(By.name("q")).click();
		    driver.findElement(By.name("q")).sendKeys("abreviatura");
		    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			try {
			      Thread.sleep(5000);
			    } catch (InterruptedException e) {
			      e.printStackTrace();
			    }
		    {
		      WebElement element = driver.findElement(By.tagName("body"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element, 0, 0).perform();
		    }
			try {
			      Thread.sleep(5000);
			    } catch (InterruptedException e) {
			      e.printStackTrace();
			    }
			//updateResults(TEST_CASE_NAME, null, result);
			
			
			//result = TestLinkAPIResults.TEST_PASSED;
			
			//notes= getOSBrowserDetails();
			System.out.println("Executed successfully");
		}

		catch (Exception e) {
			//result = TestLinkAPIResults.TEST_FAILED;
			System.out.println("Executed failed");
		}

		finally {
			driver.quit();
			System.out.println("Executed quit");
			//TestLinkIntegration.reportResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, TEST_CASE_NAME, BUILD_NAME, notes, result);
		}

	}
	/*
	public void updateResults(String testCaseName,String exception,String result) throws TestLinkAPIException {
		System.out.println("updateResults");
		TestLinkAPIClient testLink= new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		try {
			testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception,result);
		} catch (TestLinkAPIException e) {
			System.out.println(e);
		}
		
		//testLink.reportTestCaseResult(testPlanID, testCaseID, buildID, execNotes, testResultStatus)
		//testLink.reportTestCaseResult(4,1, 2, exception, result);
	}*/

}
