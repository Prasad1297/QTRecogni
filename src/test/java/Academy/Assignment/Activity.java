package Academy.Assignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import resources.base;

public class Activity extends base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void ActivityPage(String username, String password){
		
		//Reading data from properties file and loading the site
		driver.get(prop.getProperty("url"));
		System.out.println("Activity");
		//Login to the site
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.clickLogin().click();
		
		//After Login user should be able to see his name
		Assert.assertTrue(driver.findElement(By.xpath("(//h5[@class='header-font-size'])[1]")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("(//h5[@class='header-font-size'])[1]")).getText());
		
		//Checking if default image is displayed or not
		String s= driver.findElement(By.xpath("//img [@src='img\\\\avatar.svg']")).getAttribute("alt");
		System.out.println(s);
		
		//checking if Application is displayed as "QTRecognition"
		Assert.assertEquals("QTRecognition", driver.getTitle());
	}
	
	//closing all windows opened for test execution
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][2];
		data[0][0]="prasad.bembde@qualitestgroup.com";
		data[0][1]="P@ssw0rd";
		return data;
	}
}
