package DataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.sql.DriverAction;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Mercury_tours_with_Data_Provider {
	
	public WebDriver driver;
	
	
	
  @Test(dataProvider = "getData")
  public void f(String un, String pass) {
	  
	  driver.findElement(By.name("userName")).sendKeys(un);
	  driver.findElement(By.name("password")).sendKeys(pass);
	  driver.findElement(By.name("submit")).click();
	  
	 
	  
  }
  
  @BeforeMethod
  public void pageload() {
	  System.out.println("In Beforemethod- pageloadtimeout");
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  
	  
  }

  @AfterMethod
  public void Screenshot() throws IOException {
 System.out.println("In Aftermethod- ScreenShot");
	  
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("E:\\selenium\\ScreenShot\\DataProvider"));
  }


  @DataProvider
  public Object[][] getData() {
    return new Object[][] {
      new Object[] { "gdfhht", "qqdhdt" },
      new Object[] { "rbx", "fbh" },
      
    };
  }
  @BeforeClass
  public void maximize() {
	  System.out.println("In Beforeclass - maximize");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void deleteCookies() {
	  System.out.println("In Afterclass - deletecookies");
  }

  @BeforeTest
  public void enterurl() {
	  System.out.println("In Beforetest - enterurl");
	  driver.get("https://demo.guru99.com/test/newtours/");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("In Afterclass - DataBase Close");
  }

  @BeforeSuite
  public void openBrowser() {
	  System.out.println("In Before suite - OpenBrowser");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome Driver\\chromedriver.exe");
			
			 driver=new ChromeDriver();
	  
	  
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();  
  }

}
