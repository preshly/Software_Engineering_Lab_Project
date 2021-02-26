package admin_login_testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class unitTestingAdminLogin {

	WebDriver driver;
	
	public static void waitTime() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "D:\\1911_Sem_4\\SE LAB\\selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get("http://127.0.0.1:8000");
		waitTime();
	}
	
	@Test
	void testInvalidAdminDetails() {
		waitTime();
		
		driver.get("http://127.0.0.1:8000/admin/login/?next=/admin/");
		
		driver.findElement(By.id("id_username")).sendKeys("admin");		
		waitTime();		
		driver.findElement(By.id("id_password")).sendKeys("admi");		
		waitTime();
		
		driver.findElement(By.id("log-in")).click();
		assertEquals("Please enter the correct username and password for a staff account. Note that both fields may be case-sensitive.", driver.findElement(By.className("errornote")).getText());
		System.out.println("log in unsuccessful");
		waitTime();
		
	}
	
	@Test
	void testCorrectAdminDetails() {
		waitTime();
		
		driver.get("http://127.0.0.1:8000/admin/login/?next=/admin/");
		
		driver.findElement(By.id("id_username")).sendKeys("admin");	
		waitTime();		
		driver.findElement(By.id("id_password")).sendKeys("admin");		
		waitTime();
		
		driver.findElement(By.id("log-in")).click();		
		System.out.println("Log in successful");
		waitTime();
		
		driver.get("http://127.0.0.1:8000/admin/");	
		waitTime();
		
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/a[3]")).click();
		waitTime();
		System.out.println("Log out successful");
				
		
		driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]/p[2]/a")).click();
		System.out.println("login in again");
		
		waitTime();
		
	}
	
	@AfterEach
	public void closeBrowser() {
		waitTime();
		driver.close();
	}

	@After
	public void closeDriver() {
		waitTime();
		driver.quit();
	}
}
