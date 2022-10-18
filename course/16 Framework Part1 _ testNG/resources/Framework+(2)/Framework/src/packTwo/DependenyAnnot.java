package packTwo;

import org.testng.annotations.Test;

public class DependenyAnnot {
	
	@Test
	public void OpeningBrowser()
	{
	//This opens the Browser
	System.out.println("Executing opening Browser");

}
@Test(dependsOnMethods={"OpeningBrowser"},alwaysRun=true )
public void FlightBooking()
{
	System.out.println("Executing Flightbooking");
}
@Test(timeOut=45000)
public void Timerelated()
{
//This opens the Browser
System.out.println("New Testcase");

}

@Test(enabled=false)
public void Payment()
{
//This opens the Browser
System.out.println("New Testcase");

}

}
