import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,600)");
		WebElement table = driver.findElement(By.name("courses"));
		
		System.out.println("number of rows = " + table.findElements(By.tagName("tr")).size());
		System.out.println("number of columns = " + table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		System.out.println(secondRow.size());
		System.out.println("instructor = " + secondRow.get(0).getText() + " Course = " + secondRow.get(1).getText() + " Price = " + secondRow.get(2).getText());
		 
	}

}
