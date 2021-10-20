package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class activityPage {
	public WebDriver driver;
	
	By sendKudos = By.xpath("//a[@class=\"nav-item nav-link\"]");
	By kudosSearch = By.xpath("//span[contains(text(),'Kudos Search')]");
	By kudosFromMe = By.xpath("//span[contains(text(),'Kudos from me')]");
	By kudosToMe = By.xpath("//span[contains(text(),'Kudos to me')]");
	By activity = By.xpath("//span[contains(text(),'Activity')]");
	By recentKudos = By.xpath("//*[@id=\"contact_list\"]/div[1]/div/h5/small/a/i");
	
	public activityPage(WebDriver driver) {	
		this.driver=driver;
	}
	public WebElement clickSendkudos() {
		return driver.findElement(sendKudos);
	}
	public WebElement clickKudosSearch() {
		return driver.findElement(kudosSearch);
	}
	public WebElement clickRecentKudos() {
		return driver.findElement(recentKudos);
	}
}
