package LeafTabs;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateL extends BaseL {
	
	@DataProvider(name="create")
	public String [][] fetchData() throws IOException
	{
	return ReadExcel.readData("createlead");
	
	}
	
	@Test(dataProvider="create")
	public void creates(String cname,String fname,String lname,String loname,String dept,String desc,String email) throws InterruptedException
	{
	
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Create Lead")).click();
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
    driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(loname);
	driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dept);
	driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
	WebElement ele = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	Select obj=new Select(ele);
	Thread.sleep(2000);
	obj.selectByVisibleText("New York");
	driver.findElement(By.name("submitButton")).click();
	System.out.println("the title is "+driver.getTitle());
	System.out.println("Create Lead");
	}
	
	
}
