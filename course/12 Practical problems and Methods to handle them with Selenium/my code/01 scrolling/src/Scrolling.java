import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scroll(0,600)");
		 
		 Thread.sleep(3000);
		 
		 js.executeScript("document.querySelector(\".tableFixHead\").scrollTop = 5000");
		 
		 int sum = 0;
		 List<WebElement>values =  driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		 for(int i = 0; i < values.size(); i++)
		 {
			 sum += Integer.parseInt(values.get(i).getText());
			 
		 }
		 
		 System.out.println("sum = " + sum);
		 
		 int totalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		 
		 Assert.assertEquals(sum, totalAmount);
		 
	
	}

}
