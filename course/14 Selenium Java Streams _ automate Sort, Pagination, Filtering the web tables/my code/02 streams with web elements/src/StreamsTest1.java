import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// click on coulmn
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// capture all web elements into list
		List<WebElement>elementsList =  driver.findElements(By.xpath("//tr/td[1]"));
		
		// capture text of all web elements into new(original) list
		List<String>originalList   = elementsList.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		// sort on the oringinal list of step3 -> sorted list
		List<String>sortedList =  originalList.stream().sorted().collect(Collectors.toList());
		
		// compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		// scan the name cloumn with get Text -> Rice -> print the price of the Rice
		List<String>price =  elementsList.stream().filter(s->s.getText().contains("Beans")).map(s-> getPriceVeggie(s)).collect(Collectors.toList());
		
		price.forEach(s-> System.out.println(s));
		
		// elemenet which is fount in different page
		List<String>price1; 
		
		do
		{
			elementsList =  driver.findElements(By.xpath("//tr/td[1]"));
			price1 =  elementsList.stream().filter(s->s.getText().contains("Rice")).map(s-> getPriceVeggie(s)).collect(Collectors.toList());
			if(price1.size() < 1)
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}while(price1.size() < 1);
		
		if(price1.size() > 0)
			System.out.println(price1.get(0));
	
	}
	
	public static String getPriceVeggie(WebElement s)
	{
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
