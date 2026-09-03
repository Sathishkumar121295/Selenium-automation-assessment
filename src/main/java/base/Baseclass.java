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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;

	import utils.Configreader;

	public class Baseclass {

	    protected WebDriver driver;
	    protected Logger logger = LogManager.getLogger(this.getClass());

	    @BeforeMethod(alwaysRun=true)
	    public void testsetUp() {

	        Configreader.loadProperties();

	        String browser = System.getProperty( "browser",Configreader.getProperty("browser"));
	        String url = Configreader.getProperty("qa.url");
	        String headless = System.getProperty("headless",
	                Configreader.getProperty("headless"));
	        if (browser.equalsIgnoreCase("chrome")) {

	            ChromeOptions options = new ChromeOptions();
	            options.setExperimentalOption("prefs",java.util.Map.of("profile.password_manager_leak_detection", false));
	            if (headless.equalsIgnoreCase("true")) {

	                options.addArguments("--headless=new");
	                options.addArguments("--no-sandbox");
	                options.addArguments("--disable-dev-shm-usage");
	                options.addArguments("--window-size=1920,1080");

	            }

	            driver = new ChromeDriver(options);

	        }  else if (browser.equalsIgnoreCase("firefox")) {

	            FirefoxOptions options = new FirefoxOptions();

	            if (headless.equalsIgnoreCase("true")) {
	                options.addArguments("-headless");
	            }

	            driver = new FirefoxDriver(options);

	        

	        } else {

	            throw new IllegalArgumentException("Browser not supported: " + browser);

	        }

	        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
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

