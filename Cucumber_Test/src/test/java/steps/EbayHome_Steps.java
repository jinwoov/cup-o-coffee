package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;

public class EbayHome_Steps {
    WebDriver driver;

    @Given("I am on Ebay Home Page")
    public void i_am_on_ebay_home_page() {
        System.setProperty("webdriver.edge.driver", "webdrivers/msedgedriver");
        driver = new EdgeDriver();
        driver.get("https://www.ebay.com");
    }

    @When("I click on Advanced link")
    public void i_click_on_advanced_link() {
        driver.findElement(By.linkText("Advanced")).click();
    }

    @Then("I navigate to Advanced Search Page")
    public void i_navigate_to_advanced_search_page() {
        String expURL = "https://www.ebay.com/sch/ebayadvsearch";
        String actURL = driver.getCurrentUrl();
        assertEquals(expURL, actURL);
        driver.quit();
    }

}
