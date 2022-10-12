package Cricbuzz;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A {

	
	public static void main(String[] args) throws IOException  {
		
		
System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome Driver\\chromedriver.exe");
		
		WebDriver wd=new ChromeDriver();
		
		wd.get("https://www.cricbuzz.com/");
		
		wd.manage().window().maximize();
		
		wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
		//wd.findElement(By.xpath("//*[@id=\"hm-scag-mtch-blk\"]/ul/li[1]/a/div/div/div[1]")).click();		
		
		
		File f= ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("E:\\selenium\\ScreenShot\\abc.png"));
		
		System.out.println("SS Done");
		
		
		
	}
}
