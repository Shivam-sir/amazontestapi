package com.amazonautomation.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazonautomation.plainobject.PlainObjectsDemo;
import com.beust.jcommander.Parameter;

public class TestLearn {
	
	String url="https://www.amazon.in/";

	@Test
	
public void	amazonAutomation() throws InterruptedException
{
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Desktop\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Asus\\Desktop\\msedgedriver.exe");
		
		
		
		//webdriver.ie.driver
	//WebDriver driver=new ChromeDriver();
	
	WebDriver driver=new EdgeDriver();
	
	driver.get(url);
	driver.manage().window().maximize();
	
	PlainObjectsDemo  obj=PageFactory.initElements( driver ,PlainObjectsDemo.class);
	
	obj.serchProduct("mrf bat");
	obj.signIn("8318195007");
}
	
	
}
