package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hrm.common.BasePage;

public class EmployeeListPage extends BasePage
{

	public EmployeeListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="btnDelete")
private WebElement delete;
	
@FindBy(id="dialogDeleteBtn")
private WebElement ok;

@FindBy (id="menu_admin_UserManagement")
private WebElement userManagement_Menu;


@FindBy(xpath="//b[.='Admin']")
private WebElement  Admin_Menu;

@FindBy(id="menu_admin_viewSystemUsers")
private WebElement Users_menu;

public void verifyEmployeePressentInTable(String fn)
{
	String xp=("//table[@id='resultTable']//a[.=' " +fn+"]");
	System.out.println("XPATH"+fn);
	boolean empPressent=true;
	try
	{
	WebElement element=driver.findElement(By.xpath(xp));
	waitTillElementVisible(element);
	Reporter.log("PASS :Employee Pressent in Table",true);
	empPressent=true;
	}
	catch(Exception e)
	{
		Reporter.log("FAILS:Employee Not pressent in the Table",true);
		e.printStackTrace();
		empPressent=false;
	}
	Assert.assertTrue(empPressent);
}
public void selectEmployeeCheckBox(String fn1)
{
	String xp="//a[.='"+fn1+"']/../..//input[@type='checkbox']";
	driver.findElement(By.xpath(xp));
}

public void clickdelete()
{
	delete.click();
}
public void clickOk_DeleteRecordpopup()
{
	ok.click();
}

public void verifyEmployeeNotPressentInTable(String fn)
{
	
	String xp=("//table[@id='resultTable']//a[.=' " +fn+"]");
	System.out.println("Xpath"+xp);
	boolean empPressent=true;
	try
	{
	WebElement element=driver.findElement(By.xpath(xp));
	waitTillElementVisible(element);
	Reporter.log("FAILS:Employee Pressent in Table",true);
	empPressent=true;
	}
	catch(Exception e)
	{
		Reporter.log("PASS:Employee Not pressent in the Table",true);
		e.printStackTrace();
		empPressent=false;
	}
	Assert.assertFalse(empPressent);
}
public void selectEmpChkBox(String firstName)
{
String xp = "//a[.='"+firstName+"']/../..//input[@type='checkbox']";
System.out.println("XPath: " + xp);
WebElement element = driver.findElement(By.xpath(xp));
waitTillElementVisible(element);
element.click();
}

public void clickAdmin()
{
	Admin_Menu.click();	
}

public void clickAdmin_Menu(){
	waitTillElementVisible(Admin_Menu);
	Admin_Menu.click();
}


public void moveToUserManagement_Menu()
{
		waitTillElementVisible(userManagement_Menu);
		moveToElement(userManagement_Menu);
		userManagement_Menu.click();
	}
public void  clickUsers_Menu()
{
	waitTillElementVisible(userManagement_Menu);
	waitTillElementVisible(Users_menu);
	
}
}
