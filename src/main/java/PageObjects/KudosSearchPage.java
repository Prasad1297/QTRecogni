package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KudosSearchPage {
	public WebDriver driver;
	
	By searchByname = By.id("s_e_add");
	By clickSearchButton = By.xpath("//*[@id=\"search_panel\"]/button");
	
public KudosSearchPage(WebDriver driver) {	
		
		this.driver=driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(searchByname);
	}
	
	public WebElement ClickSearch() {
		return driver.findElement(clickSearchButton);
	}
}
