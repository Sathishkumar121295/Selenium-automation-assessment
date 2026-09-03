package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Waitutils;

public class Login {
         private WebDriver driver;
         private Waitutils wait;
         public  Login(WebDriver driver) {
        	 wait = new Waitutils(driver);
        	 this.driver = driver;
        	
        	 PageFactory.initElements(driver,this);
        
         }
         @FindBy(id="user-name")
         private WebElement username;
         @FindBy(xpath ="//input[@id='password']")
         private WebElement pass;
         @FindBy(id="login-button")
         private WebElement button;
         @FindBy(xpath="//h3[@data-test='error']")
         private WebElement error;
         
         public void enterusername(String userid) {
        	 
        	 wait.Waitforvisibility(username).sendKeys(userid);
         }
         public void enterpassword(String password) {
        	 wait.Waitforvisibility(pass).sendKeys(password);
         }
         public void loginbutton() {
        	wait.waitforelementtobeclickable(button).click();
         }
         public boolean loginerror() {
        	 return wait.Waitforvisibility(error).isDisplayed();
        	 
         }
}
