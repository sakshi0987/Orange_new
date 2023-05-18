package Demo_pipeline_tests;

import java.io.IOException;
import java.time.Duration;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import demo_pipeline_pages.Demo_pipeline_objectpage;


public class Demo_pipeline_homepagetest extends Demo_pipeline_objectpage
{
	static ExtentTest log ;
	static ExtentReports report ;
	Demo_pipeline_objectpage obj ;
	
	@BeforeSuite
	public void startTest()
	{
		report = new ExtentReports("./reports\\TestcaseExecutionReport.html",true);
 	}
	
	@BeforeClass
	public void Homepage() throws IOException
	{
		Launchpage();
		obj = new Demo_pipeline_homepagetest();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	@Test(priority=1)
	void verifylogo()
	{
		log = report.startTest("logo is visible ");
		boolean logo = obj.verify_logo().isDisplayed();
		System.out.println(logo);
		log.log(LogStatus.PASS, "Test Case passed");
	}
	
	@Test(priority=2)
	void enteruser() throws InterruptedException
	{
		log = report.startTest("user is login ");
		obj.enter_uname().sendKeys("Admin");
		obj.enter_Password().sendKeys("admin123");
		obj.enter_submit().click();
		Thread.sleep(2000);
		log.log(LogStatus.PASS, "Test Case passed");
	}
		
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			log.log(LogStatus.FAIL, "Test Case failed"+result.getName());
			log.log(LogStatus.FAIL, "Test Case failed"+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			log.log(LogStatus.SKIP, "Test Case failed"+result.getName());
			log.log(LogStatus.SKIP, "Test Case failed"+result.getThrowable());
		}
	}
	
	@AfterSuite
	void EndTest()
	{
	report.endTest(log);	
	report.flush();
	// report.close();
	obj.close();
	}
}
