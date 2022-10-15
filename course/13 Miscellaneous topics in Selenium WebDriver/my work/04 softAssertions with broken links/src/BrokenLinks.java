import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//broken url
		// Java methods will call URL's and gets the status code
		
		//step 1 - is to get all urls  tied up to the links using selenium
		//$('a[href*="soapui"]')
		//String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

		//step2 - if the status code > 400 then that url isn't working -> link wich tied to url is borken
		HttpURLConnection connection =  (HttpURLConnection)new URL(url).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		int responseCode =  connection.getResponseCode();
		System.out.println(responseCode);
		SoftAssert a = new SoftAssert();
		
		// iterate over all links
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link : links)
		{
			String url1 = link.getAttribute("href");
			HttpURLConnection connection1 =  (HttpURLConnection)new URL(url1).openConnection();
			connection1.setRequestMethod("HEAD");
			connection1.connect();
			int responseCode1 =  connection1.getResponseCode();
			System.out.println(responseCode1);
			a.assertTrue(responseCode1 < 400, "The link with Text " + link.getText() + " is broken with code " + responseCode1);
			
		}
		
		a.assertAll();
		
	}

}
