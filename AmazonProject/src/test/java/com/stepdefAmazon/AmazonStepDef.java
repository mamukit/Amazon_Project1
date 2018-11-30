package com.stepdefAmazon;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.extentreportAmazon.BaseTestAmazon;
import com.generic.library.AmazonLogin;
import com.pagefactoryAmazon.AmazonPagefactory;
import com.pagefactoryAmazon.MasterPageFactory;
import com.utility.Highlighter;
import com.utility.TakeScreenShot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.emory.mathcs.backport.java.util.Collections;

public class AmazonStepDef extends BaseTestAmazon {
	WebDriver driver;
	AmazonPagefactory pf;
	int num;
	int pricesiphone;
	int random;
	ArrayList<String> iphonenames;
	ArrayList<String> iphonex;
	ArrayList<Integer> iphoneprices;
	ArrayList<String> laptopnames;
	ArrayList<Double> laptopprices;
	Object max;
	Object min;
	Select select;
	Select select1;
	WebDriverWait wait;
	Highlighter color;
	Actions ac;	

	@Given("^User able to login amazon with valid credential$")
	public void user_able_to_login_amazon_with_valid_credential() throws Throwable {
		
		AmazonLogin login = new AmazonLogin(driver);
		driver=login.getLogIn();
		pf = PageFactory.initElements(driver, MasterPageFactory.class);
		color = new Highlighter(driver);
		ac =new Actions(driver);
	
			}

	@Then("^Validate Amazon homepage$")
	public void validate_Amazon_homepage() throws Throwable {
		 String pageTitle = "Amazon";
			if(driver.getTitle().contains(pageTitle)){
				System.out.println("=================================================");
				System.out.println("Test Passed>>>> Page Title:: " + driver.getTitle());
						}
			else {
				System.out.println("Test Failed>>>> Page Title:: " + driver.getTitle());
			}
			
			Reporter.log("Page Title::"+driver.getTitle());
	}
	    	
	@Then("^take screenshot of the homepage$")
	public void take_screenshot_of_the_homepage() throws Throwable {
		//TakeScreenShot.captureScreenShot(driver, "Homepage");
	    
	}

	@Given("^User able to search for 'iphone'$")
	public void user_able_to_search_for_iphone() throws Throwable {
		
		color.drawBorder(pf.getSearchbox(),"red");
		pf.getSearchbox().sendKeys("iphone");
		pf.getSearchbox().submit();
	    
	}

	@Given("^sort the price from high to low$")
	public void sort_the_price_from_high_to_low() throws Throwable {
	select = new Select(pf.getSelect());
		select.selectByIndex(2);
	    Thread.sleep(3000);
	}

	@Then("^User able to count the number of 'iphone x'$")
	public void user_able_to_count_the_number_of_iphone_x() throws Throwable {
	  
		//list<WEBELEMENT> =pf.getIphones()
		
		
	    iphonenames = new ArrayList<String>();
	    iphonex = new ArrayList<String>();
	    
	
	    
		for(WebElement names: pf.getIphones()) {
			ac.moveToElement(names).build().perform();
			color.drawBorder(names,"red");
			iphonenames.add(names.getText().toString());
			if(names.getText().contains("iPhone X")) {
				iphonex.add(names.getText().toString());
			}
		}
		System.out.println("---------------------------------------");
		System.out.println(iphonex);
		System.out.println("---------------------------------------");
		System.out.println("Number of iphone X is: " +iphonex.size());
		
	 }

	@Then("^Find out the number of 'iphone' and 'iphone' names on the first page$")
	public void find_out_the_number_of_iphone_and_iphone_names_on_the_first_page() throws Throwable {
		int num = pf.getIphones().size();
		System.out.println("---------------------------------------");
		System.out.println("Number of iphones on the first page is " +num);
		System.out.println("---------------------------------------");
		System.out.println(iphonenames);
	    
	}

	@Then("^Find out the total number of pages$")
	public void find_out_the_total_number_of_pages() throws Throwable {
	   ac.moveToElement(pf.getPagenumber());
	   System.out.println("---------------------------------------");
		System.out.println("Total page number is:: " + pf.getPagenumber().getText());
		
		color.drawBorder(pf.getPagenumber(),"red");
	    
	}

	@When("^User able to search for 'iphone x'$")
	public void user_able_to_search_for_iphone_x() throws Throwable {
		pf.getSearchbox().clear();
		pf.getSearchbox().sendKeys("iphone x");
		color.drawBorder(pf.getSearchbox(),"red");
	    pf.getSearchbox().submit();   
	    Thread.sleep(2000);
	}

