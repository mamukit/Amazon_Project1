package com.stepdefAmazon;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;
import com.extentreportAmazon.BaseTestAmazon;
import com.pagefactoryAmazon.AmazonPagefactory;
import com.utility.HighLighter;
import com.utility.TakeScreenShot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.emory.mathcs.backport.java.util.Collections;

public class AmazonStepDef extends BaseTestAmazon {
	WebDriver driver;
	AmazonPagefactory apg;
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
	
		
@BeforeTest	
	@Given("^User able to open Chrome browser$")
	public void user_able_to_open_Chrome_browser() throws Throwable {
	    
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
	
			}
@Test
	@Given("^Put URL and go to home page$")
	public void put_URL_and_go_to_home_page() throws Throwable {
		driver.get("https://www.amazon.com/");
		apg = PageFactory.initElements(driver, AmazonPagefactory.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    
	}

	@When("^User enters Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Username_as_and_Password_as(String email, String password) throws Throwable{
	    apg.getSigninbtn().click();
	    apg.getEmail().sendKeys(email);
	    TakeScreenShot.captureScreenShot(driver, "Enter email");
	    apg.getEmail().submit();
	    apg.getPass().sendKeys(password);
	    
	    TakeScreenShot.captureScreenShot(driver, "Enter password");
	    apg.getPass().submit();       

	}

	@Then("^login should be successful$")
	public void login_should_be_successful() throws Throwable {
	    System.out.println(driver.getTitle());
	    TakeScreenShot.captureScreenShot(driver, "Successful Login");
	    
	}

	@Then("^Validate Amazon homepage$")
	public void validate_Amazon_homepage() throws Throwable {
	    String pageTitle = "Amazon";
		if(driver.getTitle().equalsIgnoreCase(pageTitle)){
			System.out.println("Test Passed>>>> Page Title:: " + driver.getTitle());
					}
		else {
			System.out.println("Test Failed>>>> Page Title:: " + driver.getTitle());
		}
		
		Reporter.addStepLog("Page Title::"+driver.getTitle());
	}
	    	
	@Then("^take screenshot of the homepage$")
	public void take_screenshot_of_the_homepage() throws Throwable {
		TakeScreenShot.captureScreenShot(driver, "Homepage");
	    
	}
@Test
	@Given("^User able to search for 'iphone'$")
	public void user_able_to_search_for_iphone() throws Throwable {
		apg.getSearchbox().sendKeys("iphone");
		HighLighter.getDrawRedColor(driver, apg.getSearchbox());
		apg.getSearchbox().submit();
	    Thread.sleep(2000);
	}

	@Given("^sort the price from high to low$")
	public void sort_the_price_from_high_to_low() throws Throwable {
		select = new Select(apg.getSelect());
		select.selectByIndex(2);
	    Thread.sleep(3000);
	}

	@Then("^User able to count the number of 'iphone x'$")
	public void user_able_to_count_the_number_of_iphone_x() throws Throwable {
	    num = apg.getIphones().size();
	    iphonenames = new ArrayList<String>();
	    iphonex = new ArrayList<String>();
		for(WebElement names: apg.getIphones()) {
			iphonenames.add(names.getText().toString());
			if(names.getText().contains("iPhone X")) {
				iphonex.add(names.getText().toString());
			}
		}
		System.out.println(iphonex);
		System.out.println("Number of iphone X is: " +iphonex.size());
		Thread.sleep(2000);
	 }

	@Then("^Find out the number of 'iphone' and 'iphone' names on the first page$")
	public void find_out_the_number_of_iphone_and_iphone_names_on_the_first_page() throws Throwable {
		System.out.println("Number of iphones on the first page is " +num);
		System.out.println(iphonenames);
	    
	}

	@Then("^Find out the total number of pages$")
	public void find_out_the_total_number_of_pages() throws Throwable {
	    System.out.println("Total page number is:: " + apg.getPagenumber());
		Thread.sleep(2000);
		HighLighter.getDrawBlueYellow(driver, apg.getPagenumber());
	    
	}
@Test
	@When("^User able to search for 'iphone x'$")
	public void user_able_to_search_for_iphone_x() throws Throwable {
	apg.getSearchbox().clear();
	apg.getSearchbox().sendKeys("iphone x");
	    HighLighter.getDrawRedColor(driver, apg.getSearchbox());
	    apg.getSearchbox().submit();
	    Thread.sleep(2000);
	        
	}

	@When("^check the 'Apple brand' checkbox$")
	public void check_the_Apple_brand_checkbox() throws Throwable {
		apg.getApplecheckbox().click();
		HighLighter.getDrawRedColor(driver, apg.getApplecheckbox());
	    Thread.sleep(2000);
   	}

	@When("^sort the price from low to high$")
	public void sort_the_price_from_low_to_high() throws Throwable {
		select.selectByIndex(1);
	    Thread.sleep(2000);	 
	 }

	@Then("^User able to find out the highest and lowest 'iphone x' prices on the first page$")
	public void user_able_to_find_out_the_highest_and_lowest_iphone_x_prices_on_the_first_page() throws Throwable {
	    pricesiphone = apg.getIphonepricebig().size();
	    iphoneprices =  new ArrayList<Integer>();
	    System.out.println(pricesiphone);
		for(int i =0; i< pricesiphone; i++) {
			String x =apg.getIphonepricebig().get(i).getText().replace(",", "");
			iphoneprices.add(Integer.parseInt(x));
		}
			//System.out.println(iphoneprices);
		for(int i = iphoneprices.size()-1; i >=0; i--) {
				if(iphoneprices.get(i) < 600) {
					iphoneprices.remove(i);
			}
		}
		System.out.println(iphoneprices);
		max = Collections.max(iphoneprices);
		min = Collections.min(iphoneprices);
		System.out.println("Maximum iPhone X price is:: " + max);
		System.out.println("Minimum iPhone X price is:: " + min);
	    
	}
@Test
	@When("^User able to click on one 'iphone'$")
	public void user_able_to_click_on_one_iphone() throws Throwable {
		random = ThreadLocalRandom.current().nextInt(0, apg.getIphonexlist().size());
		apg.getIphonexlist().get(random).click();
	    
	}

	@Then("^User able to add the item to cart$")
	public void user_able_to_add_the_item_to_cart() throws Throwable {
		//random = ThreadLocalRandom.current().nextInt(0, apg.getIphonexlist().size());
		try{
			apg.getAddtocartbtn().click();
			
	} catch(NoSuchElementException e) {
		driver.navigate().back();
		Thread.sleep(2000);
		apg.getIphonexlist().get(random).click();
		apg.getAddtocartbtn().click();
	}
		try {
			apg.getNothankbtn().click();
		}  catch (NoSuchElementException|ElementNotVisibleException exc){
			//apg.getSearchbox().click();
		}
	}
@Test
	@Given("^User able to search for 'HP laptop'$")
	public void user_able_to_search_for_HP_laptop() throws Throwable {
		select1 = new Select(apg.getMerchandisechoice());
	    select1.selectByIndex(0);
	    //Thread.sleep(2000);
	    apg.getSearchbox().clear();
	    apg.getSearchbox().sendKeys("HP laptop");
	    HighLighter.getDrawRedColor(driver, apg.getSearchbox());
	    apg.getSearchbox().submit();
	    Thread.sleep(2000);
	}
	
	@Given("^sort the price of HP laptops from high to low$")
	public void sort_the_price_of_HP_laptops_from_high_to_low() throws Throwable {
		select.selectByIndex(2);
		Thread.sleep(2000);
	}

	@Then("^User able to find out the total number of 'HP laptop' and 'HP laptop' names on the first page$")
	public void user_able_to_find_out_the_total_number_of_HP_laptop_and_HP_laptop_names_on_the_first_page() throws Throwable {
	    num = apg.getLaptoplist().size();
	    laptopnames =  new ArrayList<String>();	
		for(WebElement names: apg.getLaptoplist()) {
			laptopnames.add(names.getText().toString());
				
			}
		System.out.println("Number of laptops on page 1:: " + num);
		System.out.println("List of laptops:: "+ laptopnames);
	    
	}

	@Then("^find out the total page number$")
	public void find_out_the_total_page_number() throws Throwable {
	    System.out.println("Total page number is:: " +apg.getPagenumber());
	    Thread.sleep(2000);
		HighLighter.getDrawBlueYellow(driver, apg.getPagenumber());
	}

	@When("^User sort the price from low to high$")
	public void user_sort_the_price_from_low_to_high() throws Throwable {
		select.selectByIndex(1);
	    Thread.sleep(2000);
	    //wait = new WebDriverWait(driver, 10);
	    //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(apg.getHPcheckbox()));
	    apg.getHPcheckbox().click();
	    HighLighter.getDrawBlueYellow(driver, apg.getHPcheckbox());
	    Thread.sleep(2000);
	}

	@Then("^User able to find the highest and lowest 'HP laptop' price on the first page$")
	public void user_able_to_find_the_highest_and_lowest_HP_laptop_price_on_the_first_page() throws Throwable {
		laptopprices  = new ArrayList<Double>();
		for(int i =0; i< apg.getHPprices().size(); i++) {
			String x =apg.getHPprices().get(i).getText().replace("$", "");
			laptopprices.add(Double.parseDouble(x));
		}
		System.out.println(laptopprices);
		max = Collections.max(laptopprices);
		min = Collections.min(laptopprices);
		System.out.println("Maximum HP laptop price is:: " + max);
		System.out.println("Minimum HP laptop price is:: " + min);
			    
	}
@Test
	@When("^User able to select one 'HP laptop'$")
	public void user_able_to_select_one_HP_laptop() throws Throwable {
		random = ThreadLocalRandom.current().nextInt(0, apg.getHPlist().size());
		apg.getHPlist().get(random).click();
		Thread.sleep(2000);
	}

	@Then("^User able to add the new item to cart$")
	public void user_able_to_add_the_new_item_to_cart() throws Throwable {
		try{
			apg.getAddtocartbtn().click();
			
	} catch(NoSuchElementException e) {
		driver.navigate().back();
		Thread.sleep(2000);
		apg.getHPlist().get(random).click();
		apg.getAddtocartbtn().click();
	}
		
	}
	

	@When("^User able to proceed to cart$")
	public void user_able_to_proceed_to_cart() throws Throwable {
	Thread.sleep(2000);
		try {
			apg.getNothankbtn().click();
			
		}  catch (NoSuchElementException e){
			
					}
		try {
			apg.getNothankbtn2().click();
			
		}  catch (NoSuchElementException e){
			
					}
		apg.getProceedbtn().click();
	} 
	
	@When("^User enters his email and password$")
	public void user_enters_his_email_and_password() throws Throwable {
		apg.getEmail().sendKeys("tuan_nguyen30412@hotmail.com");
		apg.getEmail().submit();
		apg.getPass().sendKeys("Voiu30412");
		apg.getPass().submit();
	}

	@Then("^click on the 'Deliver' button$")
	public void click_on_the_Deliver_button() throws Throwable {
		HighLighter.getDrawBlueColor(driver, apg.getDeliverbtn());
	    apg.getDeliverbtn().click();
	    Thread.sleep(2000);
	    
	}

	@Then("^click on the 'Continue' button$")
	public void click_on_the_Continue_button() throws Throwable {
		HighLighter.getDrawBlueColor(driver, apg.getContinuebtn2());
	    apg.getContinuebtn2().click();
	    Thread.sleep(2000);
	    
	}

	@When("^User enter invalid name on card as \"([^\"]*)\" and card number as \"([^\"]*)\"$")
	public void user_enter_invalid_name_on_card_as_and_card_number_as(String nameoncard, String cardnumber) throws Throwable {
	    apg.getNameoncard().sendKeys(nameoncard);
	    apg.getCardnumber().sendKeys(cardnumber);
	    Thread.sleep(2000);
	}

	@When("^select expired month and year$")
	public void select_expired_month_and_year() throws Throwable {
	    apg.getSelectmonth().click();
	    apg.getMonth3().click();
	    apg.getSelectyear().click();
	    apg.getYear3().click();
	    TakeScreenShot.captureScreenShot(driver, "Invalid payment info");
	    
	}

	@When("^User click on the 'Add your card' button$")
	public void user_click_on_the_Add_your_card_button() throws Throwable {
	    apg.getAddyourcardbtn().click();
	    
	    
	}

	@Then("^User not able to proceed and payment fails$")
	public void user_not_able_to_proceed_and_payment_fails() throws Throwable {
		String problem = "There was a problem";
		Assert.assertEquals(apg.getProblemmessage().getText(), problem);
		
	}

	@Then("^take screenshot of the failed payment$")
	public void take_screenshot_of_the_failed_payment() throws Throwable {
		TakeScreenShot.captureScreenShot(driver, "Cannot proceed");
	    
	}
@AfterTest	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

}
