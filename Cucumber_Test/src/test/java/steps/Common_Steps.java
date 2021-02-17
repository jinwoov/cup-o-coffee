package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Common_Steps {
    WebDriver driver;


    @Given("I am on Ebay Home Page")
    public void before() {
        System.setProperty("webdriver.edge.driver", "webdrivers/msedgedriver");
        driver = new EdgeDriver();
    }

    public void tearDown()
}
