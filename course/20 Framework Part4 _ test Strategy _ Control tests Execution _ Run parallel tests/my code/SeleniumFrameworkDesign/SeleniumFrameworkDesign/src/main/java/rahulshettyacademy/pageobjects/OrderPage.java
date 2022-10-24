package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css ="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyOrderDisplay(String productName) {
		boolean match = productNames.stream().anyMatch(productname -> productname.getText().equalsIgnoreCase(productName));
		return match;
	}
}
