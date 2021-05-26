package org.one;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) 
	{
	String xpath="	.//table[@name='BookTable']/tbody/tr/td[4]";
	 String text="";
	 int a=0;
		String key="webdriver.chrome.driver";
		String value="E:\\BrowserDrivers\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("E:/Demohtml/Tables.html");
	 List<WebElement> cost = driver.findElements(By.xpath(xpath));
	 int count=cost.size();
	 for(int i=0;i<count;i++)
	 {
		 WebElement el=cost.get(i);
		  text=el.getText();
		   a=Integer.parseInt(String.valueOf(text));
		   
		if(a>=300&&a<=2000)
		{
			System.out.println(a);
		}
	 }
		 
		 

		}
	 
		

}
