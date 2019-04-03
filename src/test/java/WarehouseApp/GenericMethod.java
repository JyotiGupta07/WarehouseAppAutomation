package WarehouseApp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.Alert;
//import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;



public class GenericMethod {
	WebDriver driver;
	String appUrl = "http://wservicedev.winwholesale.com/shipping-manifest-manager/#/";
	String driverPath = "D:/chromedrivernew.exe";
	String pageUrl;
	
	// Navigate to the site
	@BeforeTest
	public void getUrl() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(appUrl);
		Thread.sleep(1000);
			
	}
	
	// Verify URL and move on particular page
	
	public void navigateToPage(String pageId) throws InterruptedException {
		String pageUrl = this.appUrl + pageId;
		driver.navigate().to(pageUrl);
		Thread.sleep(2000);
	}
	
	// Method to open Modal page	
	
	public void newModalPage(By obj) {
		WebElement button = driver.findElement(obj);
		button.click();	
	}
	
	// Select current Date
		
		public void currentDate(By obj, String selectDate) {
			DateFormat dateFormat1 = new SimpleDateFormat("d"); 
	        Date date1 = new Date();
	
	        String today = dateFormat1.format(date1); 
	        //Find the calendar
	        WebElement dateWidget = driver.findElement(obj);
	        dateWidget.click();
	        WebElement datepicker = driver.findElement(By.xpath(selectDate));
	        ArrayList<WebElement> columns = (ArrayList<WebElement>) datepicker.findElements(By.cssSelector(".day:not(.disabled"));
	             
	    // Comparing the text of cell with today's date and clicking it.
	        for (WebElement cell : columns) {
	           if (cell.getText().equals(today)) {
	              cell.click();
	              break;
	           }
	        }
	        
	    //Wait for 5 Seconds to see today's date selected
	        try {
	            Thread.sleep(1000);
	        } 
	        catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		
		// Select Current time
		
		public void currentTime(By obj, String time) {
		    
	    //Find the Time field and select current time
	    	WebElement timeWidget = driver.findElement(obj);
	    	//timeWidget.clear();
	    	timeWidget.sendKeys(time);
	    	timeWidget.sendKeys(Keys.TAB);
	    	
	    	   
	    //Wait for 5 Seconds to see today's time selected
	          try {
	              Thread.sleep(1000);
	          } 
	          catch (InterruptedException e) {
	              e.printStackTrace();
	          }
		}
		
		public void selectDropdownValue(By obj, String name) {
			// Find the truck and driver select from drop-down
			WebElement id = driver.findElement(obj);
			Select selectName = new Select(id);
			selectName.selectByVisibleText(name);
			 //Wait for 5 Seconds to see Name selected
	        try {
	            Thread.sleep(1000);
	        } 
	        catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	
		// Add order number in Manifest
		public void addOrderNumber(By obj, String order) {
			WebElement addOrder = driver.findElement(obj);
			addOrder.click();
			addOrder.sendKeys(order);
			addOrder.sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		
		// Click on Create/Save Button to Create/Save Manifest, Driver and Truck
		public void create(By obj) {
			try {
				WebElement createButton = driver.findElement(obj);
				createButton.click();
			} catch(NoSuchElementException e) {
				Assert.fail("Fill values in all the fields to enable Save Driver....");
			// Assert.fail("Fill values in all the fields to enable Save Driver...."+e.getMessage());	
			}
		}
		
		
	// Input values in fields
		
		public void inputValue(By obj, String value) {
		    
	    //Find the Time field and select current time
	    	WebElement inputField = driver.findElement(obj);
	    	//timeWidget.clear();
	    	inputField.sendKeys(value);
	    	inputField.sendKeys(Keys.TAB);
	    	
	    	   
	    //Wait for 5 Seconds to see today's time selected
	          try {
	              Thread.sleep(1000);
	          } 
	          catch (InterruptedException e) {
	              e.printStackTrace();
	          }
		}
//----------------------Create------------------	
		
//--------------------- Update Manifest, Driver and Truck ------------------
		public void update(By obj) {
	     WebElement clickValue = driver.findElement(obj);
	     clickValue.click();
	     
	     
	     	// Wait for 5 Seconds to see Driver selected
			try {
			    Thread.sleep(2000);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		
		}	
//--------------------- Updation complete -------------------------------		

		
//--------------------- Delete Manifest, Driver and Truck ---------------
	
		public void delete(By obj) {
			WebElement delete = driver.findElement(obj);
			delete.click();
			try {
			    Thread.sleep(2000);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
		}
//---------------------- Deletion complete-------------------------------		
		

//---------------------- Alert message----------------------------
//		public void clickOnAlert() {
//			try {
//			    WebDriverWait wait = new WebDriverWait(driver, 2);
//			    wait.until(ExpectedConditions.alertIsPresent());
//			    Alert alert = driver.switchTo().alert();
//			    System.out.println(alert.getText());
//			    //accept alert
//		        driver.switchTo().alert().accept();
//		    //Assert.assertTrue(alert.getText().contains(""));
//			}
//
//			catch (Exception e) {
//			    //exception handling
//			}
//			
//		}	
//------------------------ Alert Message display --------------------		
		
		
// ----------- Select Date ---------------------		
		public void selectDate(By obj, String selectDateYear) {
//			DateFormat dateFormat1 = new SimpleDateFormat("d"); 
//	        Date date1 = new Date();
	
	       // String today = dateFormat1.format(date1); 
	        //Find the calendar
	        WebElement dateWidget = driver.findElement(obj);
	        dateWidget.click();
	        WebElement datepicker = driver.findElement(By.xpath(selectDateYear));
	        ArrayList<WebElement> allDates = (ArrayList<WebElement>) datepicker.findElements(By.cssSelector(".day:not(.disabled"));
    		
    		for(WebElement ele:allDates)
    		{
    			
    			String date=ele.getText();
    			
    			if(date.equalsIgnoreCase("28"))
    			{
    				ele.click();
    				break;
    			}
    			
    		}
		}	
		
		
//Generic Function to check URL and Label
		public void labelCheck(By obj, String text){
			String message = "Current URL doesn't matches application URL. Please check.";
			assertTrue((driver.getCurrentUrl()).equals(pageUrl), message);
			
			if(driver.getCurrentUrl().equals(pageUrl)){		
				//Get Label Heading text
				WebElement labelHeading = driver.findElement(obj);
				String labelText = labelHeading.getText();
				//Match between actual text and expected text
				assertEquals(labelText, text, "Labels didn't match. Expected: "+labelText+"but found "+text);
			}
		}	
// --------------- URL and Label matched with open URL and page---------------		
		
//-------------- Check List page data---------------------
		
		public void listVerify() {
			
		}
		
		
//-------------- Data should match with created Manifest, Truck and Driver------------		
		
//------------------ Close browser -------------------
	@AfterSuite
	public void shutdown(){
		driver.close();
	}
	
}
