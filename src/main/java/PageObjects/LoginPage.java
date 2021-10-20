package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver  driver;
	
	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='pass']");
	By Login = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword(){
		return driver.findElement(password);
	}
	
	public WebElement clickLogin() {
		return driver.findElement(Login);
	}
}
