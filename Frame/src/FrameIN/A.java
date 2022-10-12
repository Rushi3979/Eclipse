package FrameIN;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

// Drag and drop




import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A {

	public static void main(String[] args) throws IOException {
	

		
		
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome Driver\\chromedriver.exe");
				
				WebDriver wd=new ChromeDriver();
				
				wd.get("https://javascript.info/mouse-drag-and-drop");
				
				wd.manage().window().maximize();
				
				wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				
				
				Actions at=new Actions(wd);
				
				// First frame
			WebElement fr=	wd.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[1]/article/div[2]/div[11]/div[2]/div[1]/iframe"));
				wd.switchTo().frame(fr);
				
			WebElement ball=	wd.findElement(By.xpath("//*[@id=\"ball\"]"));
			WebElement goll=	wd.findElement(By.xpath("//*[@id=\"gate\"]"));
				
	at.dragAndDrop(ball, goll).build().perform();
	
	// frame back
	wd.switchTo().defaultContent();
	
at.doubleClick(	wd.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/nav/ul/li[1]/a"))).build().perform();
	
      File f=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile( f, new File("E:\\selenium\\ScreenShot\\drag.png"));



	}


}
