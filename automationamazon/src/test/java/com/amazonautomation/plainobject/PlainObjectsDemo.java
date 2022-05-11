package com.amazonautomation.plainobject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;



public class PlainObjectsDemo {

	WebDriver driver;
	
	public PlainObjectsDemo(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@FindBy (how=How.NAME ,using="field-keywords")
	private WebElement prod_search;
	
	@FindBy (how=How.ID ,using="nav-search-submit-button")
	private WebElement submit_search;
	
	
	@FindBy (how=How.LINK_TEXT,using="MRF 1CT15110 Champ Kashmir Willow Cricket Bat, Size 5, Multi Color")
	private WebElement pic_element;
	
	
	
	@FindBy (how=How.ID,using="buy-now-button")
	private WebElement buynow;
	
	
	@FindBy (how=How.XPATH,using="//*[@id=\"ap_email\"]")
	private WebElement enteruserID;
	
	
	@FindBy (how=How.ID,using="continue")
	private WebElement useridsubmit;

	
	
	@FindBy (how=How.XPATH,using="//*[@id=\"continue\"]")
	private WebElement userotp;
	
	
	@FindBy (how=How.XPATH,using="//*[@id=\"cvf-input-code\"]")
	private WebElement enterotp;
	
	//*[@id="cvf-input-code"]
	
	public void searchElements(String ele)
	{
		prod_search.sendKeys(ele);
		Reporter.log("Element is entered "+ele,true);
	}
	
	public void submitSearch()
	{
		submit_search.click();
		Reporter.log("search icon is clicked",true);
	}
	public void pickDesiredProduct()
	{
		pic_element.click();
		Reporter.log("product is selected ",true);
	}
	
	public void buyNow()
	{
		buynow.click();
		Reporter.log("buynow is clicked  ",true);
	}
	
	public void enterUserID(String user)
	{
		enteruserID.sendKeys(user);
	}
	
	public void clickLogin()
	{
		useridsubmit.click();
	}
	
	//otp
	
	public void otpLogin()
	{
		userotp.click();
	}
	
	public void enterOTP()
	{
		enterotp.submit();
	}
	
	public void serchProduct(String element)
	{
		searchElements(element);
		submitSearch();
		pickDesiredProduct();
		System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		for(String x:windowHandles)
		{
			driver.switchTo().window(x);
		}
		
		buyNow();
		System.out.println(driver.getTitle());
		String actual=driver.getTitle();
		String expected="Amazon.in : mrf bat";
		
		//Assert.assertEquals(actual, expected ,"Not able to search correctly");
		Reporter.log("element searched "+element,true);
	}
	
	
	
	
	public void signIn(String ele) throws InterruptedException
	{
		enterUserID(ele);
		clickLogin();
		otpLogin();
		TimeUnit.SECONDS.sleep(20);
		enterOTP();
	}

}
