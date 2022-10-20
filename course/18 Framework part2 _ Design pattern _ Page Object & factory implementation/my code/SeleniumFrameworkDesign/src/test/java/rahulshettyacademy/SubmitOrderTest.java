package rahulshettyacademy;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.AssignReturned.ToAllArguments;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName  = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		//acount = abdosalm555@gmail.com
		//pass = Test@1234
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo("https://rahulshettyacademy.com/client");
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
		
		driver.close();
		
	}

}
