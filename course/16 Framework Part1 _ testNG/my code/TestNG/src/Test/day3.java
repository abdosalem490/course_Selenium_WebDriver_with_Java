package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("before executing any method in the class");
	}

	@AfterClass
	public void afterClass()
	{
		System.out.println("after executing all method in the class");
	}
	
	@Test(enabled = false)
	public void webLoginCarLoan()
	{
		//selenium
		System.out.println("weblogincar");
	}
	
	@Test
	public void MobileLoginCarLoan()
	{
		//Appium
		System.out.println("Mobilelogincar");
	}
	
	@Test(timeOut = 40000) // 40 seconds
	public void MobileSignInCarLoan()
	{
		//Appium
		System.out.println("Mobile SIGN IN");
	}
	
	@Test(dependsOnMethods = {"MobileSignInCarLoan", "MobileSignInCarLoan"})
	public void MobileSignOutCarLoan()
	{
		//Appium
		System.out.println("Mobile SIGN OUT");
	}
	
	@BeforeMethod
	public void beforeEvery()
	{
		System.out.println("before very method");
	}
	
	@AfterMethod
	public void afterEvery()
	{
		System.out.println("I will execute after every method");
	}
	
	@BeforeSuite
	public void Bfsuite()
	{
		System.out.println("I am no 1");
	}
	
	@AfterSuite
	public void afsyite()
	{
		System.out.println("I am the no 1 from the last");
	}
	
	@Test(groups = {"Smoke"})
	public void loginAPICarLoan()
	{
		// Rest API automation
		System.out.println("APIlogincar");
	}
	
	@Parameters(("URL"))
	@Test
	public void paramsTest(String URL)
	{
		System.out.println(URL);
	}
	
	@DataProvider
	@Test
	public Object[][] getData()
	{
		// 1st combination - username password - good credit history
		
		// 2nd - username password - no credit history
		
		// 3rd - fraudelent credit history
		
		Object[][] data = new Object[3][2];
		
		// 1st set
		data[0][0] = "first set username";
		data[0][1] = "password";
		// columns in the row are nothing but values for that particular combination (row)
		
		// 2nd set
		data[1][0] = "second set username";
		data[1][1] = "second password";
		
		//3rd set
		data[2][0] = "third set username";
		data[2][1] = "third password";
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void printDataProvided(String username, String password)
	{
		System.out.println("username = " + username + ", password = " + password);
	}

}
