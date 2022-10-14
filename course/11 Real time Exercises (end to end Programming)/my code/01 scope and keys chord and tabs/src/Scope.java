import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1. give the count of the count of links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. limit the scope of te driver
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3. count if links in the only first column in the footer
		WebElement coulmnDriver =  footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coulmnDriver.findElements(By.tagName("a")).size());
		
		//4. click on each link in the column and check if the pages are opening
		for(int i = 1; i < coulmnDriver.findElements(By.tagName("a")).size(); i++)
		{
			String clickonLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			coulmnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLink);
			
			Thread.sleep(5000L);
			
		}
		
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it =  abc.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
		//5. grab the titles of each opened tab
		
	}

}
