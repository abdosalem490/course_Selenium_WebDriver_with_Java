import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(8));
		
		// type in the name
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		// type in the password
		driver.findElement(By.id("password")).sendKeys("learning");
		// select to be user
		driver.findElement(By.xpath("(//span[@class = 'checkmark'])[2]")).click();
		// wait for the alert
		expWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("okayBtn")));
		// accept the pop up window
		driver.findElement(By.id("okayBtn")).click();
		// select the consultant
		Select select = new Select(driver.findElement(By.cssSelector("select.form-control")));
		select.selectByValue("consult");
		// accept all the terms
		driver.findElement(By.id("terms")).click();
		// click on the sign in button
		driver.findElement(By.id("signInBtn")).click();
		
		//explicit wait
		expWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button.btn.btn-info")));
		
		// add all elements to the cart
		List<WebElement> elements = driver.findElements(By.cssSelector("button.btn.btn-info"));
		//select all the elements
		for(WebElement element : elements)
			element.click();
		
		// procceed to the cart
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		
		
	}

}
