package framework.driver;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import framework.ConfigFile;

public class Driver
{
	protected static WebDriver driver = null;
	public static void intialise() throws IOException //this method will launch macro and switch focus to login page
	{
		String browser = ConfigFile.getValue("browser");
				
		if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		driver.get(ConfigFile.getValue("url"));
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		driver.manage().window().maximize();
	}
	
	//Definition is not complete
	public static void initaliseAndLogin() throws IOException
	{
		driver.findElement(By.id("txtUserId")).sendKeys(ConfigFile.getValue("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigFile.getValue("password"));
		driver.findElement(By.id("btnLogin")).click();
		
		String pageTitle = driver.getTitle();
		if(pageTitle.equalsIgnoreCase("MACRO Database Choice") || pageTitle.equalsIgnoreCase("MACRO Data Management"))
		{
			return true;
		}
	}
	
	public static void driverQuit()
	{
		driver.quit();
	}

}
