package utils;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitutils {
        private WebDriver driver;
        private WebDriverWait wait;
        
        public Waitutils(WebDriver driver) {
        	this.driver=driver;
        	this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        	
        }
       public WebElement Waitforvisibility(WebElement element) {
    	   return wait.until(ExpectedConditions.visibilityOf(element));
	     
}
       public WebElement waitforelementtobeclickable(WebElement element) {
    	   return wait.until(ExpectedConditions.elementToBeClickable(element));
       }
}