package demo_pipeline_pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_pipeline_basepage
{
	public static WebDriver driver ;
	public static Properties prop1;

	public void Launchpage() throws IOException
	{
		try
		{
	    // reading file using file handling
			
		FileInputStream file = new FileInputStream("./demopipeline.properties");
		prop1 = new Properties();
		prop1.load(file);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver.get(prop1.getProperty("url"));
		driver.manage().window().maximize();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
	}

	public void close()
	{
		driver.quit();
	}
}
