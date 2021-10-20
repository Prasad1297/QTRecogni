package Academy.Assignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SendKudosPage;
import PageObjects.activityPage;
import resources.base;

public class KudosRecent extends base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test(dataProvider = "getData")
	public void kudosRecent(String username, String password, String comment){
		
		driver.get(prop.getProperty("url"));
		System.out.println("KudosRecent");
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.clickLogin().click();
		
		activityPage aP=new activityPage(driver);
		aP.clickRecentKudos().click();
		
		SendKudosPage skp = new SendKudosPage(driver);
		skp.getWriteAppreciationMsg().click();
		skp.getComment().sendKeys(comment);
		skp.getSendButton().click();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][3];
		data[0][0]="prasad.bembde@qualitestgroup.com";
		data[0][1]="P@ssw0rd";
		data[0][2]="Good Work";
		return data;
	}
}
