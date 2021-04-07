package admin_panel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class admin_login {

	public WebDriver driver;

	public void waitTime() {
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e){

		}
	}

	@Given("the browser is open")
	public void the_browser_is_open() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside the browser is open");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\painter\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8000/");

		waitTime();
	}

	@Given("the admin login_page url is entered")
	public void the_admin_login_page_url_is_entered() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside admin login_page url is entered");
		driver.get("http://127.0.0.1:8000/admin/login/?next=/admin/");
		waitTime();
	}

	@When("correct username and password is entered")
	public void correct_username_and_password_is_entered() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside correct username and password is entered");
		driver.findElement(By.id("id_username")).sendKeys("admin");
		driver.findElement(By.id("id_password")).sendKeys("admin");
		waitTime();
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input")).click();
		waitTime();
	}

	@Then("I should be able to view the admin panel")
	public void i_should_be_able_to_view_the_admin_panel(){
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside should be able to view the admin panel");
		driver.get("http://127.0.0.1:8000/admin/");
		waitTime();
	}

	@Then("when I click on  logout")
	public void when_i_click_on_logout() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside I click on  logout");
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/a[3]")).click();
		waitTime();
	}

	@Then("I should be able to logout")
	public void i_should_be_able_to_logout() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside should be able to logout");
		driver.get( "http://127.0.0.1:8000/admin/logout/");
		waitTime();
	}


}
