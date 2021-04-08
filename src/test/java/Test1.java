import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Test1  {
	  
	static ExtentReports report = new ExtentReports();
	static	 ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter("reports/extent/index.html");
	ExtentReports extent;
	ExtentTest logger;
	ExcelConfig config;
	WebDriver driver;
	
	
		
	@BeforeMethod
	public void info(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\minbal521\\Documents\\Chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	
	 
		@Test
		public  void test1() throws InterruptedException, IOException {
			extent = new ExtentReports ();
			//extent.addSystemInfo("Environment","Environment Name")
			
			config = new ExcelConfig();    
			
			
			
		
			driver.get("https://google.com");
			System.out.println("In google.com");
			logger = extent.createTest("Test1");
			if(driver.getTitle().equals("Google")) {
			config.passData("Moved to google.com successfully",  1, 1);
			config.passData("PASS",  1, 2);}
			else {
				config.passData("NOT Moved to google.com successfully",  1, 1);
			config.passData("FAIL",  1, 2);}
			
			logger.log(Status.INFO,"In google.com");
			driver.findElement(By.name("q")).sendKeys("java");
			System.out.println("Entering java");
			logger.log(Status.INFO,"Entering java");
			if(driver.getTitle().equals("Google")) {
				config.passData("Entering java",  2, 1);
				config.passData("PASS",  2, 2);}
				
			else {
				config.passData("not Entering java",  2, 1);
			config.passData("FAIL",  2, 2);}
			
			
			
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			System.out.println("pressing enter key");
			logger.log(Status.INFO,"pressing enter key");
			
			if (driver.getTitle().equals("java - Google Search")){
				config.passData("pressing enter key",  3, 1);
				config.passData("PASS",  3, 2);}
				
			else {
				config.passData("not pressing enter key",  3, 1);
			config.passData("FAIL",  3, 2);}
				
				
			
			extent.attachReporter(extentSparkReporter);
			extent.flush();
			Thread.sleep(2000);
			
			
			
		}
		
		@AfterMethod
		public void onTearDown() {
			
			
			driver.quit();
			
		}
		
		
	}





