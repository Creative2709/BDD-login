package stepDefinations;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Clock;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

public class login_steps {

	WebDriver driver = null;



@Given("User is on Home Page")
public void user_is_on_home_page() {
	System.out.println("Opening Browser...");
	System.setProperty("webdriver.chrome.driver", "D:\\WORLDLINE\\Testing\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://practicetestautomation.com");
	
}

@When("User navigate to Login Page")
public void user_navigate_to_login_page() throws InterruptedException {
	driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
	Thread.sleep(2000);
	
}

@Then("User enters {string} and {string}")
public void user_enters_and(String username, String password) throws InterruptedException {

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('username').scrollIntoView();");
	
	WebElement usernameField = driver.findElement(By.id("username"));
    usernameField.sendKeys(username);
    Thread.sleep(2000);
    
    WebElement passwordField = driver.findElement(By.id("password"));
    passwordField.sendKeys(password);
    Thread.sleep(2000);
}


@Then("Keeping case as Valid")
public void keeping_case_as_valid() {
}

@Then("User should get logged in")
public void user_should_get_logged_in() throws InterruptedException {
   driver.findElement(By.id("submit")).click();
	Thread.sleep(5000);

	
}

@Then("Message displayed Login Successfully")
public void message_displayed_login_successfully() {
	String expectedurl = "https://practicetestautomation.com/logged-in-successfully/";
	String currenturl = driver.getCurrentUrl();
	Assert.assertEquals(expectedurl , currenturl);

}

@Then("Keeping case as InValid")
public void keeping_case_as_in_valid() {
	   System.out.println("Invalid Case");

}

@Then("user will be asked to go back to login page")
public void user_will_be_asked_to_go_back_to_login_page() {
    String expected_url = "https://practicetestautomation.com/logged-in-successfully/";
    String current_url = driver.getCurrentUrl();
    
    Assert.assertEquals(expected_url, current_url);
//    if(!(expected_url.equals(current_url))){
//    	
//    	System.out.println("Invalid Credential. Enter right one!");
//    }
}

@Then("Provide correct credentials")
public void provide_correct_credentials() {
    driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
}

}
