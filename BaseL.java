package LeafTabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseL {
	//	dirver global declaration
	public ChromeDriver driver;
	//precondition
	@Parameters({"url","uName","password"})
	@BeforeMethod
	public void beforeCondition(String u,String n,String p) throws InterruptedException 
	{
		//		login functionality
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(u);
		//		driver.manage().window().maximize();
		WebElement eleUserName=driver.findElement(By.xpath("//input[@id='username']"));
		eleUserName.sendKeys(n);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(p);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	//post condition
	@AfterMethod
	public void afterCondition()
	{
		driver.close();
	}

}
