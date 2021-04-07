package admin_panel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class update_movieDetails {
	
	public WebDriver driver;
	public void waitTime() {
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e){

		}
	}

	@Given("I click on change button for movie")
	public void i_click_on_change_button_for_movie() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("inside I click on change button for movie");
		//waitTime();
		driver.findElement(By.xpath("//*[@id=\"content-main\"]/div[2]/table/tbody/tr[3]/td[2]/a")).click();
		
		
		waitTime();
	}

	@Given("click on the movie i want to update_details")
	public void click_on_the_movie_i_want_to_update_details() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("inside click on the movie i want to update_details");
		//driver.findElement(By.xpath("//*[@id=\"result_list\"]/tbody/tr[5]/th/a")).click();
		driver.findElement(By.linkText("Mumbai Saga 4")).click();
		waitTime();
	}

	@Then("I should be able to edit the movie details")
	public void i_should_be_able_to_edit_the_movie_details() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("inside I should be able to edit the movie details");
		driver.findElement(By.id("id_movie_name")).clear();
		waitTime();
		driver.findElement(By.id("id_movie_name")).sendKeys("Mumbai Saga");
		waitTime();
		
		driver.findElement(By.className("default")).click();
	}

	@Then("the movie details should be updated in the database")
	public void the_movie_details_should_be_updated_in_the_database() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("inside the movie details should be updated in the database");
		driver.get("http://127.0.0.1:8000/admin/movie/movie/");
		waitTime();
		driver.quit();
	}
}
