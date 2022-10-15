import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class maxWindoeAndCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		
		//session cookie
		//driver.manage().deleteCookieNamed("sessionKey");
		//click on any line
		// login page : verify login url
		
		// delete 1 cookie
		//driver.manage().deleteCookieNamed("asdf");
		
		//delete all cookies
		driver.manage().deleteAllCookies();
		
	}

}
