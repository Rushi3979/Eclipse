package Demo_13_06;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class Mercury {

	public static void main(String[] args) throws FindFailed, Exception  {
		
		
        System.out.println("Open Browser");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Screen sc=new Screen();
		
		Pattern username=new Pattern("E:\\selenium\\Snippingtool\\Mercury\\Username.PNG");
		Pattern password=new Pattern("E:\\selenium\\Snippingtool\\Mercury\\Password.PNG");
		Pattern button=new Pattern("E:\\selenium\\Snippingtool\\Mercury\\Submit.PNG");
		
		sc.type(username,"QQQQ");
		sc.type(password,"qqqq");
		sc.click(button);
		
	}
}
