package com.pagefactoryAmazon;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPagefactory {

	WebDriver driver;
public AmazonPagefactory(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy (how = How.XPATH, using = "//*[@id ='nav-link-accountList']")
private WebElement signinbtn;
@FindBy (how = How.XPATH, using = "//*[@id ='ap_email']")
private WebElement email;
@FindBy (how = How.CSS, using = "#ap_password")
private WebElement pass;
@FindBy (how = How.XPATH, using = "//*[@id='twotabsearchtextbox']")
private WebElement searchbox;
@FindBy (how = How.XPATH, using = "//*[@id='sort']")
private WebElement select;
@FindBy (how = How.XPATH, using = "//ul[@id='s-results-list-atf']/li/div/div/div/div[2]/div/div/a")
private List<WebElement> iphones;
@FindBy (how = How.XPATH, using = "//span[@class='pagnDisabled']")
private WebElement pagenumber;
@FindBy (how = How.XPATH, using = "//*[@name ='s-ref-checkbox-Apple']")
private WebElement Applecheckbox;
@FindBy (how = How.XPATH, using = "//*[@class = 'sx-price-whole']")
private List<WebElement> iphonepricebig;
@FindBy (how = How.XPATH, using = "//h2[contains(text(), 'iPhone X')]|//h2[contains(text(), 'Iphone X')]")
private List<WebElement> iphonexlist;
@FindBy (how = How.XPATH, using = "//input[@value= 'Add to Cart']")
private WebElement addtocartbtn;
@FindBy (how = How.XPATH, using = "//*[@id = 'searchDropdownBox']")
private WebElement merchandisechoice;
@FindBy (how = How.XPATH, using = "//*[@class = 'a-size-medium s-inline  s-access-title  a-text-normal']")
private List<WebElement> laptoplist;
@FindBy (how = How.XPATH, using = "//*[@name = 's-ref-checkbox-HP']")
private WebElement HPcheckbox;
@FindBy (how = How.XPATH, using = "//*[@class = 'a-size-small a-link-normal a-text-normal']/span[2]|//*[@class = 'sx-price-whole']")
private List<WebElement> HPprices;
@FindBy (how = How.XPATH, using = "//*[@class='a-size-medium s-inline  s-access-title  a-text-normal']")
private List<WebElement> HPlist;
@FindBy (how = How.XPATH, using = "//*[@id ='siNoCoverage-announce']")
private WebElement nothankbtn;
@FindBy (how = How.XPATH, using = "//*[contains(text(),'No thanks')]")
private WebElement nothankbtn2;
@FindBy (how = How.XPATH, using = "(//*[contains(text(), 'Proceed to checkout')])[1]")
private WebElement proceedbtn;
@FindBy (how = How.XPATH, using = "(//*[@class ='a-declarative a-button-text '])[1]")
private WebElement deliverbtn;
@FindBy (how = How.XPATH, using = "(//input[@type ='submit'])[1]")
private WebElement continuebtn2;
@FindBy (how = How.XPATH, using = "//*[@id = 'ccName']")
private WebElement nameoncard;
@FindBy (how = How.XPATH, using = "//*[@id = 'addCreditCardNumber']")
private WebElement cardnumber;
@FindBy (how = How.XPATH, using = "(//*[@class = 'a-button-text a-declarative'])[1]")
private WebElement selectmonth;
@FindBy (how = How.XPATH, using = "//*[@id = '1_dropdown_combobox']/li[3]")
private WebElement month3;
@FindBy (how = How.XPATH, using = "(//*[@class = 'a-button-text a-declarative'])[2]")
private WebElement selectyear;
@FindBy (how = How.XPATH, using = "//*[@id = '2_dropdown_combobox']/li[3]")
private WebElement year3;
@FindBy (how = How.XPATH, using = "//*[@id ='ccAddCard']")
private WebElement addyourcardbtn;
@FindBy (how = How.XPATH, using = "(//h4[contains(text(), 'There was a problem')])[1]")
private WebElement problemmessage;
public WebElement getSigninbtn() {
	return signinbtn;
}
public WebElement getEmail() {
	return email;
}
public WebElement getPass() {
	return pass;
}
public WebElement getSearchbox() {
	return searchbox;
}
public WebElement getSelect() {
	return select;
}
public List<WebElement> getIphones() {
	return iphones;
}
public WebElement getPagenumber() {
	return pagenumber;
}
public WebElement getApplecheckbox() {
	return Applecheckbox;
}
public List<WebElement> getIphonepricebig() {
	return iphonepricebig;
}
public List<WebElement> getIphonexlist() {
	return iphonexlist;
}
public WebElement getAddtocartbtn() {
	return addtocartbtn;
}
public WebElement getMerchandisechoice() {
	return merchandisechoice;
}
public List<WebElement> getLaptoplist() {
	return laptoplist;
}
public WebElement getHPcheckbox() {
	return HPcheckbox;
}
public List<WebElement> getHPprices() {
	return HPprices;
}
public List<WebElement> getHPlist() {
	return HPlist;
}
public WebElement getNothankbtn() {
	return nothankbtn;
}
public WebElement getNothankbtn2() {
	return nothankbtn2;
}
public WebElement getProceedbtn() {
	return proceedbtn;
}
public WebElement getDeliverbtn() {
	return deliverbtn;
}
public WebElement getContinuebtn2() {
	return continuebtn2;
}
public WebElement getNameoncard() {
	return nameoncard;
}
public WebElement getCardnumber() {
	return cardnumber;
}
public WebElement getSelectmonth() {
	return selectmonth;
}
public WebElement getMonth3() {
	return month3;
}
public WebElement getSelectyear() {
	return selectyear;
}
public WebElement getYear3() {
	return year3;
}
public WebElement getAddyourcardbtn() {
	return addyourcardbtn;
}
public WebElement getProblemmessage() {
	return problemmessage;
}








}
