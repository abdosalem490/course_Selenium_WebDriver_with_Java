import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWaitVsImplicit {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
		
		//expected
		String[] itemsNedded = {"Cucumber", "Brocolli", "Beetroot", "Mango"};
		
		Thread.sleep(1000);
		addItems(driver, itemsNedded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		// explicit wait
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		// explicit wait
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	
	public static void addItems(WebDriver driver, String[] itemsNedded)
	{
		int j = 0;
		
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
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j == itemsNedded.length)
					break;
			}
		}		
		
		
	}

}
