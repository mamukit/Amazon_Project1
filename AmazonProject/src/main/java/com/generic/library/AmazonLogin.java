package com.generic.library;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.joda.time.Seconds;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pagefactoryAmazon.MasterPageFactory;
import com.utility.Highlighter;
import com.utility.TakeScreenShot;

public class AmazonLogin {

	WebDriver driver;
	MasterPageFactory pf;
	Highlighter color;
	
	public AmazonLogin(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getLogIn() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		pf = PageFactory.initElements(driver, MasterPageFactory.class);
		driver.manage().window().maximize();
		driver.get(pf.getUrl());
		//implicit wait
				//HTML
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		 new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(pf.getSigninbtn()));

		pf.getSigninbtn().click();
		Thread.sleep(2000); // compile or checked
		
		pf.getEmail().sendKeys(pf.getUserName());
		//TakeScreenShot.captureScreenShot(driver, "Enter email");
		pf.getPass().sendKeys(pf.getPassword());
		//TakeScreenShot.captureScreenShot(driver, "Enter password");
		
		pf.getPass().submit();
		System.out.println(driver.getTitle());
		TakeScreenShot.captureScreenShot(driver, "Successful Login");
		
		return driver;

	}
	

}
