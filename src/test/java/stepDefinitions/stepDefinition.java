package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import objectRepository.FlipKartPage;

public class stepDefinition {

	WebDriver driver;
	FlipKartPage fp;
	String itemPrice;
	String cartPrice;

	@Given("^Launch \"([^\"]*)\"$")
	public void launch(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhira\\Eclipse-Practice\\Selenium_Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(arg1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fp= new FlipKartPage(driver);
		fp.skipLogin();
	}

	@When("^Search (.+)$")
	public void search_Gel_Pen(String item) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		fp.searchItem(item);
		fp.subMit();	
		fp.selectItem();
		System.out.println("This third code is developed in 'develop' branch");
		System.out.println("This fourth code is developed in 'develop' branch");
	}

	@When("^Add to the cart$")
	public void add_to_the_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		itemPrice=fp.catchItemPrice();
		System.out.println(itemPrice.substring(1));
		fp.addToCart();
	}

	@Then("^Verify cost of items$")
	public void verify_cost_of_items() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		fp.viewCart();
		cartPrice = fp.cartPrice();	
		System.out.println(cartPrice.substring(1));
		Assert.assertEquals(itemPrice, cartPrice);
		Assert.assertEquals(Integer.parseInt(itemPrice.substring(1)), Integer.parseInt(cartPrice.substring(1)));
	}

}
