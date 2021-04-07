package customer_signup_testing;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MovieCustomerSignup {
	
	private WebDriver driver;
	
	@Given("I want to signup")
	public void i_want_to_signup() {
	    System.out.println("Sign up to the BookMyMovie website!");
	}

	@Given("The website is open")
	public void the_website_is_open() {
		System.setProperty("webdriver.gecko.driver", 
				"D:\\1911_Sem_4\\SE LAB\\selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1:8000/");
	}

	@When("I click on signup")
	public void i_click_on_signup() {
	    driver.findElement(By.xpath("/html/body/div[1]/div[3]/button[2]/a")).click();
	}

	@When("enter the correct details with unique username")
	public void enter_the_correct_details_with_unique_username() {
	    driver.findElement(By.id("username")).sendKeys("testin");
	    driver.findElement(By.id("email")).sendKeys("testin@unigoa.ac.in");
	    driver.findElement(By.id("p1")).sendKeys("testin1g");
	    driver.findElement(By.id("p2")).sendKeys("testin1g");
	    
	}

	@When("click on signup")
	public void click_on_signup() {
	    driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).click();
	}

	@Then("I should get register and able to login")
	public void i_should_get_register_and_able_to_login() {
	    String returnUrl = driver.getCurrentUrl();
	    String expectedUrl = "http://127.0.0.1:8000/signup/";
	    
	    assertEquals(returnUrl, expectedUrl);
	}

	@When("I am prompted to login")
	public void i_am_prompted_to_login() {
		System.out.println("Log in");
	}

	@When("I enter correct credentials")
	public void i_enter_correct_credentials() {
		driver.findElement(By.id("name")).sendKeys("testin");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/input")).sendKeys("testin1g");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).click();
	}

	@Then("I should be able to login")
	public void i_should_be_able_to_login() {
		String returnUrl = driver.getCurrentUrl();
	    String expectedUrl = "http://127.0.0.1:8000/customer_home/";
	    
	    assertEquals(returnUrl, expectedUrl);
	    
	    driver.quit();
	}

}
