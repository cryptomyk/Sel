import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Test1 {


		@BeforeClass
		public void onStart() {
			

			
		}

		@Test
		public void test1() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\minbal521\\Documents\\Chrome driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		
			driver.get("https://google.com");
			System.out.println("In google.com");
			driver.findElement(By.name("q")).sendKeys("java");
			System.out.println("Entering java");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			System.out.println("pressing enter key");
			Thread.sleep(2000);
			
			driver.quit();
			
		}
		
		@AfterClass
		public void onTearDown() {
			
			
		
			
		}
		
		
	}


