package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver intializeDriver() {
		// properties class
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
			prop.load(fis);
			String browserName = prop.getProperty("browser");
			
			
			if(browserName.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				// firefox
			
			}
			else if(browserName.equalsIgnoreCase("edge"))
			{
				//Edge
				driver = new EdgeDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();			


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return driver;

	}
	
	@BeforeMethod(alwaysRun = true)
	public void launchApplication() {
		driver =  intializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo("https://rahulshettyacademy.com/client");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// TODO Auto-generated method stub
		driver.close();
	}
}
