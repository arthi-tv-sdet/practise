package Snapdeal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
//		1) Go to https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		
//		‎2) Mouse over on Toys, Kids' Fashion & more and click on Toys
			WebElement toy =driver.findElementByXPath("(//span[@class='catText'])[8]");
			Actions a=new Actions(driver);
			a.moveToElement(toy).build().perform();
			Thread.sleep(2000);
			
//		3) Click Educational Toys in Toys & Games
			driver.findElementByXPath("//span[text()='Educational Toys']").click();
			Thread.sleep(6000);
			System.out.println("Educational toys link is clicked");
			
//		‎4) Click the Customer Rating 4 star and Up 
			driver.findElementByXPath("//label[@for='avgRating-4.0']").click();
			System.out.println("Rating 4 plus option is clicked");
			Thread.sleep(5000);
			
//		5) Click the offer as 40-50
			driver.findElementByXPath("//label[@for='discount-40%20-%2050']").click();
			System.out.println("40-50 is clicked");
			Thread.sleep(3000);
			
//		6) Check the availability for the pincode
			driver.findElementByXPath("(//input[@class='sd-input'])[2]").sendKeys("641005");
			driver.findElementByXPath("//button[text()='Check']").click();
			Thread.sleep(2000);
			
//		7) Click the Quick View of the first product 
			WebElement prd1= driver.findElementByXPath("(//picture[@class='picture-elem']//img)[1]");
			a.moveToElement(prd1).build().perform();
			Thread.sleep(2000);			
			driver.findElementByXPath("(//div[contains(text(),'Quick View')])[1]").click();
			System.out.println("Quick view is clicked");
			Thread.sleep(4000);
			
//		8) Click on View Details
			driver.findElementByXPath("//a[contains(text(),' view details')]").click();
			System.out.println("View details clicked");
			
//		9) Capture the Price of the Product and Delivery Charge
			String p=driver.findElementByXPath("//span[@class='payBlkBig']").getText();
			float price=Float.parseFloat(p);
			System.out.println("Price of the product :Rs "+price);
			String d=driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();
			String apple = d.replaceAll("\\D","");
			float del=Float.parseFloat(apple);
			System.out.println("Delivery charge: Rs "+del);
			driver.findElementByXPath("//span[text()='add to cart']").click();
			String Youpay=driver.findElementByXPath("(//span[@class='price'])[2]").getText();
			String apple2 = Youpay.replaceAll("\\D","");
			float you=Float.parseFloat(apple2);
//		10) Validate the You Pay amount matches the sum of (price+deliver charge)
			Float Y=price+del;
			if(you==Y)
			{System.out.println("You pay amount matches the sum of ("+price+"+"+del+")");}
			
//		11) Search for Sanitizer
			driver.findElementByXPath("(//input[@name='keyword'])[1]").sendKeys("Sanitizer");
			driver.findElementByXPath("//span[text()='Search']").click();
			Thread.sleep(3000);
			
//		12) Click on Product "BioAyurveda Neem Power Hand Sanitizer"
			driver.findElementByXPath("//p[text()='BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1']").click();
			Thread.sleep(3000);
			
//		13) Capture the Price and Delivery Charge
			Set <String> win=driver.getWindowHandles();
			List<String> listofwin=new ArrayList<String>();
			listofwin.addAll(win);
			driver.switchTo().window(listofwin.get(1));
			String sanprice=driver.findElementByXPath("//span[@class='payBlkBig']").getText();
			float sanprice1=Float.parseFloat(sanprice);
			System.out.println("Sanitizer price: Rs "+sanprice1);
			String dc=driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();
			String apple1 = dc.replaceAll("\\D","");
			float dc1=Float.parseFloat(apple1);
			System.out.println("Delivery charge : Rs "+dc1);
			Float santotal=sanprice1+dc1;
//		14) Click on Add to Cart
			driver.findElementByXPath("(//span[text()='ADD TO CART'])[1]").click();
			Thread.sleep(2000);
			
//		15) Click on Cart
			driver.findElementByXPath("//span[text()='Cart']").click();
			
			CharSequence Youpaynew="744";
//		16) Validate the Proceed to Pay matches the total amount of both the products
			WebElement button=driver.findElementByXPath("//input[@type='button']");
			String value=button.getAttribute("value");
			if(value.contains(Youpaynew))
			System.out.println("Total amount matches");
			
//		17) Close all the windows
			driver.quit();
	}

}
