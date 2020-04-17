package Myntra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.SystemException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class myntra {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	  ChromeDriver driver = new ChromeDriver(options);
	   
		//open myntra.com
    
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    
		//move to element women
    
		Actions actions= new Actions(driver);
		WebElement women=driver.findElementByXPath("//a[text()='Women']");
		actions.moveToElement(women).build().perform();
    
		//wait till the element appears
		Thread.sleep(2000);
    
		//click on jackets and coats
		WebElement jacket=driver.findElementByXPath("//a[text()='Jackets & Coats']");
		actions.moveToElement(jacket).perform();
		jacket.click();
    
		//Get the total count 
		String count=driver.findElementByClassName("title-count").getText();
		System.out.println("Total count of jackets and coats:"+count);
		String totcount=count.replaceAll("\\D", "");
		int tot=Integer.parseInt(totcount);
    
		//Validate the sum of categories count matches
		String jac=driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
    
		//replacing extra character like () and getting the count 
		String jc=jac.replaceAll("\\D", "");
		int j=Integer.parseInt(jc);
		System.out.println("Total count of jackets: "+j);
		String co=driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String coat=co.replaceAll("\\D", "");
		int c=Integer.parseInt(coat);
		System.out.println("Total count of coats: "+c);
		int sum=j+c;
		if(sum==tot)
		{System.out.println("Sum of jackets- "+j +" and coats- "+c+ " equals total count- "+sum);
		
		}
		else
		{
			System.out.println("Sum of jackets and coats is not equal to total count");
		}
				
		//Check Coats
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
    
		// Click + More option under BRAND	
		driver.findElementByXPath("//div[@class='brand-more']").click();
    
		//Type MANGO and click checkbox
		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("MANGO");
		driver.findElementByXPath("//label[@class=' common-customCheckbox']//div").click();
    
		//Close the pop-up x
		driver.findElementByXPath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close sprites-remove')]").click();
	
		//Sort by Better Discount
		
		WebElement sort= driver.findElementByXPath("//div[@class='sort-sortBy']");
		actions.moveToElement(sort).perform();
		WebElement better=driver.findElementByXPath("(//label[@class='sort-label '])[3]");
		better.click();
    
		//Find the price of first displayed item
		String price=driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
		System.out.println("Price of first displayed item is : "+price);
		
		//Mouse over on size of the first item
		 WebElement size = driver.findElementByXPath("(//div[@class='product-productMetaInfo'])[1]");
	   actions.moveToElement(size).perform();
     
		 //Click on WishList Now
		 driver.findElementByXPath("//span[text()='wishlist now']").click();
		
		//close the browser
		driver.close();
}
}
