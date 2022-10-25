package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-last-child(1)")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;	
	
	By result = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitFroElementToAppear(result); 
		selectCountry.click();
	}
	
	public ConfirmationPage subitOrder() {
		submit.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	
}
