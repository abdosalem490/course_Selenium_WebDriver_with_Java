package Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {
	
	@Test
	public void demo()
	{
		System.out.println("hello");
	}
	
	@Test
	public void SecondTest()
	{
		System.out.println("bye");
		Assert.assertTrue(false);
	}
	
	@AfterTest
	public void lastExecution()
	{
		System.out.println("I will execute last");
	}
	

}
