package com.modelcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import edu.emory.mathcs.backport.java.util.Collections;

public class ModelCode {
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		ArrayList<String> iphonenames = new ArrayList<String>();
		ArrayList<String> iphonex = new ArrayList<String>();
		ArrayList<Integer> iphoneprices = new ArrayList<Integer>();
		ArrayList<String> laptopnames = new ArrayList<String>();	
		ArrayList<Double> laptopprices = new ArrayList<Double>();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Login with valid credentials
		WebElement signinbtn= driver.findElement(By.xpath("//*[@id ='nav-link-accountList']"));
		signinbtn.click();
		
		WebElement email = driver.findElement(By.xpath("//*[@id ='ap_email']"));
		email.sendKeys("tuan_nguyen30412@hotmail.com");
		email.submit();
		
		WebElement pass = driver.findElement(By.cssSelector("#ap_password"));
		pass.sendKeys("Voiu30412");
		pass.submit();
		
		//Validate Amazon homepage
		if(driver.getTitle().equalsIgnoreCase("Amazon")){
			System.out.println("Test Passed>>>> Page Title:: " + driver.getTitle());
					}
		else {
			System.out.println("Test Failed>>>> Page Title:: " + driver.getTitle());
		}
		
		//Search iphone
		WebElement searchbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchbox.sendKeys("iphone");
		searchbox.submit();
		
		//Sort high to low price
//		WebElement sort = driver.findElement(By.xpath("//*[contains(text(), 'Featured')]"));
//		sort.click();
//		WebElement sortlist = driver.findElement(By.xpath("//*[contains(text(), 'Price: High to Low')]"));
//		sortlist.click();
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id='sort']")));
		select.selectByIndex(2);
		
		
		//Find all iphone and total iphone number (model x) in 1st page
		Thread.sleep(3000);
		List<WebElement> iphones = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li/div/div/div/div[2]/div/div/a"));
		int num = iphones.size();
		for(WebElement names: iphones) {
			iphonenames.add(names.getText().toString());
			if(names.getText().contains("iPhone X")) {
				iphonex.add(names.getText().toString());
				
			}
			
		}
		System.out.println(iphonex);
		System.out.println("Number of iphone X is: " +iphonex.size());
		System.out.println("Number of iphones on the first page is " +num);
		System.out.println(iphonenames);
		Thread.sleep(3000);
		//Find out total page number
		WebElement pagenumber = driver.findElement(By.xpath("//span[@class='pagnDisabled']"));
		System.out.println("Total page number is:: " + pagenumber.getText());
		Thread.sleep(3000);
		
		//sort Low to High price
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='twotabsearchtextbox']")));
		WebElement searchbox1 = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchbox1.clear();
		searchbox1.sendKeys("iphone x");
		searchbox1.submit();
		Thread.sleep(3000);
		WebElement Applecheckbox = driver.findElement(By.xpath("//*[@name ='s-ref-checkbox-Apple']"));
		Applecheckbox.click();
		Thread.sleep(3000);
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id='sort']")));
		Thread.sleep(3000);
		select1.selectByIndex(1);
		Thread.sleep(3000);
		//find out highest and lowest available price of iphoneX

		List<WebElement> iphonepricebig = driver.findElements(By.xpath("//*[@class = 'sx-price-whole']"));
		System.out.println("number of iphone price printed large:: "+ iphonepricebig.size());

		for(int i =0; i< iphonepricebig.size(); i++) {
			String x =iphonepricebig.get(i).getText().replace(",", "");
			iphoneprices.add(Integer.parseInt(x));
		}
			System.out.println(iphoneprices);
		for(int i = iphoneprices.size()-1; i >=0; i--) {
				if(iphoneprices.get(i) < 600) {
					iphoneprices.remove(i);
			}
		}
