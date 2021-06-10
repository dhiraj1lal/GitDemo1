package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartPage {
	
	WebDriver driver;
	public FlipKartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[class='_2KpZ6l _2doB4z']")
	WebElement skiplogin;
	
	@FindBy(css="input[type='text']")
	WebElement search;
	
	@FindBy(css="button[type='submit']")
	WebElement submit;
	
	@FindBy(css="a[title='Classmate Octane Colourburst Gel Pen Gel Pen']")
	WebElement clickItem;
	
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']")
	WebElement catchprice;
	
	@FindBy(css="button[class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCart;
	
	@FindBy(css=".V3C5bO")
	WebElement viewkart;
	
	@FindBy(css="span[class='_2-ut7f _1WpvJ7']")
	WebElement cartprice;
	
	public void skipLogin() {
		skiplogin.click();
	}
	
	public void searchItem(String item) {
		search.sendKeys(item);
	}
	
	public void subMit() {
		submit.click();
	}
	
	public void selectItem() {
		clickItem.click();
	}
	
	public String catchItemPrice() {
		return catchprice.getText();
	}
	
	public void addToCart() {
		addToCart.click();
	}
	
	public void viewCart() {
		viewkart.click();
	}
	
	public String cartPrice() {
		return cartprice.getText();
	}

}
