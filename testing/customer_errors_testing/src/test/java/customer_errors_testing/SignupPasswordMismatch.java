package customer_errors_testing;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupPasswordMismatch {

	private static void waitTime() {
		try {
	    	Thread.sleep(2000);
	    }catch(InterruptedException e) {
	    	
	    }
	}
	private WebDriver driver;
	
	@Given("I want to signup to the website")
	public void i_want_to_signup_to_the_website() {
		System.out.println("Signup password mismatch");
		System.setProperty("webdriver.gecko.driver", 
				"D:\\1911_Sem_4\\SE LAB\\selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1:8000/");
	}

	@Given("click on the signup button")
	public void click_on_the_signup_button() {
		waitTime();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/button[2]/a")).click();
	}

	@When("I enter passwords that arenot matching")
	public void i_enter_passwords_that_arenot_matching() {
		driver.findElement(By.id("username")).sendKeys("testin");
	    driver.findElement(By.id("email")).sendKeys("testin@unigoa.ac.in");
	    driver.findElement(By.id("p1")).sendKeys("testin11");
	    driver.findElement(By.id("p2")).sendKeys("testin1g");
	    waitTime();
	    driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).click();
	    waitTime();
	}

	@Then("error message should be dsiplayed")
	public void error_message_should_be_dsiplayed() {
		String returnUrl = driver.getCurrentUrl();
	    String expectedUrl = "http://127.0.0.1:8000/signup/";
	    
	    assertEquals(returnUrl, expectedUrl);
	    waitTime();
	    driver.quit();
	}
}
