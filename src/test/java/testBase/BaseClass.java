package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; //logging 

public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger;  //for logging
	
	public ResourceBundle rb;
	
	
	@Parameters("browser")
	@BeforeClass(groups = {"Master","Sanity","Regression"})

	public void setup(@Optional("Chrome")String br)
	
	{
		rb = ResourceBundle.getBundle("config");
		
		
		
		logger = LogManager.getLogger(this.getClass()); //for logging
		
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		//WebDriverManager.chromedriver().setup();
		
		 if(br.equalsIgnoreCase(br="chrome"))
		{
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		}
		
		else if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//	driver.get("https://demo.opencart.com/");
		
	driver.get(rb.getString("appURL"));
		
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Master","Sanity","Regression"})
	public void tearDown() {
		
		driver.quit();
		
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return(generatedString);
		
	}
	
	public String randomNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return(generatedString2);
		
	}
	
	public String randomAlphaNumeric()
	{
		String st = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(4);
		
		return(st+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException
	
	{
	//	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
	//	Date dt = new Date();
	//String timeStamp	= df.format(dt);
		
		
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source= takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e)
		{
			e.getMessage();
		}
		return destination;
	}

		
	
}
