package dump;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import cucumber.api.java.en.*;
import objectRepository.CovidHomePage;

public class StepDefinition1 {

	CovidHomePage cp = new CovidHomePage();
	String num1="";

	@Given("^Launch browser and browse \"([^\"]*)\"$")
    public void launch_browser_and_browse_something(String strArg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
		cp.driver.get(strArg1);
	}

	@When("^Search (.+) and find covid active cases$")
    public void search_and_find_covid_active_cases(String state) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cp.SearchState().click();
		cp.SearchState().sendKeys(state);
		List<WebElement> options = (List<WebElement>) cp.ListedState();

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(state)) {
				option.click();
				break;
			}
		}
		Thread.sleep(3000);
//		WebDriverWait w = new WebDriverWait(driver, 5);
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[2]/div[2]/div[2]/h1")));

		num1 = cp.StateCount().getText();
	}

	@Then("^validate count of active cases$")
	public void validate_count_of_active_cases() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String num2 = cp.DispCount().getText();
		Assert.assertEquals(num1, num2);
		System.out.println(num1);
		System.out.println(num2);
		
	}
}
