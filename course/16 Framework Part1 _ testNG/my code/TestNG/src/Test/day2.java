package Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {

	@Test(groups = {"Smoke"})
	public void ploan()
	{
		System.out.println("good");
	}
	
	@BeforeTest
	public void preRequiste()
	{
		System.out.println("I will execute first");
	}
	
	@Parameters({"URL", "APIKey/username"})
	@Test
	public void paramsTesst2(String URL, String username)
	{
		System.out.println(URL + " user name = " + username);
	}
	
}
