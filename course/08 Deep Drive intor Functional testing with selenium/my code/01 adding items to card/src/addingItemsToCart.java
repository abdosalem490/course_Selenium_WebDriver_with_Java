import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addingItemsToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		

		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		int j = 0;
		
		//expected
		String[] itemsNedded = {"Cucumber", "Brocolli", "Beetroot", "Mango"};
		
		Thread.sleep(1000);
		
		List<WebElement> products  = driver.findElements(By.cssSelector("h4.product-name"));
		
		
		// convert array into array list for easy search
		List<String> itemsNeededList = Arrays.asList(itemsNedded);
		
		for(int i = 0; i < products.size(); i++)
		{
		
			// format the to get the actual vegetable item
			String name = products.get(i).getText().split("-")[0].trim();
			
			
			// check whether the name you entered is present in array or not


			
			if(itemsNeededList.contains(name))
			{
				j++;
				
				//click add to card
				//driver.findElement(By.xpath("//h4[contains(text(),'" + name + "')]/following-sibling::div[@class='product-action']/button")).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j == itemsNedded.length)
					break;
			}
		}
			
		
	}

}
