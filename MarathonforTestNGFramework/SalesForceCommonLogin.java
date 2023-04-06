package MarathonforTestNGFramework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class SalesForceCommonLogin {
	public  RemoteWebDriver driver;
	public String excelFile;

	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void precondotion(String browser,String url,String username,String password) {
		switch(browser) {
		case "chrome":
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
			break;
		}
		case "Edge":
		{
			driver=new EdgeDriver();
			break;
		}
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("hi");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
	
	}
	@AfterMethod
	public void postCondition() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	@DataProvider(name="fetchData")

	public String[][] getdata() throws IOException {
		
		String[][] inputData = ReadExcelforInput.inputData(excelFile);
		return inputData;

	}


}
