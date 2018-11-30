package com.pagefactoryAmazon;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class AmazonPagefactory {

	WebDriver driver;
public AmazonPagefactory(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy (xpath = "//*[@id ='nav-link-accountList']")
private WebElement signinbtn;
@FindBy (xpath = "//*[@id ='ap_email']")
private WebElement email;
@FindBy (how = How.CSS, using = "#ap_password")
private WebElement pass;
@FindBy (xpath = "//*[@id='twotabsearchtextbox']")
private WebElement searchbox;
@FindBy (xpath = "//*[@id='sort']")
private WebElement select;
@FindBy (xpath = "//ul[@id='s-results-list-atf']/li/div/div/div/div[2]/div/div/a")
private List<WebElement> iphones;
@FindBy (xpath = "//span[@class='pagnDisabled']")
private WebElement pagenumber;
@FindBy (xpath = "//*[contains(@name ,'checkbox-Apple')]")
private WebElement Applecheckbox;
@FindBy (xpath = "//*[@class = 'sx-price-whole']")
private List<WebElement> iphonepricebig;


@FindBy (xpath = "//h2[contains(text(), 'iPhone X')]|//h2[contains(text(), 'Iphone X')]")
private List<WebElement> iphonexlist;

private String url= "https://www.amazon.com/";
private String userName="studentttech@gmail.com";
private String password ="student123";



@FindBy (xpath = "//*[contains(text(),'Cart')]")
private WebElement myCartbtn;
@FindBy (xpath = "//input[@value= 'Add to Cart']")
private WebElement addtocartbtn;
@FindBy (xpath = "//*[@id = 'searchDropdownBox']")
private WebElement merchandisechoice;
@FindBy (xpath = "//*[@class='a-fixed-left-grid']//*[name()='h2']")
private List<WebElement> laptoplist;
@FindBy (xpath = "//*[@name = 's-ref-checkbox-HP']")
private WebElement HPcheckbox;
@FindBy (xpath = "//*[@class='a-fixed-left-grid']//*[@class='a-size-base a-color-base' or @class='sx-price-whole']")
private List<WebElement> HPprices;
/*@FindBy (xpath = "//*[@class='a-size-medium s-inline  s-access-title  a-text-normal']")
private List<WebElement> HPlist;*/
@FindBy (xpath = "//*[contains(text(),'No Thanks')]")
private List<WebElement> nothankbtn;
@FindBy (xpath = "//*[contains(text(),'No thanks')]")
private List<WebElement> nothankbtn2;
@FindBy (xpath = "(//*[contains(text(), 'Proceed to checkout')])[1]")
private List<WebElement> proceedbtn;
@FindBy (xpath = "(//*[@class ='a-declarative a-button-text '])[1]")
private WebElement deliverbtn;
@FindBy (xpath = "(//input[@type ='submit'])[1]")
private WebElement continuebtn2;
@FindBy (xpath = "//*[@id = 'ccName']")
private WebElement nameoncard;


@FindBy (xpath = "//*[@id='a-autoid-0-announce']")
private List<WebElement> hpCustomizeBtn;

@FindBy (xpath = "//*[@id = 'addCreditCardNumber']")
private WebElement cardnumber;
@FindBy (xpath = "(//*[@class = 'a-button-text a-declarative'])[1]")
private WebElement selectmonth;
@FindBy (xpath = "//*[@id = '1_dropdown_combobox']/li[3]")
private WebElement month3;
@FindBy (xpath = "(//*[@class = 'a-button-text a-declarative'])[2]")
private WebElement selectyear;
@FindBy (xpath = "//*[@id = '2_dropdown_combobox']/li[3]")
private WebElement year3;
@FindBy (xpath = "//*[@id ='ccAddCard']")
private WebElement addyourcardbtn;
@FindBy (xpath = "(//h4[contains(text(), 'There was a problem')])[1]")
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
/*public List<WebElement> getHPlist() {
	return HPlist;
}*/
public List<WebElement> getNothankbtn() {
	return nothankbtn;
}
public List<WebElement> getNothankbtn2() {
	return nothankbtn2;
}
public List<WebElement> getProceedbtn() {
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

public List<WebElement> getHpCustomizeBtn() {
	return hpCustomizeBtn;
}

public String getUrl() {
	return url;
}
public String getUserName() {
	return userName;
}
public String getPassword() {
	return password;
}
public WebElement getMyCartbtn() {
	return myCartbtn;
}








}
