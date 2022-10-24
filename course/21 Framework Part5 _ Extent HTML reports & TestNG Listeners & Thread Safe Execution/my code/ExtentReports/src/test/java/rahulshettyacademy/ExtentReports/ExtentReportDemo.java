package rahulshettyacademy.ExtentReports;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		// ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(path));
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul Shetty");
	}
	
	@Test
	public void initialDemo()
	{
		ExtentTest test = extent.createTest("intial Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		//test.fail("result doesn't match");
		extent.flush();
	}
}
