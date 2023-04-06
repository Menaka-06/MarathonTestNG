package MarathonforTestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceTestCaseOne extends SalesForceCommonLogin {
	@BeforeTest
    public  void setup() 
	{
        excelFile="salesforcequestion";
    }
@Test(dataProvider = "fetchData")
	public void runLogin(String questiontexts,String answer) {
	driver.findElement(By.xpath("//input[@id='input-124']")).sendKeys("content");
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark")).click();
		WebElement chatter = driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]"));
		driver.executeScript("arguments[0].click();",chatter);
		String titleofchatter = driver.getTitle();
		System.out.println("the title of the page is  "+titleofchatter);
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("chatter"))
		{
			System.out.println("yes, chatter is present");
		}
		Actions builder = new Actions(driver);
		WebElement questiontab =driver.findElement(By.xpath("(//span[@class='title'])[3]"));
		builder.moveToElement(questiontab).click().perform();
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(questiontexts);
		driver.findElement(By.xpath("//div[contains(@class,'-text-area__content slds')]")).sendKeys(answer);
		driver.findElement(By.xpath("//button[contains(@class,'-questionPostDesktop MEDIUM')]")).click();
		String questiontext = driver.findElement(By.xpath("(//div[contains(@class,'-questionTitle ')])[1]")).getText();
		System.out.println("the question given from excel is  "+questiontext);
		String answertext = driver.findElement(By.xpath("(//div[@class='feedBodyInner Desktop oneApp'])[1]")).getText();
		System.out.println("the answer from excel is "+answertext);
		
	}

}
