package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import resources.base;

public class FwHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void actions(WebDriver driver, WebElement webElement, String strAction, String strValue) {
		// TODO Auto-generated method stub
		
		if (strAction.equalsIgnoreCase("sendkeys")) {
			webElement.sendKeys(strValue);
			Reporter.log("Successfully set the value for the webelement with the value :"+ strValue);
		}
		else if(strAction.equalsIgnoreCase("jsclick")){
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", webElement);
			Reporter.log("Successfully JS clicked the value for the webelement ");
		}
		else if(strAction.equalsIgnoreCase("click")){
			
			webElement.click();
			Reporter.log("Successfully clicked the value for the webelement ");
		}
	}

}
