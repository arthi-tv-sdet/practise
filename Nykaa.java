package Nykaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();

	 //1) Go to https:  www.nykaa.com 
              	driver.get("https://www.nykaa.com/");
              	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  
	 //2) Mouseover on Brands and Mouseover on Popular 
              	Actions action= new Actions(driver);
	              WebElement brand=driver.findElementByXPath("//a[text()='brands']");
	              action.moveToElement(brand).build().perform();
	              Thread.sleep(1000);
  
	 //3) Click L'Oreal Paris    
	              WebElement popular=driver.findElementByXPath("//a[text()='Popular']");
	              action.moveToElement(popular).build().perform();
	              WebElement loreal=driver.findElementByXPath("(//div[@class='Brand-Content']/ul/li)[5]");
	              loreal.click();
  
	 //4) Go to the newly opened window and check the title contains L'Oreal Paris   
	              	Set <String> win=driver.getWindowHandles();
	              List<String> listofwin=new ArrayList<String>();
	              listofwin.addAll(win);
              	driver.switchTo().window(listofwin.get(1));
              	String title=driver.getTitle();
              	System.out.println("Title-> "+title);
  
	 //5) Click sort By and select customer top rated      
	              WebElement sort=driver.findElementByXPath("//span[@title='POPULARITY']");
	              action.moveToElement(sort).build().perform();
              	sort.click();
              driver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();
                
	//6) Click Category and click Shampoo 
	                Thread.sleep(1000);
	               driver.findElementByXPath("//div[text()='Category']").click();
	               driver.findElementByXPath("(//span[contains(text(),'Shampoo')])[1]").click();
                 
	 //7) check whether the Filter is applied with Shampoo      
	               String filter = driver.findElementByXPath("//li[text()='Shampoo']").getText();
	       		if (filter.contains("Shampoo")) {
	       			System.out.println("Filter Applied Correctly.");
	       		} else {
	       			System.out.println("Filters not applied with Shampoo.");
	       		}

	 //8) Click on L'Oreal Paris Colour Protect Shampoo     
	            driver.findElementByXPath("//div[@class='m-content__product-list__title']/h2/span[contains(text(),'Colour Protect Shampoo')]").click();
	 
   //9) GO to the new window and select size as 175ml 
	            Set <String> win1=driver.getWindowHandles();
	           	List<String> listofwin1=new ArrayList<String>(win1);
	            driver.switchTo().window(listofwin1.get(2));
	            driver.findElementByXPath("//span[text()='175ml']").click();
                 
	 //10) Print the MRP of the product     
	              String mrp=driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
	          	  String mrp1=mrp.replaceAll("\\D", "");
	              int price=  Integer.parseInt(mrp1); 
	              System.out.println("MRP of the product"+price);
                
	 //11) Click on ADD to BAG     
	               driver.findElementByXPath("//div[@class='pull-left']").click();
                 
	 //12) Go to Shopping Bag     
	              driver.findElementByXPath("//div[@class='AddBagIcon']").click();
                
	 //13) Print the Grand Total amount      
	              String grandtotal=driver.findElementByXPath("//div[@class='value medium-strong']").getText();
	              System.out.println("Grandtotal- "+grandtotal);
                
	 //14) Click Proceed    
	               driver.findElementByXPath("//button[@type='button']/span").click();  
                 
	 //15) Click on Continue as Guest     
	               driver.findElementByXPath("//button[@class='btn full big']").click();
                 
	 //16) Print the warning message (delay in shipment)      
	               String warning=driver.findElementByXPath("//div[contains(text(),'Please')]").getText();
	               System.out.println(warning);
                 
	// 17)Close all windows
                  driver.quit();
			}
}
