package com.pagefactoryAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MasterPageFactory extends AmazonPagefactory{

	public MasterPageFactory(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

}
