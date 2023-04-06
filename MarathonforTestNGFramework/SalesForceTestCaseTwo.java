package MarathonforTestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceTestCaseTwo extends SalesForceCommonLogin{
	@BeforeTest
    public  void setup() 
	{
        excelFile="newopp";
    }
	@Test(dataProvider = "fetchData")
	public void runTestCaseTwo(String opportunityname,String amount) throws InterruptedException{
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		WebElement jumpto = driver.findElement(By.xpath("//span[text()='Key Deals - Recent Opportunities']"));
		Actions builder2 = new Actions(driver);
		builder2.scrollToElement(jumpto).perform();
		
		WebElement viewalllink = driver.findElement(By.xpath("(//a[@class='viewAllLink'])[4]"));
		driver.executeScript("arguments[0].click();",viewalllink);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(opportunityname);
		WebElement movettotype = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input-value')])[2]"));
		driver.executeScript("arguments[0].click();",movettotype);
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'-input_faux slds-combobox__')])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(amount);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("4/7/2023");
		driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox__form-element slds-input')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='slds-media__body'])[4]/span")).click();

		WebElement scrollto = driver.findElement(By.xpath("(//div[contains(@class,'-input-has-icon slds-input-has-')])[7]"));
		driver.executeScript("arguments[0].click();",scrollto);
		driver.findElement(By.xpath("(//span[contains(@class,'-text slds-listbox__option-text_entity')])[1]")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		String verifyopp = driver.findElement(By.xpath("(//div[@class='slds-media__body'])[1]")).getText();
		System.out.println("the opportunity created "+verifyopp);
		if(verifyopp.contains(opportunityname))
		{
			System.out.println("yes!!! The Opportunity was created");
		}
		
	}

}
