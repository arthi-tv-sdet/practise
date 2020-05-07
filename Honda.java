package Honda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Honda {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
////		1) Go to https://www.honda2wheelersindia.com/
		driver.get("https://www.honda2wheelersindia.com/");
		driver.findElementByXPath("//button[@class='close']").click();
		Thread.sleep(2000);
		System.out.println("Pop up closed");
		
//			2) Click on scooters and click dio
		driver.findElementByXPath("(//a[text()='Scooter'])[1]").click();
		System.out.println("Scooters clicked");
		Thread.sleep(1000);
		driver.findElementByXPath("(//div[@class='owl-item']/div/a)[4]").click();
		System.out.println("Deo is clicked");
		Thread.sleep(2000);
		
//			3) Click on Specifications and mouseover on ENGINE
		driver.findElementByXPath("//a[text()='Specifications']").click();
		System.out.println("Specifications clicked for Dio");
		Thread.sleep(3000);
		Actions eng=new Actions(driver);
		WebElement engine=driver.findElementByXPath("//a[text()='ENGINE']");
		eng.moveToElement(engine).build().perform();
		System.out.println("Moved to engine under Dio");
		
		
//			4) Get Displacement value
		String disdio=driver.findElementByXPath("//span[text()='Displacement']/../span[2]").getText();
		//disdio.replaceAll("\\D", "");
		String diodis= disdio.replaceAll("[^0-9\\s.]+|\\.(?!\\d)", "");
		Double diofinal=Double.parseDouble(diodis);
		System.out.println("Dio: "+diofinal);
		
//			5) Go to Scooters and click Activa 125
		driver.findElementByXPath("(//a[text()='Scooter'])[1]").click();
		System.out.println("Scooter clicked");
		Thread.sleep(1000);
		driver.findElementByXPath("(//div[@class='owl-item']//div)[6]").click();
		System.out.println("Activa is clicked");
		Thread.sleep(2000);
		
//			6) Click on Specifications and mouseover on ENGINE
		driver.findElementByXPath("//a[text()='Specifications']").click();
		System.out.println("Specifications clicked for Activa");
		Thread.sleep(6000);
		WebElement engactiva=driver.findElementByXPath("//a[text()='ENGINE']");
		eng.moveToElement(engactiva).build().perform();
		System.out.println("Moved to Engine under Activa");
		
//			7) Get Displacement value
		String disact=driver.findElementByXPath("//span[text()='Displacement']/../span[2]").getText();
		//String disactiva=disact.replaceAll("\\D", "");
		//Integer.parseInt(disactiva);
		String disactiva= disact.replaceAll("[^0-9\\s.]+|\\.(?!\\d)", "");
		Double actfinal=Double.parseDouble(disactiva);
		System.out.println("Activa: "+actfinal);
		Thread.sleep(1000);
//			8) Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
		if(diofinal>actfinal)
		{System.out.println("Dio has better displacement");
		}
		
		else
		{
			System.out.println("Activa has better displacement");
		}
//			9) Click FAQ from Menu 
		driver.findElementByXPath("(//a[text()='FAQ'])[1]").click();
		System.out.println("FAQ clicked");
		Thread.sleep(2000);
		
//			10) Click Activa 125 BS-VI under Browse By Product
		driver.findElementByXPath("(//a[text()='Activa 125 BS-VI'])[1]").click();
		System.out.println("Activa 125 BS-VI clicked");
		
//			11) Click  Vehicle Price 
		driver.findElementByXPath("//a[text()=' Vehicle Price']").click();
		Thread.sleep(2000);
		
//			12) Make sure Activa 125 BS-VI selected and click submit
		driver.findElementByXPath("(//button[text()='Submit'])[6]").click();
				Thread.sleep(1000);
				
//			13) click the price link
		driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
		Thread.sleep(3000);
		
//			14)  Go to the new Window and select the state as Tamil Nadu and  city as Chennai
		Set <String> win=driver.getWindowHandles();
		List<String> listofwin=new ArrayList<String>();
		listofwin.addAll(win);
		driver.switchTo().window(listofwin.get(1));
		WebElement state=driver.findElementByXPath("//select[@name='StateID']");
		Select op=new Select(state);
		op.selectByVisibleText("Tamil Nadu");
		WebElement city=driver.findElementByXPath("//select[@name='CityID']");
		Select op1=new Select(city);
		op1.selectByVisibleText("Chennai");
		Thread.sleep(1000);
		System.out.println("options selected");
//			15) Click Search
		driver.findElementByXPath("//button[text()='Search']").click();
		System.out.println("Search button clicked");
		Thread.sleep(3000);
		
//			16) Print all the 3 models and their prices
		List<WebElement> data = driver.findElementsByXPath("//tbody[@style='background-color:white']/tr/td");
		for (WebElement element : data) {
			System.out.println(element.getText());
		}
//			17) Close the Browser
		driver.quit();
	}

}
