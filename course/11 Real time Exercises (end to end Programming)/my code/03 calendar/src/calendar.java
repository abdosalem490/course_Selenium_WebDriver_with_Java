import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(3000);
		
		// August 12
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		while(!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("April"))
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='flatpickr-month']/span[2]")).click();
		}
		
		Thread.sleep(1000);
		List<WebElement>dates = driver.findElements(By.className("flatpickr-day"));
		for(int i = 0; i < dates.size(); i++)
		{
			if(driver.findElements(By.className("flatpickr-day")).get(i).getText().equalsIgnoreCase("23"))
			{
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
			}
		}
		
		
		
		
		
	}

}
