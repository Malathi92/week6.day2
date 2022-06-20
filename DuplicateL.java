package LeafTabs;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DuplicateL extends BaseL {
	
	@DataProvider(name="duplicate")
	public String [][] fetchData() throws IOException
	{
	return ReadExcel.readData("duplicatelead");

	}
//	2.Edit Lead method
	@Test(dataProvider="duplicate")
	public void duplicateLead(String email) throws InterruptedException
	{
	
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.linkText("Email")).click();
	driver.findElement(By.name("emailAddress")).sendKeys(email);
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

}
