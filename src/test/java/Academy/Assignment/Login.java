package Academy.Assignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import resources.base;

public class Login extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{

		 driver =initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void userLogin(String username, String password) {
		driver.get(prop.getProperty("url"));
		System.out.println("Login");
		//Checking Gold Color
		String colourGold = driver.findElement(By.xpath("//div[@class='myHeading']")).getCssValue("background-color");
		String Gold = Color.fromString(colourGold).asHex(); 
		Assert.assertEquals(Gold,"#fdcc16","Gold colour doesn't match");
		
		//Checking Navy Blue color
		String colourNavyBlue = driver.findElement(By.xpath("//button[@type='submit']")).getCssValue("background-color");
		String NavyBlue = Color.fromString(colourNavyBlue).asHex(); 
		Assert.assertEquals(NavyBlue,"#2a2559","Navy Blue colour doesn't match");
		
		LoginPage lp = new LoginPage(driver);
		//Login with valid user credentials
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.clickLogin().click();
		
		//checking if Application is displayed as "QTRecognition"
		Assert.assertEquals("QTRecognition", driver.getTitle());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][2];
		data[0][0] = "prasad.bembde@qualitestgroup.com";
		data[0][1] = "P@ssw0rd";
		return data;
	}
}
