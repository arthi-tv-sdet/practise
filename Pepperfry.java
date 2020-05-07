package pepperfry;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PepperFry {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//1) Go to https://www.pepperfry.com/
		driver.get("https://www.pepperfry.com/");
		Thread.sleep(100);
		driver.findElementByXPath("//div[@id='regPopUp']/a").click();
		System.out.println("pop up closed");
//		2) Mouseover on Furniture and click Office Chairs under Chairs
		Actions action=new Actions(driver);
		WebElement furn=driver.findElementByXPath("(//a[text()='Furniture'])[1]");
		action.moveToElement(furn).build().perform();
		Thread.sleep(100);
		driver.findElementByXPath("//a[text()='Office Chairs']").click();
		System.out.println("Clicked on Chairs");
		
//	3) click Executive Chairs
		driver.findElementByXPath("(//div[@class='clip-cat-wrap'])[2]").click();
		System.out.println("Executive chairs clicked");
		
//	4) Change the minimum Height as 50 in under Dimensions
		WebElement dim=driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]");
		dim.clear();
		dim.sendKeys("50",Keys.ENTER);
		System.out.println("Dimension changed as 50");
		Thread.sleep(600);
//	5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
		WebElement poise=driver.findElementByXPath("//a[text()='Poise Executive Chair in Black Colour']");
		action.moveToElement(poise).build().perform();
		driver.findElementByXPath("//a[@data-productname='Poise Executive Chair in Black Colour']").click();
		Thread.sleep(100);
		System.out.println("Added to wishlist");
		Thread.sleep(3000);
		
////	6) Mouseover on Homeware and Click Pressure Cookers under Cookware
		Actions action1=new Actions(driver);
		WebElement hom=driver.findElementByXPath("(//a[text()='Homeware'])[1]");
		action1.moveToElement(hom).build().perform();
		Thread.sleep(100);
		driver.findElementByXPath("//a[text()='Pressure Cookers']").click();
		System.out.println("Pressure cookers clicked");
		
//	7) Select Prestige as Brand
		driver.findElementByXPath("//label[@for='brandsnamePrestige']").click();
		Thread.sleep(5000);
	
//	8) Select Capacity as 1-3 Ltr
		driver.findElementByXPath("//label[@for='capacity_db1_Ltr_-_3_Ltr']").click();
		Thread.sleep(2000);
		
//	9) Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
		driver.findElementByXPath("//a[@data-productname='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr']").click();
		
//	10) Verify the number of items in Wishlist
		String count=driver.findElementByXPath("(//span[@class='count_alert'])[2]").getText();
		String s="2";
		if(count.equalsIgnoreCase(s))
		{System.out.println("Count in wishlist is verified");}
			
//	11) Navigate to Wishlist
		driver.findElementByXPath("//a[@data-tooltip='Wishlist']").click();
		Thread.sleep(1000);
		System.out.println("navigated to wishlist");
		
//	12) Move Pressure Cooker only to Cart from Wishlist
		driver.findElementByXPath("(//a[text()='Add to Cart'])[2]").click();
		Thread.sleep(2000);
		System.out.println("Cooker added to cart");
		Thread.sleep(1000);
		
//	13) Check for the availability for Pincode 600128
		driver.findElementByXPath("//span[text()='Showing availability at']/../input").sendKeys("600128");
		driver.findElementByXPath("//a[@class='check_available']").click();
		Thread.sleep(3000);
		System.out.println("Pin checked");
		
//	14) Click Proceed to Pay Securely
		driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
		System.out.println("Proceed is clicked");
		Thread.sleep(5000);
		
//	15) Capture the screenshot of the item under Order Item
		WebElement ele=driver.findElementByXPath("//form[@name='cart_form']");
		//WebElement ele=driver.findElementByXPath("//a[@target='_blank']/img");
		File Src=ele.getScreenshotAs(OutputType.FILE);
		File des=new File("./Snaps/Cart_item.png");
		FileUtils.copyFile(Src,des);
		System.out.println("Screenshot taken");
		
//	16) Close the browser
		driver.close();
	}

	}
