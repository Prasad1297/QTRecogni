package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendKudosPage {
	public WebDriver driver;
	
	By enterMailorName = By.id("email_address");
	By comment = By.id("comment");
	By appreciationMsg = By.xpath("//*[@id=\"trophy_list\"]/div[1]/div/div");
	By send = By.xpath("//button[@class='btn btn-primary']");
	
	public SendKudosPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmailInKudosSearch() {
		return driver.findElement(enterMailorName);
	}
	
	public WebElement getComment() {
		return driver.findElement(comment);
	}
	
	public WebElement getWriteAppreciationMsg() {
		return driver.findElement(appreciationMsg);
	}
	
	public WebElement getSendButton() {
		return driver.findElement(send);
	}
}
