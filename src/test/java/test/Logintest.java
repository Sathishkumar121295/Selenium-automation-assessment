package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import utils.Testlistener;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.Login;
import pages.Products;
import utils.Excelreader;
@Listeners(Testlistener.class)
public class Logintest extends Baseclass {
	   @Test(groups={"smoke","regression"})
	    public void validLoginTest() throws IOException {
		   String filepath = "src/test/resources/test data.xlsx";

		    Excelreader excel = new Excelreader(filepath);
		    String username = excel.getCellData("Sheet1", 1, 0);
		    String password = excel.getCellData("Sheet1", 1, 1);
	        Login l = new Login(driver);
	        

	        l.enterusername(username);

	        l.enterpassword(password);

	        l.loginbutton();
	        Products p = new Products(driver);
	       Assert.assertTrue(p.istitledisplayed(),"Product page is not displayed");
	       
	    logger.info("login successful - product is displayed"); 
}
	   @Test(groups= {"smoke"})
	   public void invalidlogin() throws IOException {
		   String filepath = "src/test/resources/test data.xlsx";

		    Excelreader excel = new Excelreader(filepath);

		    int rowcount = excel.getRowCount("Sheet1");

	        for (int i = 2; i < rowcount; i++) {

	            String username = excel.getCellData("Sheet1", i, 0);
	            String password = excel.getCellData("Sheet1", i, 1);

	            logger.info("Testing row: " + i);
	            logger.info("Username: " + username);
	            logger.info("Password: " + password);

		   Login l = new Login(driver);
		   l.enterusername(username);

	        l.enterpassword(password);

	        l.loginbutton();
	        Assert.assertTrue(l.loginerror(), "loginerror is not displayed");
		   logger.info("login error displayed");
	   }
}}