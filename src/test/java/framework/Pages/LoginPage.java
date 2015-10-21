package framework.Pages;

import org.openqa.selenium.By;

import framework.driver.Driver;

public class LoginPage extends Driver
{
	
	public static String getVersion()
	{
		String version = driver.findElement(By.id("lblProductVersion")).getText();
		System.out.println(version);
		return version;
	}

	public static String getCopyrightMessage()
	{
		String copyright = driver.findElement(By.id("lblProductInfo")).getText();
		return copyright;
	}
	
	public static

}
