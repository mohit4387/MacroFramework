package framework.Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import framework.ConfigFile;
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
	
	public static void login() throws IOException
	{
		driver.findElement(By.id("txtUserId")).sendKeys(ConfigFile.getValue("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigFile.getValue("password"));
		driver.findElement(By.id("btnLogin")).click();
	}

}
