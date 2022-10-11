import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class childWindow {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nav-link-accountList
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();		//[parentid, childid]
		
		Iterator<String>it =  windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4].trim();
		System.out.println(email);
		
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
	}
}
