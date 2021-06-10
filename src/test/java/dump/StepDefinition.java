package dump;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

import objectRepository.FlipkartHomePage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
public class StepDefinition {

	WebDriver driver;
	FlipkartHomePage fk;
	String iPrice;
	String cPrice;

	@Given("^Launch \"([^\"]*)\"$")
    public void launch_something(String strArg1) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhira\\Eclipse-Practice\\Selenium_Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(strArg1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fk = new FlipkartHomePage(driver);
		fk.IgnoreLogin();
//        throw new PendingException();       
	}

	@When("^Search (.+)$")
    public void search(String item) throws Throwable {
 		fk.SearchItem(item);
		fk.SubmitSearch();
		fk.ClickItem();
//		throw new PendingException();
	}

	@When("^Add to the cart$")
    public void add_to_the_cart() throws Throwable {
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String  parentid = it.next();
		String  childid = it.next();
		driver.switchTo().window(childid);
		driver.manage().window().maximize();
		iPrice = fk.CatchPrice();
		System.out.println("Item Price is: "+iPrice);
		fk.AddToCart();
//		throw new PendingException();
	}

	@Then("^Verify cost of items$")
    public void verify_cost_of_items() throws Throwable {
		fk.ViewKart();
		cPrice = fk.CartPrice();
		System.out.println("Cart Price is: "+cPrice);
		Assert.assertEquals(iPrice, cPrice);
		driver.close();
//		throw new PendingException();
	}

}