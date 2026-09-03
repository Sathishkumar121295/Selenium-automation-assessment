package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.Login;
import pages.Products;

public class productstest extends Baseclass{
	@Test(groups= {"smoke","regression"})
	public void product() {
		Login l = new Login(driver);
		 l.enterusername("standard_user");

	        l.enterpassword("secret_sauce");

	        l.loginbutton();
	        Products p = new Products(driver);
	        Assert.assertTrue(p.istitledisplayed(),"Product page is not displayed");
	        
	        p.Productclick();
	        String price = p.productprice();

	        logger.info("Selected product price: " + price);
	        p.itemtocart();
	        p.carticonclick();
	        Assert.assertTrue(p.productcheck(), "Added product is not in the cart");
	        logger.info("Product added to the cart");
	        String cartprice = p.cartproductprice();
	        Assert.assertEquals(cartprice, price,"product price invalid");
	        logger.info("Product price is validated successfully");
	        p.backtoshop();
	        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html", "User is not redirected to inventorypage");
            logger.info("user redirected to inventorypage");
            Assert.assertTrue(p.isAddToCartNotDisplayed(),"Add to Cart button is still displayed for the selected product");
            logger.info("Add to cart is not displayed on the added product");
            Assert.assertTrue(p.isProductAdded(),"Product is not added to cart");

            logger.info("Product is already added to cart");
	        p.openmenu();
	        p.logout();
	   
	        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/","logout was not successful");
	        System.out.println("user successfully loggedout");
	}

}
