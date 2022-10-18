package datddriven;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeMethod
	public void UseridGeneration()
	{
		System.out.println("This block executes before each Test");
	}
	
	@Test(dataProvider="getData")
	public void Userid(String username,String password,String id)
	{
		System.out.println("This block executes before each Test");
		System.out.println(username);
		System.out.println(password);
		  System.out.println(id);
		
		
	}
	@BeforeTest
	public void Cookies()
	{
		System.out.println("This block executes Before all  Testcases");
		//delete cookies
	}
@AfterTest
public void Cookiesclose()
{
	System.out.println("This block executes after all  Testcases");
	//close the browesers
}
@AfterMethod
public void Reportadding()
{
	System.out.println("This block executes after each Test");
}
	//@Test
	public void OpeningBrowser()
	{
	//This opens the Browser
	System.out.println("Executing Test 2");

}
//@Test
public void FlightBooking()
{
	System.out.println("Executing Test 1");
}

@DataProvider
public Object[][] getData()
{
	//i stands for number of times testcase should run
	//j stands for no of parametrs it should send for one go
	Object[][] data=new Object[3][3];
	data[0][0]="1abcd";
	data[0][1]="1xyz";
	data[0][2]="1dsaf";
	
	
	data[1][0]="2abcd";
	data[1][1]="2xyz";
	data[1][2]="2dsaf";
	
	data[2][0]="3abcd";
	data[2][1]="3xyz";
	data[2][2]="3dsaf";
	
	
	
	
	return data;
	
	
}

	
}