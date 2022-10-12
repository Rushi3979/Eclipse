package DataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
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

public class Demo_Web_Shop {
	
	public WebDriver driver;
	
  @Test(dataProvider = "gatData")
  public void f(String un, String ln) {
	  
	  driver.findElement(By.id("gender-male")).click();
      driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys(un);  
      driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys(ln);
  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("In Beforemethod- pageloadtimeout");
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	  
      System.out.println("In Aftermethod- ScreenShot");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("E:\\selenium\\ScreenShot\\DataProvider"));
  }


  @DataProvider
  public Object[][] gatData() {
    return new Object[][] {
      new Object[] { "Rushi", "Gawade" }
      
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("In Beforeclass - maximize");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("In Afterclass - deletecookies");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("In Beforetest - enterurl");
	  driver.get("http://demowebshop.tricentis.com/register");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("In Afterclass - DataBase Close");
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println("In Before suite - OpenBrowser");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome Driver\\chromedriver.exe");
			 driver=new ChromeDriver();
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();  
  }

}
