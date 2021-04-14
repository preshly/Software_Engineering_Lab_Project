package admin_panel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class add_movie {
	public WebDriver driver;
	public void waitTime() {
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e){

		}
	}

	@Given("I am already logged in as admin")
	public void i_am_already_logged_in_as_admin() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside I am already logged in as admin");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\painter\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8000/admin/login/?next=/admin/");

		driver.findElement(By.id("id_username")).sendKeys("admin");
		driver.findElement(By.id("id_password")).sendKeys("admin");
		waitTime();
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input")).click();
		waitTime();
	}

	@Given("I click on the Movie")
	public void i_click_on_the_movie() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside I click on the Movie");
		WebElement movie = driver.findElement(By.linkText("Movies"));

		driver.get(movie.getAttribute("href"));
	}

	@Given("I click on add movie")
	public void i_click_on_add_movie() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside I click on add movie");
		driver.findElement(By.linkText("ADD MOVIE")).click();
	}

	@Then("I should be able to enter the movie details")
	public void i_should_be_able_to_enter_the_movie_details() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside I should be able to enter the movie details");

		driver.findElement(By.id("id_movie_name")).sendKeys("Avengers");
		waitTime();
		driver.findElement(By.id("id_movie_language")).sendKeys("English");
		waitTime();
		driver.findElement(By.id("id_movie_duration")).sendKeys("2");
		waitTime();
		driver.findElement(By.id("id_movie_description")).sendKeys("this movie is good");
		waitTime();
		driver.findElement(By.id("id_image")).
		sendKeys("C:\\Users\\painter\\Pictures\\avengers.jpg");

		waitTime();
		driver.findElement(By.className("default")).click();
	}

	@Then("the movie should be added in the database")
	public void the_movie_should_be_added_in_the_database() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside  movie should be added in the database");
		driver.get("http://127.0.0.1:8000/admin/movie/movie/");
		waitTime();
	}

	@Then("I click on any movie")
	public void i_click_on_any_movie() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside I click on any movie");
		driver.findElement(By.linkText("Avengers")).click();
	}

	@Then("click on delete")
	public void click_on_delete() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside click on delete");
		driver.findElement(By.className("deletelink")).click();
		waitTime();
		driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]/form/div/input[2]")).click();
		waitTime();
	}

	@Then("the movie shold be deleted")
	public void the_movie_shold_be_deleted() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside the movie shold be deleted");
		waitTime();
		driver.get("http://127.0.0.1:8000/admin/movie/movie/");
		waitTime();
		driver.quit();
	}

}
