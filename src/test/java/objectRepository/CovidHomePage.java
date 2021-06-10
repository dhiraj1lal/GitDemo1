package objectRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class CovidHomePage {

	public WebDriver driver;

	public CovidHomePage () {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhira\\Eclipse-Practice\\Selenium_Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	

	By searchState = By.cssSelector("input[type='text']");
	By listedState = By.xpath("//div[@class='results']/a/div/div/div");
	By stateCount = By.xpath("//*[@id='root']/div/div[2]/div[1]/div[2]/div[2]/div[2]/h1");
	By displayedCount = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div[2]/div[1]/h1/div");

	public WebElement SearchState() {
		return driver.findElement(searchState);
	}

	public List<WebElement> ListedState() {
		return (List<WebElement>) driver.findElements(listedState);
	}

	public WebElement StateCount() {
		return driver.findElement(stateCount);
	}

	public WebElement DispCount() {
		return driver.findElement(displayedCount);
	}

	@DataProvider
	public Object[] getData() {

		Object[] data = new Object[2];
		data[0] = "Uttar Pradesh";
		data[1] = "Delhi";
		return data;
	}
}
