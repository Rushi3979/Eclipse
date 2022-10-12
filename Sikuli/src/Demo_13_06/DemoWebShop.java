package Demo_13_06;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DemoWebShop {



	public static void main(String[] args) throws Exception  {
		
		
        System.out.println("Open Browser");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(3000);
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Screen sc=new Screen();
		
		Pattern email=new Pattern("E:\\selenium\\Snippingtool\\DemoWebShop\\Email.PNG");
		Pattern password=new Pattern("E:\\selenium\\Snippingtool\\DemoWebShop\\Password.PNG");
		Pattern button=new Pattern("E:\\selenium\\Snippingtool\\DemoWebShop\\Remme.PNG");
		
		sc.type(email,"rgawade777@gmail.com");
		sc.type(password,"111111");
		sc.click(button);
		
	}
	
}