System.out.println(iphoneprices);
		Object max = Collections.max(iphoneprices);
		Object min = Collections.min(iphoneprices);
		System.out.println("Maximum iPhone X price is:: " + max);
		System.out.println("Minimum iPhone X price is:: " + min);
		
		//Add 1 iphone in cart
		
List<WebElement> iphonexlist = driver.findElements(By.xpath("//h2[contains(text(), 'iPhone X')]|//h2[contains(text(), 'Iphone X')]"));
int random = ThreadLocalRandom.current().nextInt(0, iphonexlist.size());
iphonexlist.get(random).click();
		WebElement addtocartbtn = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
		
		if(addtocartbtn.isDisplayed()) {
			addtocartbtn.click();
			Thread.sleep(3000);
	} else {
		driver.navigate().back();
		Thread.sleep(3000);
		iphonexlist.get(random).click();
		Thread.sleep(3000);
		addtocartbtn.click();
	}
		
//		WebElement nothankbtn2 = driver.findElement(By.xpath("//*[@id='siNoCoverage-announce']"));
//	if(nothankbtn2.isDisplayed()) {
//		nothankbtn2.click();
//	}
		
		//Search HP laptop
	
	Select merchandisechoice = new Select(driver.findElement(By.xpath("//*[@id = 'searchDropdownBox']")));
	Thread.sleep(2000);
	merchandisechoice.selectByIndex(0);
	
	Thread.sleep(2000);
	
	WebElement searchbox2 = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
	searchbox2.clear();
	searchbox2.sendKeys("HP laptop");
	searchbox2.submit();
	Thread.sleep(3000);
	
	//sort price high to low
	Select select2 = new Select(driver.findElement(By.xpath("//*[@id='sort']")));
	Thread.sleep(3000);
	select2.selectByIndex(2);
	Thread.sleep(3000);
	
	//Find all laptop and total number display in page one
	List<WebElement> laptoplist = driver.findElements(By.xpath("//*[@class = 'a-size-medium s-inline  s-access-title  a-text-normal']"));
	int num1 = laptoplist.size();
	for(WebElement names: laptoplist) {
		laptopnames.add(names.getText().toString());
			
		}
	System.out.println("Number of laptops on page 1:: " + num1);
	System.out.println("List of laptops:: "+ laptopnames);
	
	//total page number
	WebElement pagenumber1 = driver.findElement(By.xpath("//*[@class = 'pagnDisabled']"));
	System.out.println("Total page number is:: " +pagenumber1.getText());
	Thread.sleep(3000);	
	//sort Low to High price
	Select select3 = new Select(driver.findElement(By.xpath("//*[@id='sort']")));
	Thread.sleep(3000);
	select3.selectByIndex(1);
	Thread.sleep(3000);
	//Find out highest and lowest price HP laptop
	WebElement HPcheckbox = driver.findElement(By.xpath("//*[@name = 's-ref-checkbox-HP']"));
	HPcheckbox.click();
	Thread.sleep(3000);
	List<WebElement> HPprices = driver.findElements(By.xpath("//*[@class = 'a-size-small a-link-normal a-text-normal']/span[2]|//*[@class = 'sx-price-whole']"));
	for(int i =0; i< HPprices.size(); i++) {
		String x =HPprices.get(i).getText().replace("$", "");
		laptopprices.add(Double.parseDouble(x));
	}
	System.out.println(laptopprices);
	Object maxprice = Collections.max(laptopprices);
	Object minprice = Collections.min(laptopprices);
	System.out.println("Maximum HP laptop price is:: " + maxprice);
	System.out.println("Minimum HP laptop price is:: " + minprice);
	//Add one laptop in cart
	List<WebElement> HPlist = driver.findElements(By.xpath("//*[@class='a-size-medium s-inline  s-access-title  a-text-normal']"));
	Thread.sleep(3000);
	int random1 = ThreadLocalRandom.current().nextInt(0, HPlist.size());
	HPlist.get(random1).click();
	
	WebElement addtocartbtn1 = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
	if(addtocartbtn1.isDisplayed()) {
			addtocartbtn1.click();
			Thread.sleep(3000);
	} else {
		driver.navigate().back();
		Thread.sleep(3000);
		HPlist.get(random1).click();
		addtocartbtn1.click();
	}
	Thread.sleep(3000);
	WebElement nothankbtn = driver.findElement(By.xpath("//*[@id='siNoCoverage-announce']"));
	if(nothankbtn.isDisplayed()) {
		nothankbtn.click();
	}
	Thread.sleep(3000);
	//Provide invalid payment information
	WebElement proceedbtn = driver.findElement(By.xpath("(//*[contains(text(), 'Proceed to checkout')])[1]"));
	proceedbtn.click();
	Thread.sleep(3000);
	
	//for new account to enter new address
