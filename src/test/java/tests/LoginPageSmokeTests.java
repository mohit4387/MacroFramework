package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import framework.ConfigFile;
import framework.Pages.LoginPage;
import framework.driver.Driver;

public class LoginPageSmokeTests extends Driver
{
	@BeforeTest
	public void before() throws IOException
	{
		Driver.intialise();		
	}
	
	@AfterTest
	public void after()
	{
		Driver.driverQuit();
	}
	
	@Test
	public void verifyVersion() throws IOException
	{
		Assert.assertEquals(LoginPage.getVersion(), ConfigFile.getValue("macroversion"));
	}
	
	@Test
	public void verifyCopyrightMessage() throws IOException
	{
		Assert.assertEquals(LoginPage.getCopyrightMessage(), ConfigFile.getValue("copyrightmessage"));
	}
	
	@Test
	public void forgotPassword()
	{
		//To do
	}
	
	@Test
	public void loginFunction() throws IOException
	{
		LoginPage.login();
		Assert.assertEquals(driver.getTitle(), "MACRO DATA MANAGEMENT");		
	}
}
