package Attributes;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SubClassAttributes extends BaseClassAttributes {

	//		1.create lead method
//	set invocationCount for createLead
	@Test(priority=2,invocationCount=2)
	public void createLead() throws InterruptedException
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("MALATHI");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("E");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("LocalName");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CORE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Grow with leaf");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("emalathi21@gmail.com");
		WebElement ele = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select obj=new Select(ele);
		Thread.sleep(2000);
		obj.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		System.out.println("the title is "+driver.getTitle());
		System.out.println("Create Lead");
	}
	//		2.Edit Lead method
	@Test(priority=3,dependsOnMethods={"duplicateLead"})
	public void editLead() throws InterruptedException
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		System.out.println("the title is:"+driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Qualify Lead']/following-sibling::a")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("wipro");
		driver.findElement(By.name("submitButton")).click();
		WebElement s=driver.findElement(By.id("viewLead_companyName_sp"));
		System.out.println("the changed name is:"+s.getText());
		System.out.println("Edit lead");
	}
	//		3.Duplicate Lead

	@Test(priority=1)
	public void duplicateLead() throws InterruptedException
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("babu@testleaf.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String r=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[text()='Babu']")).getText();
		System.out.println(r);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[text()='Babu']")).click();
		String n=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(n);
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		System.out.println("the title is: "+driver.getTitle());
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String m=driver.findElement(By.id("viewLead_companyName_sp")).getText();

		System.out.println(m);
		if(n.equals(m))
		{
			System.out.println("duplicate record having same name as actual record");
		}
		else
		{
			System.out.println("record names are different");
		}
		System.out.println("duplicate Lead");
	}
	//4.Delete Lead method
//	
	@Test(enabled=false)
	public void deleteLead() throws InterruptedException
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9095326910");
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(text); 
		driver.findElement(By.className("x-btn-text")).click();
		if(driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).isDisplayed())

		{
			System.out.println("no records to display");

		}
		else
		{
			System.out.println("records available");
		}

		System.out.println("Delete lead");
	}
	//		5.Merge contact
//	set priority 1 for merge contact
	@Test(priority=0)
	public void mergeContact() throws InterruptedException
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		System.out.println(driver.getTitle());
		//1st icon * 7. Click on Widget of From Contact
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
		Thread.sleep(2000);
		//		 8. Click on First Resulting Contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(newWindow.get(0));
		//		//1st icon * 9. Click on Widget of To Contact
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> newWindow1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(newWindow1.get(1));
		//    * 10. Click on Second Resulting Contact
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[2]")).click();
		driver.switchTo().window(newWindow1.get(0));
		//		 * 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		//		 * 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println("Merge Contact");
	}

}


