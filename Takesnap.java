package com.faq;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





public class Takesnap {

	public static void main(String[] args) throws IOException 
	{
	System.setProperty("webdriver.chrome.driver", "E:/BrowserDrivers/chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("http://www.google.com");
	WebElement google=driver.findElement(By.id("hplogo" ));
	Point p= google.getLocation();
	int w=google.getSize().getWidth();
	int h=google.getSize().getHeight();
	TakesScreenshot screen= (TakesScreenshot)driver;
	File src= screen.getScreenshotAs(OutputType.FILE);
	File path=new File("E:/google.png");
	BufferedImage  fullImg = ImageIO.read(src);	
	BufferedImage finalimage=fullImg.getSubimage(p.x,p.y,  w, h);
	ImageIO.write(finalimage, "png",src );
	FileUtils.copyFile(src, path);
	}

}
