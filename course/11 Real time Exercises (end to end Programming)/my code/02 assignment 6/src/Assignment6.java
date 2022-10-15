import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//get the label as an web element
		WebElement labelOption2 = driver.findElement(By.xpath("//div[@id='checkbox-example']/child::fieldset/label[2]"));

		
		//1. select any check box
		labelOption2.findElement(By.id("checkBoxOption2")).click();
		
		//2. grab the label of the selected item
		String labelName = labelOption2.getText().trim();
		
		//3. Select item in the drop down
		Select itemSelected = new Select(driver.findElement(By.id("dropdown-class-example")));
		itemSelected.selectByVisibleText(labelName);
		
		//4. entered the label in the edited text
		driver.findElement(By.id("name")).sendKeys(labelName);
		
		//5. click alert and verify that if text appeared in the alert
		driver.findElement(By.id("alertbtn")).click();
		String alertText =  driver.switchTo().alert().getText();
		if(alertText.contains(labelName))
			System.out.println("Success");
		else 
			System.out.println("Failed");
		
	}

}
