import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

	
	
	public void startReport(){
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		extent = new ExtentReports ();
		//extent.addSystemInfo("Environment","Environment Name")
		
              extent.attachReporter(extentSparkReporter);
	}
		
	//@Test
	public void info(){
		//extent.startTest("TestCaseName", "Description")
		//TestCaseName – Name of the test
		//Description – Description of the test
		//Starting test
		
		Assert.assertTrue(true);
		//To generate the log when the test case is passed
		
	}
	
	
	 
		@Test
		public  void test1() throws InterruptedException {
			extent = new ExtentReports ();
			//extent.addSystemInfo("Environment","Environment Name")
			
	              
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\minbal521\\Documents\\Chrome driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		
			driver.get("https://google.com");
			System.out.println("In google.com");
			logger = extent.createTest("Test1");
			logger.log(Status.INFO,"In google.com");
			driver.findElement(By.name("q")).sendKeys("java");
			System.out.println("Entering java");
			logger.log(Status.INFO,"Entering java");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			System.out.println("pressing enter key");
			logger.log(Status.INFO,"pressing enter key");
			extent.attachReporter(extentSparkReporter);
			extent.flush();
			Thread.sleep(2000);
			
			driver.quit();
			
		}
		
		@AfterClass
		public void onTearDown() {
			
			
		
			
		}
		
		
	}



