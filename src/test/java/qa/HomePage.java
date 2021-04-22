package qa;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.QuoteInfo;
import resources.base;
import utilities.ExcelUtils;
import utilities.FwHelper;

public class HomePage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test(dataProvider="returnExcelSheetData")
	
	//public void basePageNavigation(String Zipcode,String Firstname,String Lastname,String DOB,String HaveAutoIns,String Address,String City) throws IOException
	public void basePageNavigation(String QuoteNumber, String Zipcode,String Firstname,String Lastname,String DOB,String HaveAutoIns,String Address,String City) throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		QuoteInfo qi = new QuoteInfo(driver);
		FwHelper helper = new FwHelper();

		// Enter the details in Landing page to proceed to Auto Insurance quote page
		helper.actions(driver,lp.selectAutoIns(),"click","");
		helper.actions(driver,lp.getZipCode(),"sendkeys",Zipcode);
		lp.getZipCode().sendKeys(Keys.RETURN); 

		// Enter the Quote into Details
		helper.actions(driver,qi.getFirstname(),"sendkeys",Firstname);
		helper.actions(driver,qi.getLastname(),"sendkeys",Lastname);
		helper.actions(driver,qi.getDOB(),"sendkeys",DOB);
		helper.actions(driver,qi.getAddress(),"sendkeys",Address);
		helper.actions(driver,qi.getCity(),"sendkeys",City);
		
	    //Click Tab button 2 times to make Auto Insurance Radio button active
		Actions actions = new Actions(driver);
		for (int i = 0; i < 2; i++) {
		    actions.sendKeys(Keys.TAB).build().perform();
		}
		qi.gethaveAuto(HaveAutoIns).click();
		helper.actions(driver,qi.getNextVehicle(),"jsclick",""); //Click on Next vehicle button
		helper.actions(driver,qi.getvehicleCheckbox(),"jsclick","");//Click on Add vehicle Check box
		helper.actions(driver,qi.getaddVehicle(),"jsclick",""); //Click on Add vehicle button

		//Entering the vehicle Details
		helper.actions(driver, qi.getvehicleType(), "click", ""); // Click on the Vehicle type List
		helper.actions(driver, qi.getvehicleTypelist(), "click", ""); // Selecting the value sedan from Vahicle Type list
		helper.actions(driver, qi.getaddVehicle(), "jsclick", "");//Click on Add vehicle button
		helper.actions(driver, qi.getSaveQuote(), "jsclick", "");//Click on Add Save And Finish later link
		
	
		/* Added Explicit Wait & Fluentwait to handle the sync issues. But later commented as its more than normal timing
		 * new WebDriverWait(driver,
		 * 10).until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "(//div[@data-gtm='FFQ_Auto_Vehicle_selectVehicle_checkbox'])[3]"))).click();
		 * 
		 * //qi.getvehicleCheckbox().click(); qi.getvehicleTypelist().click();
		 * qi.getaddVehicle().click(); qi.getSaveQuote().click();
		 */
		
		
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(600000) )
		 * .pollingEvery(Duration.ofSeconds(20))
		 * .ignoring(NoSuchElementException.class);
		 * 
		 * WebElement foo = wait.until(new Function<WebDriver, WebElement>() { public
		 * WebElement apply(WebDriver driver) { if(
		 * qi.getquotepageheader().isDisplayed()) { return qi.getFirstname(); } else {
		 * return null; }
		 * 
		 * } });
		 */ //System.out.println(qi.getFirstname().isDisplayed());
		
		Reporter.log( "Auto Quote Generation passed with :"  + qi.getQuoteNumber().getText());

		try {
			ExcelUtils.UpdateCellData(1, 1, qi.getQuoteNumber().getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		helper.actions(driver, qi.getSaveandExit(), "jsclick", "");//Click on Add Save And Exit Button
		
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

	

	@DataProvider
	public static Object[][] returnExcelSheetData()
	        throws  Exception 
	        {

		        Object[][] dataset = ExcelUtils.getTableArray("Quoteinfo");
			    return dataset;
	        }
	
}
