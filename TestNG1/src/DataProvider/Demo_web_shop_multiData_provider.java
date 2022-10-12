package DataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
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

public class Demo_web_shop_multiData_provider {
	
	public WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(String un, String ln) throws InterruptedException {
	  
	  driver.findElement(By.id("gender-male")).click();
      driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys(un);  
      driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys(ln);
      
      Thread.sleep(2000);
      
      driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();                //Logout
      
      driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();                // Register again
      
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("In Beforemethod- pageloadtimeout");
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("E:\\selenium\\ScreenShot\\MultiDataPro_DemoWebshop"));
	  
	  
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "RushiKesh", "Pune" },
      new Object[] { "Rahul", "Karvenager" },
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
