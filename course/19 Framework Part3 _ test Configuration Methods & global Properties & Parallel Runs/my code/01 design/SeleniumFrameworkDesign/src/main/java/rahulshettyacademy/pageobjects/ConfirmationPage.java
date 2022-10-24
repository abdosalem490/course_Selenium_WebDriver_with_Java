package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;	
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}
}
