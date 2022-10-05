import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SelfIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Invoking the Browser
		// Chrome - ChromeDriver -> Methods close get
		// Firefox - FirefoxDriver -> methods close get
		// safari SaariDriver -> methods close get
		// webDriver  close get
		// WebDriver methods + class methods
		
		// chromedriver.exe -> Chrome browser
		//System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		
		//setup the firefox driver
		//System.setProperty("webdriver.gecko.driver", "C:\\firefox driver\\geckodriver.exe");
		
		
		//setup the microsoft edge drvier 
		System.setProperty("webdriver.edge.driver", "C:\\microsoft edge driver\\msedgedriver.exe");
		
		// webdriver.chrome.driver -> value of path
		//WebDriver driver = new ChromeDriver();
		
		//Firefox driver
		//geckodriver
		//WebDriver driver = new FirefoxDriver();
		
		//microsoft edge driver
		//msedgedriver
		WebDriver driver = new EdgeDriver();
		
		// visit the url
		driver.get("https://rahulshettyacademy.com");
		
		// get the title of the webpage
		System.out.println(driver.getTitle());
		
		// validate the url
		System.out.println(driver.getCurrentUrl());
		
		//clsoe the driver
		driver.close();
		
		//close the driver
		//driver.quit();  // close all tabs opened by selenium
		
	}

}
