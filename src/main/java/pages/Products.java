package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Waitutils;

public class Products {
         private WebDriver driver;
         private Waitutils wait;
         public Products(WebDriver driver) {
        	 wait=new Waitutils(driver);
        	 this.driver=driver;
        	 PageFactory.initElements(driver,this);
         }
         @FindBy(xpath="//span[text()='Products']")
         private WebElement producttitle;
         @FindBy(xpath="(//div[@data-test='inventory-item-desc'])[1]")
         private WebElement firstproduct;
         @FindBy(xpath="//button[text()='Add to cart']")
         private WebElement addtocart;
         @FindBy(xpath="//a[@data-test='shopping-cart-link']")
         private WebElement cart;
         @FindBy(id="continue-shopping")
         private WebElement back;
         @FindBy(xpath="(//div[@data-test='inventory-item-price'])[1]")
         private WebElement prodprice;
         @FindBy(xpath="//div[@class='inventory_item_price']")
         private WebElement cartpr;
         @FindBy(xpath="//div//button[text()='Open Menu']")
         private WebElement openmenu;
         @FindBy(xpath="//a[text()='Logout']")
         private WebElement log;
         public boolean istitledisplayed() {
        	 return producttitle.isDisplayed();
         }
         public void Productclick() {
        	wait.waitforelementtobeclickable(firstproduct).click();
         }
         public void itemtocart() {
        	 wait.waitforelementtobeclickable(addtocart).click();
         }
         public void carticonclick() {
        	 wait.waitforelementtobeclickable(cart).click();
         }
         public boolean productcheck() {
        	 return wait.Waitforvisibility(firstproduct).isDisplayed();
         }
         public void backtoshop() {
        	 wait.Waitforvisibility(back).click();
         }
         public String productprice() {
        	 return wait.Waitforvisibility(prodprice).getText();
         }
         public String cartproductprice() {
        	 return wait.Waitforvisibility(cartpr).getText();
         }
         public void openmenu() {
        	 wait.Waitforvisibility(openmenu).click();
         }
         public void logout() {
        	 wait.waitforelementtobeclickable(log).click();
         }
}
