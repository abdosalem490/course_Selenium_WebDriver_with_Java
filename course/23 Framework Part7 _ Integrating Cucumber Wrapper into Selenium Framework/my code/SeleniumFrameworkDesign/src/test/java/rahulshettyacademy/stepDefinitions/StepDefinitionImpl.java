package rahulshettyacademy.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page()
	{
		//code
		landingPage = launchApplication();
	}
	
	@Given("^loged in with username (.+) and password (.+)$")
	public void loged_in_with_username_and_password(String username, String password)
	{
		productCatalogue = landingPage.loginAppLocation(username, password);
	}
	
	@When("^I add product (.+) from Cart$")
	public void I_add_product_from_Cart(String productName)
	{
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProducttoCart(productName);
	}
	
	@When("^checkout (.+) and submit order$")
	public void checkout_and_submit_order(String productName)
	{
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage =  checkoutPage.subitOrder();
	}
	
	@Then("{string} is displayed on the ConfirmationPage")
	public void message_is_displayed_on_the_ConfirmationPage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		
		driver.close();
	}
	
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
    	Assert.assertEquals(strArg1, "Incorrect email or password.");
    	driver.close();
    }
}
