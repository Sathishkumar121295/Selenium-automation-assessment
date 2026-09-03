package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.Login;
import pages.Products;

public class productstest extends Baseclass{
	@Test(groups= {"regression"})
	public void product() {
		Login l = new Login(driver);
		 l.enterusername("standard_user");

	        l.enterpassword("secret_sauce");

	        l.loginbutton();
	        Products p = new Products(driver);
	        Assert.assertTrue(p.istitledisplayed(),"Product page is not displayed");
	        
	        p.Productclick();
	        String price = p.productprice();

	        System.out.println("Selected product price: " + price);
	        p.itemtocart();
	        p.carticonclick();
	        Assert.assertTrue(p.productcheck(), "Added product is not in the cart");
	        System.out.println("Product added to the cart");
	        String cartprice = p.cartproductprice();
	        Assert.assertEquals(cartprice, price,"product price invalid");
	        System.out.println("Product price is validated successfully");
	        p.backtoshop();
	        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html", "User is not redirected to inventorypage");
            System.out.println("user redirected to inventorypage");
	        p.openmenu();
	        p.logout();
	   
	        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/","logout was not successful");
	        System.out.println("user successfully loggedout");
	}

}
