package MakeMyTrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MMT {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
		//1) Go to https://www.makemytrip.com/
		      	driver.get("https://www.makemytrip.com/");
		
		//2) Click Hotels
			  driver.findElementByXPath("//span[text()='Hotels']").click();
			  Thread.sleep(1000);
      
		//3) Enter city as Goa, and choose Goa, India
						WebElement EnterCity=driver.findElementByXPath("//label[@for='city']");
					  EnterCity.click();
			      driver.findElementByXPath("//div[@role='combobox']/input").sendKeys("goa");
			      driver.findElementByXPath("(//div[@class='flexOne']/p)[1]").click();
            
			//4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5
      
		  	driver.findElementByXPath("(//div[text()='15'])[2]").click();
		  	driver.findElementByXPath("(//div[text()='20'])[2]").click();
      
			//5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
      driver.findElementByXPath("//input[@data-cy='guest']").click();
			Actions action= new Actions(driver);
			WebElement child=driver.findElementByXPath("//li[@data-cy='children-1']");
			action.moveToElement(child).build().perform();
			child.click();
			Actions action1= new Actions(driver);
			WebElement apply=driver.findElementByXPath("//button[text()='APPLY']");
			action1.moveToElement(apply).build().perform();
			apply.click();
      
			//6) Click Search button
			driver.findElementByXPath("//button[text()='Search']").click();
			Thread.sleep(1000);
      
			//7) Select locality as Baga
			driver.findElementByXPath("//body").click();
			driver.findElementByXPath("//label[text()='Baga']").click();
      
			//8) Select 5 star in Star Category under Select Filters
			driver.findElementByXPath("//label[text()='5 Star']").click();
      
			//9) Click on the first resulting hotel and go to the new window
			driver.findElementByXPath("//span[text()='The Park Baga River Goa']").click();
			Set <String> win=driver.getWindowHandles();
			List<String> listofwin=new ArrayList<String>();
			listofwin.addAll(win);
			driver.switchTo().window(listofwin.get(1));
			Thread.sleep(1000);
      
			//10) Print the Hotel Name 
			driver.findElementByXPath("//h1").getText();
      
			//11) Click MORE OPTIONS link and Select 3Months plan and close
			driver.findElementByXPath("//span[text()='MORE OPTIONS']").click();
			//12) Click on BOOK THIS NOW
			driver.findElementByXPath("//span[text()='SELECT']").click();
			
			//13) Print the Total Payable amount
			String amount=driver.findElementByXPath("//tr[2]/td[5]").getText();
			String a=amount.replaceAll("\\D", "");
			//int total_amount=Integer.parseInt(amount);
			System.out.println("Total payable amount is: "+a);
      
			//14) Close the browser
			driver.quit();
	}

}
