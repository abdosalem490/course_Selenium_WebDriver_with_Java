import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies =  driver.findElements(By.xpath("//tr/td[1]"));
		// 5 results
		List<WebElement>filteredList  = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		//1 result
		Assert.assertEquals(veggies.size(), filteredList.size());
	}

}
