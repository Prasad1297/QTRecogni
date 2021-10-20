package Academy.Assignment;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SendKudosPage;
import PageObjects.activityPage;
import resources.base;

public class SendKudos extends base {
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void sendKudos(String username, String password,String employeeEmail, String trophyName, String comment) {

		//getting data from property file
		driver.get(prop.getProperty("url"));
		System.out.println("KudosSend");
		//Login to the url
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.clickLogin().click();

		activityPage aP = new activityPage(driver);
		aP.clickSendkudos().click();
		SendKudosPage kudos = new SendKudosPage(driver);
		
		// User should be able to select employee email address
		kudos.getEmailInKudosSearch().sendKeys(employeeEmail);

		/*
		 * driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.
		 * ARROW_DOWN, Keys.RETURN);
		 * driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.
		 * ENTER, Keys.RETURN);
		 */

		// Clicking on the appreciation message
		List<WebElement> li3 =driver.findElements(By.xpath("//*[@id='trophy_list']/div"));
		for(WebElement list: li3) {
			if(list.getText().contains(trophyName)) {
				list.click();
				System.out.println("quick learner selected");
				break;
			}
		}
		// commenting about appreciation
		kudos.getComment().sendKeys(comment);

		// sending kudos
		kudos.getSendButton().click();
		
		//Checking if kudos is sent or not
		Assert.assertTrue(
				driver.findElement(By.xpath("//center[contains(text(),'Mailer Error: SMTP connect() failed.')]")).isDisplayed(),
				"Successfully sent kudos");
	}

	// Closing all windows after execution
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][5];
		data[0][0]="prasad.bembde@qualitestgroup.com";
		data[0][1]="P@ssw0rd";
		data[0][2]="Harshini M Iyli  (harshini.iyli@qualitestgroup.com)";
		data[0][3]="Quick Learner";
		data[0][4]="Quality";
		return data;
	}
}










/*
 * Robot r = new Robot(); r.delay(1000); r.keyPress(KeyEvent.VK_DOWN);
 * r.delay(1000); r.keyRelease(KeyEvent.VK_DOWN); r.delay(1000);
 * 
 * r.keyPress(KeyEvent.VK_ENTER); r.delay(1000);
 * r.keyRelease(KeyEvent.VK_ENTER); r.delay(1000);
 */