	@When("^check the 'Apple brand' checkbox$")
	public void check_the_Apple_brand_checkbox() throws Throwable {
		
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getApplecheckbox()));
		ac.moveToElement(pf.getApplecheckbox()).click().build().perform();
		color.drawBorder(pf.getApplecheckbox(),"red"); 
		Thread.sleep(2000);
   	}

	@When("^sort the price from low to high$")
	public void sort_the_price_from_low_to_high() throws Throwable {
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(pf.getSelect()));
		select.selectByIndex(1);  
		Thread.sleep(2000);
	 }

	@Then("^User able to find out the highest and lowest 'iphone x' prices on the first page$")
	public void user_able_to_find_out_the_highest_and_lowest_iphone_x_prices_on_the_first_page() throws Throwable {
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(pf.getIphonepricebig().get(0)));
	 
		
		pricesiphone = pf.getIphonepricebig().size();
	    iphoneprices =  new ArrayList<Integer>();
	    System.out.println(pricesiphone);
	
	    
	    
	    for(int i =0; i< pricesiphone; i++) {
			ac.moveToElement(pf.getIphonepricebig().get(i)).perform();
			color.drawBorder(pf.getIphonepricebig().get(i),"red");
			//System.out.println(pf.getIphonepricebig().get(i).getText());
			String x =pf.getIphonepricebig().get(i).getText().replace(",", "");
			iphoneprices.add(Integer.parseInt(x));
		}

		System.out.println(iphoneprices);
		max = Collections.max(iphoneprices);
		min = Collections.min(iphoneprices);
		System.out.println("Maximum iPhone X price is:: " + max);
		System.out.println("Minimum iPhone X price is:: " + min);
	    
	}

	@When("^User able to click on one 'iphone'$")
	public void user_able_to_click_on_one_iphone() throws Throwable {
		pf.getIphonexlist().get(0).click();
		Thread.sleep(2000);
	/*	random = ThreadLocalRandom.current().nextInt(0, pf.getIphonexlist().size());
		pf.getIphonexlist().get(random).click();*/
	 
	}

	@Then("^User able to add the item to cart$")
	public void user_able_to_add_the_item_to_cart() throws Throwable {
	
		 new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getAddtocartbtn()));
			pf.getAddtocartbtn().click();

			
			if(pf.getNothankbtn().size()>0) {
				new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getNothankbtn().get(0)));
					
				ac.moveToElement(pf.getNothankbtn().get(0)).click(pf.getNothankbtn().get(0)).build().perform();
				
				
				if(pf.getNothankbtn().size()>0) {
				Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					robot.keyRelease(KeyEvent.VK_ESCAPE);
					
				}
			}
	
		
		
		if(pf.getProceedbtn().size()>0) {
			new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getProceedbtn().get(0)));
			pf.getProceedbtn().get(0).click();
			
		}
		else {
			
			pf.getMyCartbtn().click();
			new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getProceedbtn().get(0)));
			pf.getProceedbtn().get(0).click();
		
		}
		
		//=====================================================
	
		Thread.sleep(2000);
		driver.quit();
	}
	// Scenario: two will start from here
	
	@Given("^User able to search for 'HP laptop'$")
	public void user_able_to_search_for_HP_laptop() throws Throwable {
		select1 = new Select(pf.getMerchandisechoice());
	    select1.selectByIndex(0);
	    pf.getSearchbox().clear();
	    pf.getSearchbox().sendKeys("HP laptop");
	    color.drawBorder(pf.getSearchbox(),"red");
	    pf.getSearchbox().submit();  
	}
	
	@Given("^sort the price of HP laptops from high to low$")
	public void sort_the_price_of_HP_laptops_from_high_to_low() throws Throwable {
		select = new Select(pf.getSelect());
		select.selectByIndex(2);
		Thread.sleep(2000);
	}

	@Then("^User able to find out the total number of 'HP laptop' and 'HP laptop' names on the first page$")
	public void user_able_to_find_out_the_total_number_of_HP_laptop_and_HP_laptop_names_on_the_first_page() throws Throwable {
	   
		num = pf.getLaptoplist().size();
		System.out.println("Number of laptops on page 1:: " + num);
	    System.out.println("---------------------------------------");
	    laptopnames =  new ArrayList<String>();	
	    ac.moveToElement(pf.getLaptoplist().get(0)).build().perform();
	    new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getLaptoplist().get(0)));
	    
	    for(WebElement names: pf.getLaptoplist()) {
			
				ac.moveToElement(names).build().perform();
				color.drawBorder(names, "green");
	       
			laptopnames.add(names.getText().toString());
			}
		System.out.println("List of laptops:: "+ laptopnames.toString());
	}

	@Then("^find out the total page number$")
	public void find_out_the_total_page_number() throws Throwable {
	    System.out.println("Total page number is:: " +pf.getPagenumber().getText());
	    ac.moveToElement(pf.getPagenumber()).build().perform();
	    color.drawBorder(pf.getPagenumber(),"red");
	    
	}

	@When("^User sort the price from low to high$")
	public void user_sort_the_price_from_low_to_high() throws Throwable {
		 ac.moveToElement(pf.getSelect()).build().perform();
		select = new Select(pf.getSelect());
		select.selectByIndex(1);
		Thread.sleep(2000);
		 ac.moveToElement(pf.getHPcheckbox()).build().perform();
		 new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getHPcheckbox()));
	    pf.getHPcheckbox().click();
	    color.drawBorder(pf.getHPcheckbox(),"red");
	    
	}

	@Then("^User able to find the highest and lowest 'HP laptop' price on the first page$")
	public void user_able_to_find_the_highest_and_lowest_HP_laptop_price_on_the_first_page() throws Throwable {
		
		Thread.sleep(2000);
		laptopprices  = new ArrayList<Double>();
	
		for(int i =0; i< pf.getHPprices().size(); i++) {
			
			ac.moveToElement(pf.getHPprices().get(i)).build().perform();
			 color.drawBorder(pf.getHPprices().get(i),"red");
			String x =pf.getHPprices().get(i).getText().replaceAll("\\D+","");
			laptopprices.add(Double.parseDouble(x));
		}
		System.out.println(laptopprices);
		max = Collections.max(laptopprices);
		min = Collections.min(laptopprices);
		System.out.println("Maximum HP laptop price is:: " + max);
		System.out.println("Minimum HP laptop price is:: " + min);
		     
	}
	@When("^Add one laptop in cart$")
	public void add_one_laptop_in_cart() throws Throwable {
		
		
		
		/*random = ThreadLocalRandom.current().nextInt(0, pf.getLaptoplist().size());
		pf.getLaptoplist().get(random).click()*/;
		
		pf.getLaptoplist().get(0).click();
		 new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getAddtocartbtn()));
			pf.getAddtocartbtn().click();

			if(pf.getNothankbtn().size()>0) {
				pf.getNothankbtn().get(0).click();
				
			}
			
			if(pf.getNothankbtn2().size()>0) {
				pf.getNothankbtn2().get(0).click();
				
			}
		
		if(pf.getProceedbtn().size()>0) {
			new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getProceedbtn().get(0)));
			pf.getProceedbtn().get(0).click();
			
		}
		else {
			
			pf.getMyCartbtn().getClass();
			new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getProceedbtn().get(0)));
			pf.getProceedbtn().get(0).click();
		
		}
		
	
		
		
	}

	@When("^Provide invalide payment information$")
	public void provide_invalide_payment_information() throws Throwable {
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getDeliverbtn()));
		color.drawBorder(pf.getDeliverbtn(),"red");
	    pf.getDeliverbtn().click();
	    
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getContinuebtn2()));
	    color.drawBorder(pf.getContinuebtn2(),"red");
	    pf.getContinuebtn2().click();
	    
	}
	
	
	@Then("^User not able to proceed and payment fails$")
	public void user_not_able_to_proceed_and_payment_fails() throws Throwable {
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(pf.getNameoncard()));
			pf.getNameoncard().sendKeys("Student");
		    pf.getCardnumber().sendKeys("4232345345535");
		    pf.getSelectmonth().click();
		    pf.getMonth3().click();
		    pf.getSelectyear().click();
		    pf.getYear3().click();
		    
		    TakeScreenShot.captureScreenShot(driver, "Invalid payment info");
		      pf.getAddyourcardbtn().click();
		      Thread.sleep(2000);
	}

	@Then("^take screenshot of the failed payment$")
	public void take_screenshot_of_the_failed_payment() throws Throwable {
		String problem = "There was a problem";
		Assert.assertEquals(pf.getProblemmessage().getText(), problem);
		TakeScreenShot.captureScreenShot(driver, "Cannot proceed");  
		Thread.sleep(2000);
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
		
	
	}
}
