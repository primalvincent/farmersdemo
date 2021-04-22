package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	

    By autoQuote= By.cssSelector("a[data-gtm*='Farmers_MultilineHP_AutoIcon_ProductGrid']");
	By zipCode = By.xpath("(//input[@aria-describedby='zipCode_errorText_1_1'])[2]");
	By getQuote= By.xpath("(//button[contains(text(),'Get a quote')])[6]");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement selectAutoIns()
	{
		 return driver.findElement(autoQuote);		 
		 
	}
	
	public WebElement getZipCode()
	{
		 return driver.findElement(zipCode);		 
		 
	}
	
	public WebElement getQuote()
	{
		 return driver.findElement(getQuote);		 
		 
	}
	
	/*
	 * public QuoteInfo getLogin() { driver.findElement(autoQuote).click();
	 * QuoteInfo lp=new QuoteInfo(driver); return lp;
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	
		
	
	
}
