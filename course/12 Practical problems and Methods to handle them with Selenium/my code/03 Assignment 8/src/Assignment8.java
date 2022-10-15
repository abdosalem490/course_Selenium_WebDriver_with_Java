import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement editText = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		editText.sendKeys("Ind");
		
		Thread.sleep(1000);
		List<WebElement> suggested = driver.findElements(By.className("ui-menu-item"));
		for(WebElement e : suggested)
			if (e.getText().equalsIgnoreCase("India")) {
				e.click();
				break;
			}
		Thread.sleep(2000);

		System.out.println(editText.getAttribute("value"));
		if(editText.getAttribute("value").equalsIgnoreCase("India"))
			System.out.println("Success");
		else
			System.out.println("Failed");
		
	}

}
