package dgdox.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

//WebDriver ldriver;

private WebDriver driver;

public loginpage(WebDriver driver)
{
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}



@FindBy(id="username")
private WebElement userTextElement;

@FindBy(id="password")
private WebElement passTextElement;


@FindBy(xpath="//button[normalize-space()='Login']")
private WebElement buttonElement;


public WebElement username()//String user
{
	
	 return userTextElement;
	
}

public WebElement setpass()//String pass
{
	return passTextElement;
}
public void bulogin()
{
	 buttonElement.click();
	
}
}