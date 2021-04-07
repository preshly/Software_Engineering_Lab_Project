package customer_signup_testing;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MovieCustomerLogin {
	
	private WebDriver driver;
	
	@Given("I want to login")
	public void i_want_to_login() {
	    System.out.println("Login");
	}

	@Given("the website is open")
	public void the_website_is_open() {
		System.setProperty("webdriver.gecko.driver", 
				"D:\\1911_Sem_4\\SE LAB\\selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1:8000/");
	}

	@When("I click on login")
	public void i_click_on_login() {
	    driver.findElement(By.xpath("/html/body/div[1]/div[3]/button[1]/a")).click();
	}

	@When("enter the correct details")
	public void enter_the_correct_details() {
		driver.findElement(By.id("name")).sendKeys("shaw12");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/input")).sendKeys("asdf1234");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).click();
	}

	@Then("I should be redirected to the customer home page")
	public void i_should_be_redirected_to_the_customer_home_page() {
		String returnUrl = driver.getCurrentUrl();
	    String expectedUrl = "http://127.0.0.1:8000/customer_home/";
	    
	    assertEquals(returnUrl, expectedUrl);
	}

	@When("I click on any movie image or name")
	public void i_click_on_any_movie_image_or_name() {
	    driver.findElement(By.xpath("/html/body/div[3]/div[1]/a/img")).click();
	    try {
	    	Thread.sleep(4000);
	    }catch(InterruptedException e) {
	    	
	    }
	}

	@Then("I a modal of movie details should be visible")
	public void i_a_modal_of_movie_details_should_be_visible() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Movie modal shown");
	}
	
	@When("I close the modal")
	public void i_close_the_modal() {
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/a")).click();
	}

	@When("click on logout")
	public void click_on_logout() {
	    driver.findElement(By.xpath("/html/body/div[2]/div[3]/button[2]/a")).click();
	}

	@Then("I should be logged out")
	public void i_should_be_logged_out() {
		String returnUrl = driver.getCurrentUrl();
	    String expectedUrl = "http://127.0.0.1:8000/";
	    
	    assertEquals(returnUrl, expectedUrl);
	    
	    driver.quit();
	}
}
