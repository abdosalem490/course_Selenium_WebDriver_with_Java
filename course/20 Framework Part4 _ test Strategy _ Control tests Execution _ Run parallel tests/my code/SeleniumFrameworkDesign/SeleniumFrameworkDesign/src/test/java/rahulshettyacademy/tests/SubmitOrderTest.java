package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
	
	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void  submitOrder(HashMap<String, String> input){
		// TODO Auto-generated method stub
		
		
		//acount = abdosalm555@gmail.com
		//pass = Test@1234
		ProductCatalogue productCatalogue = landingPage.loginAppLocation(input.get("email"), input.get("password"));
		
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProducttoCart(productName);
		
		CartPage cartPage = productCatalogue.goToCartPage();
		
		
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
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
	
	public String getScreenShot(String testCaseName) {
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		try {
			FileUtils.copyFile(source, file);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	//Extent Reports
	
	@DataProvider
	public Object[][] getData()
	{
		/*HashMap<String, String>map = new HashMap<>();
		map.put("email", "abdosalm555@gmail.com");
		map.put("password", "Test@1234");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String, String>map1 = new HashMap<>();
		map1.put("email", "shetty@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("product", "ADIDAS ORIGINAL");*/
		
		List<HashMap<String, String>>data =  getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}