//	WebElement namebox = driver.findElement(By.xpath("(//*[@class = 'enterAddressFormField validateInputCharactersOnBlur'])[1]"));
//	namebox.sendKeys("Tuan Nguyen");
//	WebElement addressbox = driver.findElement(By.xpath("(//*[@class = 'enterAddressFormField validateInputCharactersOnBlur'])[2]"));
//	addressbox.sendKeys("2590 Grand Ave");
//	WebElement citybox = driver.findElement(By.xpath("(//*[@class = 'enterAddressFormField validateInputCharactersOnBlur'])[4]"));
//	citybox.sendKeys("New York");
//	WebElement statebox = driver.findElement(By.xpath("(//*[@class = 'enterAddressFormField validateInputCharactersOnBlur'])[5]"));
//	statebox.sendKeys("NY");
//	WebElement zipbox = driver.findElement(By.xpath("(//*[@class = 'enterAddressFormField validateInputCharactersOnBlur'])[6]"));
//	zipbox.sendKeys("10468");
//	WebElement phonenumberbox = driver.findElement(By.xpath("(//*[@class = 'enterAddressFormField validateInputCharactersOnBlur'])[7]"));
//	phonenumberbox.sendKeys("7184067650");
//	WebElement continuebtn = driver.findElement(By.xpath("//input[@type ='submit']"));
//	continuebtn.click();
	

	WebElement deliverbtn = driver.findElement(By.xpath("(//*[@class ='a-declarative a-button-text '])[1]"));
	deliverbtn.click();
	Thread.sleep(3000);
	
	WebElement continuebtn2 = driver.findElement(By.xpath("(//input[@type ='submit'])[1]"));
	continuebtn2.click();
	
	WebElement nameoncard = driver.findElement(By.xpath("//*[@id = 'ccName']"));
	nameoncard.sendKeys("Peter Michaels");
	WebElement cardnumber = driver.findElement(By.xpath("//*[@id = 'addCreditCardNumber']"));
	cardnumber.sendKeys("3112118191467841");
	
	Thread.sleep(3000);
	WebElement selectmonth= driver.findElement(By.xpath("(//*[@class = 'a-button-text a-declarative'])[1]"));
	selectmonth.click();
	WebElement month3= driver.findElement(By.xpath("//*[@id = '1_dropdown_combobox']/li[3]"));
	month3.click();
	Thread.sleep(3000);
	WebElement selectyear= driver.findElement(By.xpath("(//*[@class = 'a-button-text a-declarative'])[2]"));
	selectyear.click();
	WebElement year3= driver.findElement(By.xpath("//*[@id = '2_dropdown_combobox']/li[3]"));
	year3.click();

	//Validate as payment will fail
	WebElement addyourcardbtn = driver.findElement(By.xpath("//*[@id ='ccAddCard']"));
	addyourcardbtn.click();
	boolean problemmessage = driver.findElement(By.xpath("(//*[@class ='a-icon a-icon-alert'])[2]")).isDisplayed();
	Assert.assertTrue(problemmessage, "Valid Payment");

	
	
	
	
}
}