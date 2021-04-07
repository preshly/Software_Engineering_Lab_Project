package customer_errors_testing;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UniqueUsername {
	
	private static void waitTime() {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
	}
	
	private WebDriver driver;
	
	@Given("I want to signup with already taken username")
	public void i_want_to_signup_with_already_taken_username() {
		System.out.println("Signup: Unique username error");
		System.setProperty("webdriver.gecko.driver", 
				"D:\\1911_Sem_4\\SE LAB\\selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get("http://127.0.0.1:8000/");
		
		waitTime();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/button[2]/a")).click();
	}

	@When("I enter the username which is already taken by somebody else")
	public void i_enter_the_username_which_is_already_taken_by_somebody_else() {
		driver.findElement(By.id("username")).sendKeys("testin");
	    driver.findElement(By.id("email")).sendKeys("testin@unigoa.ac.in");
	    driver.findElement(By.id("p1")).sendKeys("testin1g");
	    driver.findElement(By.id("p2")).sendKeys("testin1g");
	    waitTime();
	}
	
	@When("click on signup")
	public void click_on_signup() {
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).click();
	    waitTime();
	}
	
	@Then("error message should be displayed and prompt to choose another username")
	public void error_message_should_be_displayed_and_prompt_to_choose_another_username() {
	    String returnUrl = driver.getCurrentUrl();
	    String expectedUrl = "http://127.0.0.1:8000/signup/";
	    
	    assertEquals(returnUrl, expectedUrl);
	    waitTime();
	    driver.quit();
	}
}
