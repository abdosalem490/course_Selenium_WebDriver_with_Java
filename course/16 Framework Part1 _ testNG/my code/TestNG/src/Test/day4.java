package Test;

import org.testng.annotations.Test;

public class day4 {
	
	@Test
	public void webLoginHomeLoan()
	{
		//selenium
		System.out.println("webloginHome");
	}
	
	@Test
	public void MobileLoginHomeLoan()
	{
		//Appium
		System.out.println("MobileloginHome");
	}
	
	@Test(groups = {"Smoke"})
	public void loginAPIHomeLoan()
	{
		// Rest API automation
		System.out.println("APIloginHome");
	}
}
