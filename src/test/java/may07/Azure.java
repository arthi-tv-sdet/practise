package may07;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Azure {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		//					1) Go to https://azure.microsoft.com/en-in/
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		//					2) Click on Pricing
		driver.findElementByXPath("//a[text()='Pricing']").click();

		//					3) Click on Pricing Calculator
		driver.findElementByXPath("//a[contains(text(),'Pricing calculator')]").click();
		Thread.sleep(2000);

		//					4) Click on Containers
		driver.findElementByXPath("//button[text()='Containers']").click();
		Thread.sleep(1000);

		//					5) Select Container Instances
		driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();

		//					6) Click on Container Instance Added View
		//driver.findElementByXPath("//div[text()='Container Instances added.\"]/span").click();
		//					7) Select Region as "South India"
		WebElement  region=driver.findElementByXPath("(//select[@name='region'])[1]");
		Select d1=new Select(region);
		d1.selectByVisibleText("South India");

		//					8) Set the Duration as 180000 seconds
		driver.findElementByXPath("(//input[@type='number'])[2]").sendKeys(Keys.chord(Keys.CONTROL,"a"),"18000");

		//					9) Select the Memory as 4GB
		WebElement memory=driver.findElementByXPath("//select[@name='memory']");
		Select d2=new Select(memory);
		d2.selectByVisibleText("4 GB");

		//					10) Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//span[text()='Show Dev/Test Pricing']").click();

		//					11) Select Indian Rupee  as currency

		WebElement currency=driver.findElementByXPath("//select[@class='select currency-dropdown']");
		Select d3=new Select(currency);
		d3.selectByValue("INR");
		//					12) Print the Estimated monthly price
		String monthlyCost = driver.findElementByXPath("//span[text()='Monthly cost']/../span[2]").getText();

		//					13) Click on Export to download the estimate as excel
		driver.findElementByXPath("//button[@data-event='area-pricing-calculator-clicked-exportestimate']").click();

		//					14) Navigate to Example Scenarios and Select CI/CD for Containers

		File dir = new File("C:\\Users\\vignesh.a.venugopal\\Downloads");
		File[] dir_contents = dir.listFiles();


		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().contains("ExportedEstimate.xlsx")) {
				System.out.println("The File is Validated Successfully");
			}
			

		}
		WebElement exScenario = driver.findElementByXPath("//a[text()='Example Scenarios']");
		Actions action = new Actions(driver);
		action.moveToElement(exScenario).build().perform();
		exScenario.click();
		driver.findElementByXPath("//button[@title='CI/CD for Containers']").click();
		driver.findElementByXPath("//button[text()='Add to estimate']").click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='select currency-dropdown']")));
		WebElement currency2=driver.findElementByXPath("//select[@class='select currency-dropdown']");
		Select d4=new Select(currency2);
		d4.selectByValue("INR");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Show Dev/Test Pricing']")));
		driver.findElementByXPath("//span[text()='Show Dev/Test Pricing']").click();
		driver.findElementByXPath("//button[@data-event='area-pricing-calculator-clicked-exportestimate']").click();
		File dir1 = new File("C:\\Users\\vignesh.a.venugopal\\Downloads");
		File[] dir1_contents = dir1.listFiles();


		for (int j = 0; j < dir1_contents.length; j++) {
			if (dir1_contents[j].getName().contains("ExportedEstimate (1).xlsx")) {
				System.out.println("The Second File is Validated Successfully");
			}
			

		}
		driver.quit();


	}
	//					
}
