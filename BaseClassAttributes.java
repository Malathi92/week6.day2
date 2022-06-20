package Attributes;


	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClassAttributes {
		//	dirver global declaration
		ChromeDriver driver;
		//precondition
		@BeforeMethod
		public void beforeCondition() throws InterruptedException 
		{
//			login functionality
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
//			driver.manage().window().maximize();
			WebElement eleUserName=driver.findElement(By.xpath("//input[@id='username']"));
			eleUserName.sendKeys("DemoSalesManager");
	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		}

	//post condition
		@AfterMethod
		public void afterCondition()
		{
			driver.close();
		}

	}








