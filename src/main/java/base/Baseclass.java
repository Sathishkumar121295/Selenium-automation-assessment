package base;



	import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;

	import utils.Configreader;

	public class Baseclass {

	    protected WebDriver driver;
	    protected Logger logger = LogManager.getLogger(this.getClass());

	    @BeforeMethod(alwaysRun=true)
	    public void testsetUp() {

	        Configreader.loadProperties();

	        String browser = Configreader.getProperty("browser");
	        String url = Configreader.getProperty("qa.url");

	        if (browser.equalsIgnoreCase("chrome")) {

	            driver = new ChromeDriver();

	        } else if (browser.equalsIgnoreCase("firefox")) {

	            driver = new FirefoxDriver();

	        } else {

	            throw new IllegalArgumentException("Browser not supported: " + browser);
	        }

	        driver.manage().window().maximize();

	        driver.get(url);
	        System.out.println("===== DRIVER CREATED =====");
	    }
	    public void screenshot(String screenshotname) throws IOException {
	    	TakesScreenshot t=(TakesScreenshot)driver;
	    	File f=t.getScreenshotAs(OutputType.FILE);
	    	String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	    	String Filepath = "Screenshot/"+screenshotname +"_"+timestamp + ".png";
	    	File f2=new File(Filepath);
	    	FileUtils.copyFile(f, f2);
	    	logger.info("Screenshot captured: " + Filepath);
	    }

	    @AfterMethod(alwaysRun=true)
	    public void quit() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

