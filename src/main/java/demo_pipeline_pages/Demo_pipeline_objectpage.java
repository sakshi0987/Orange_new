package demo_pipeline_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demo_pipeline_objectpage extends Demo_pipeline_basepage
{
	@FindBy(xpath="//div[@class='orangehrm-login-branding']")
	WebElement logo ;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement uname ;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password ;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit ;
	
	public Demo_pipeline_objectpage()
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement verify_logo()
	{
		return logo;
	}
	public WebElement enter_uname()
	{
		return uname;
	}
	public WebElement enter_Password()
	{
		return password;
	}
	public WebElement enter_submit()
	{
		return submit;
	}
}
