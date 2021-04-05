import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Test1  {
	   private static ExtentTest test;
	    private static ExtentTest scenario;
	    private static ExtentTest step;
	    private static ExtentReports extent;
	    private static String extentReport, reportFolder, reportPath;
	    
	    private static ThreadLocal<ExtentTest> threadLocalFeatureTest = new ThreadLocal<ExtentTest>();
	    private static ThreadLocal<ExtentTest> threadLocalScenarioTest = new ThreadLocal<ExtentTest>();
	    private static ThreadLocal<ExtentTest> threadLocalStepTest = new ThreadLocal<ExtentTest>();
	@BeforeClass
	public static void startTest()
	{
		 ExtentSparkReporter extentSparkReporter;
         String date = new SimpleDateFormat("MMM-dd_HH-mm").format(new Date());
         reportPath = "reports/extent";
         reportFolder = reportPath + "/" + "TEST" + "_" + date;
         extentReport = reportFolder + "/" + "TEST" + "_Report_" + date + ".html";
         extentSparkReporter = new ExtentSparkReporter(extentReport);
         extentSparkReporter.config().setReportName("TEST");
         extentSparkReporter.config().setDocumentTitle("TEST");
         extentSparkReporter.config().setTheme(Theme.STANDARD);
         extentSparkReporter.config().setEncoding("utf-8");
         extent = new ExtentReports();
         extent.attachReporter(extentSparkReporter);
	}
	   public static synchronized void reportStep(int status, String desc) {
	        try {
	            switch (status) {
	                case 1:
	                    threadLocalStepTest.get().log(Status.PASS, desc);
	                    break;
	                case 2:
	                    threadLocalStepTest.get().log(Status.WARNING, desc);
	                    break;
	                case 3:
	                    threadLocalStepTest.get().log(Status.INFO, desc);
	                    break;
	                case 4:
	                    threadLocalStepTest.get().log(Status.SKIP, desc);
	                    break;
	                case 5:
	                    threadLocalStepTest.get().log(Status.FATAL, desc);
	                    Assert.fail(desc);
	                    break;
	                case 6:
	                    threadLocalStepTest.get().log(Status.FAIL, desc);
	                    Assert.fail(desc);
	                    break;
	                case 7:
	                    threadLocalStepTest.get().log(Status.ERROR, desc);
	                    Assert.fail(desc);
	                    break;
	                case 8:
	                    threadLocalStepTest.get().log(Status.FAIL, desc);
	                    break;
	                default:
	                    threadLocalStepTest.get().fail("Status '" + status + "' not implemented");
	                    Assert.fail("Status '" + status + "' not implemented");
	                    break;
	            }
	        } catch (Exception e) {
	           reportStep(7, e.toString());
	        }
	    }


		@Test
		public void test1() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\minbal521\\Documents\\Chrome driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		
			driver.get("https://google.com");
			System.out.println("In google.com");
			reportStep(3,"After moving to google.com");
			driver.findElement(By.name("q")).sendKeys("java");
			System.out.println("Entering java");
			reportStep(3,"After Entering java");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			System.out.println("pressing enter key");
			reportStep(3,"After pressing enter key");
			Thread.sleep(2000);
			 extent.flush();
			driver.quit();
			
		}
		
		@AfterClass
		public void onTearDown() {
			
			
		
			
		}
		
		
	}



