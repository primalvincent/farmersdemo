package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuoteInfo {

	
	public WebDriver driver;

	
	By firstname=By.cssSelector("input[data-gtm*='firstname']");
	By lastname=By.cssSelector("input[data-gtm*='lastname']");
	By dob=By.cssSelector("input[data-gtm*='DOB']");
	By address = By.cssSelector("input[data-gtm*='resiaddress']");
	By city=By.cssSelector("input[data-gtm*='resicity']");
	By btnNext=By.cssSelector("span#NextEnabled");
	By quoteNumber=By.xpath("//span[contains(text(),'Quote number')]");
	By quotepageheader=By.cssSelector("h1.ffq-main-title");
	By vehicleCheckbox = By.xpath("(//div[@data-gtm='FFQ_Auto_Vehicle_selectVehicle_checkbox'])[3]");
	By vehicleType = By.cssSelector("div[class*='mat-select-value ng-tns']");
	By vehicleTypelist = By.xpath("//span[contains(text(),'Sedan')]");
	By addvehicle = By.xpath("//span[contains(text(),'ADD')]");
	By lnkSavelater = By.xpath("//div[contains(text(),'Save quote & finish later')]");
	By btnSaveandExit = By.xpath("//span[contains(text(),'SAVE AND EXIT')]");
	
	
	
	public QuoteInfo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	public WebElement getFirstname()
	{
		return driver.findElement(firstname);
	}
	

	public WebElement getLastname()
	{
		return driver.findElement(lastname);
	}
	
	public WebElement getDOB()
	{
		return driver.findElement(dob);
	}
	
	public WebElement getAddress()
	{
		return driver.findElement(address);
	}
	

	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	
	public WebElement gethaveAuto(String haveins)
	{
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.cssSelector("mat-radio-button[data-gtm*='FFQ_Auto_Yourinfo_haveins_"+ haveins +"']"));
		//return driver.findElement(By.cssSelector("mat-radio-button[data-gtm*='FFQ_Auto_Yourinfo_haveins_no']"));
	}	
	
	public WebElement getNextVehicle()
	{
		return driver.findElement(btnNext);
	}
	
	public WebElement getQuoteNumber()
	{
		return driver.findElement(quoteNumber);
	}
	
	public WebElement getquotepageheader()
	{
		return driver.findElement(quotepageheader);
	}
	
	public WebElement getvehicleCheckbox()
	{
		return driver.findElement(vehicleCheckbox);
	}
	
	public WebElement getvehicleType()
	{
		return driver.findElement(vehicleType);
	}
	public WebElement getvehicleTypelist()
	{
		return driver.findElement(vehicleTypelist);
	}
	
	public WebElement getaddVehicle()
	{
		return driver.findElement(addvehicle);
	}
	
	public WebElement getSaveQuote()
	{
		return driver.findElement(lnkSavelater);
	}
	
	public WebElement getSaveandExit()
	{
		return driver.findElement(btnSaveandExit);
	}
	
}
