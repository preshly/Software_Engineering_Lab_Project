package customer_errors_testing;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidLogin {
	
	private static void waitTime() {
		try {
	    	Thread.sleep(2000);
	    }catch(InterruptedException e) {
	    	
	    }
	}
	
	private WebDriver driver;
	
	@Given("I want to login to the website")
	public void i_want_to_login_to_the_website() {
		 System.out.println("Invalid Login");
		 System.setProperty("webdriver.gecko.driver", 
					"D:\\1911_Sem_4\\SE LAB\\selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1:8000/");
	}

	@Given("I click on log in")
	public void i_click_on_log_in() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/button[1]/a")).click();
		waitTime();
	}

	@When("enter invalid login credentials")
	public void enter_invalid_login_credentials() {
		driver.findElement(By.id("name")).sendKeys("shaw13");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/input")).sendKeys("asdf1234");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).click();
		waitTime();
	}

	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
		String returnUrl = driver.getCurrentUrl();
	    String expectedUrl = "http://127.0.0.1:8000/login/";
	    
	    assertEquals(returnUrl, expectedUrl);
	    waitTime();
	    driver.quit();
	}
}
