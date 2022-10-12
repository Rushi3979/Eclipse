package Demo_13_06;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Facebook {

	public static void main(String[] args) throws Exception  {
		
		
        System.out.println("Open Browser");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Screen sc=new Screen();
		
		Pattern email=new Pattern("E:\\selenium\\Snippingtool\\Facebook\\Email.PNG");
		Pattern password=new Pattern("E:\\selenium\\Snippingtool\\Facebook\\Password.PNG");
		Pattern button=new Pattern("E:\\selenium\\Snippingtool\\Facebook\\LogIn.PNG");
		
		sc.type(email,"9767853979");
		sc.type(password,"rushi@3979");
		sc.click(button);
		
	}
}
