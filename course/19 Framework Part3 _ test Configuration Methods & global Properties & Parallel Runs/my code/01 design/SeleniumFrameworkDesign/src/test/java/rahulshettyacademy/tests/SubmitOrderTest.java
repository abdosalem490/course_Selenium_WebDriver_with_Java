package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.AssignReturned.ToAllArguments;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	String productName  = "ZARA COAT 3";
	
	@Test
	public void  submitOrder(){
		// TODO Auto-generated method stub
		
		
		//acount = abdosalm555@gmail.com
		//pass = Test@1234
		ProductCatalogue productCatalogue = landingPage.loginAppLocation("abdosalm555@gmail.com", "Test@1234");
		
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProducttoCart(productName);
		
		CartPage cartPage = productCatalogue.goToCartPage();
		
		
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage =  checkoutPage.subitOrder();
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//orders
	}
	
	// To verify ZARA COAT 3 is displaying in order pages
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest()
	{
		//ZARA COAT 3
		ProductCatalogue productCatalogue = landingPage.loginAppLocation("abdosalm555@gmail.com", "Test@1234");
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}

}
