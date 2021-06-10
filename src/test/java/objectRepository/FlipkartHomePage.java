package objectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {

	WebDriver driver;

	public FlipkartHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "button[class='_2KpZ6l _2doB4z']")
	WebElement skiplogin;
	@FindBy(css = "input[type='text']")
	WebElement search;
	@FindBy(css = "button[type='submit']")
	WebElement submit;
	@FindBy(css = "a[title='Classmate Octane Colourburst Gel Pen Gel Pen']")
	WebElement clickItem;
	@FindBy(xpath = "//div[@class='_30jeq3 _16Jk6d']")
	WebElement catchprice;
	@FindBy(css = "button[class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCart;
	@FindBy(css = ".V3C5bO")
	WebElement viewkart;
	@FindBy(css = "span[class='_2-ut7f _1WpvJ7']")
	WebElement cartPrice;

	public void IgnoreLogin() {
		skiplogin.click();
	}

	public void SearchItem(String item) {
		search.click();
		search.sendKeys(item);
	}

	public void SubmitSearch() {
		submit.click();
	}

	public void ClickItem() {
		clickItem.click();
	}

	public String CatchPrice() {
		return catchprice.getText();
	}

	public void AddToCart() {
		addToCart.click();
	}

	public void ViewKart() {
		viewkart.click();
	}

	public String CartPrice() {
		return cartPrice.getText();
	}

}
