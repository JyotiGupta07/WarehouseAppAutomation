package WarehouseApp;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
//import org.junit.Assert;
//import org.testng.asserts.SoftAssert;
//import static org.testng.Assert.assertEquals;


public class ManifestPage extends GenericMethod{
	
	// Create Manifest after open Create Manifest Page
	@Test
	public void openManifestListPage() throws InterruptedException {

		// Open Manifest List Page
		navigateToPage("/list");
		Thread.sleep(5000);
		String labelId = "(\"//h2[@ class='page-title']\")";
		labelCheck(By.xpath(labelId), "MANIFEST LIST");
		System.out.println(labelId);
	}
	
	
	@Test(priority =1)
	//@Test
	public void createManifest() throws InterruptedException {
		
		// Open Create Manifest Modal Page
		//String createManifestModal = "//*[@id='containerFluid']/list/div[1]/h2/button";
		String createManifestModal = "//*[@id=\"containerFluid\"]/list/div[1]/div[1]/div/button";
		newModalPage(By.xpath(createManifestModal));
		Thread.sleep(1000);
		
		// Click on Date picker to select current date
				String dateWidget = "newManifestDeliveryDate";
				String datePicker = "html/body/div[4]";
				currentDate(By.id(dateWidget), datePicker);
			
		//Wait for 5 Seconds to see today's date selected
		        try {
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        // Click on Time to select current time
		       String timeWidget = "newManifestStartTime";		       
		       currentTime(By.id(timeWidget), "");
		       Thread.sleep(1000);
		      
		        
		 //Select Truck name and Driver Name and match with time-slot  
			
		// Select Truck name from truck drop-down
		        String truckID = "new-manifest #truck";     //*[@id="truck"]
		        String truckName ="Nissan";  //*[@id="truck"]/option[13]
		        selectDropdownValue(By.cssSelector(truckID), truckName);  
		        
		        // Wait for 5 Seconds to see truck selected
		        try {
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		     

		      // Select Driver name from Driver drop-down
		    	
		   	   String driverID = "new-manifest #driver";
		       String driverName ="Jyoti Gupta (JS)";
		       selectDropdownValue(By.cssSelector(driverID),driverName );
		       
		       	// Wait for 5 Seconds to see Driver selected
				try {
				    Thread.sleep(2000);
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
	
				 // Input Order Number in Manifest
		        String i = "124822-01";
		        String orderNumber = ".//div[@class='order-header']//input[@type='text']"; 
		        int count = 0;
		        addOrderNumber(By.xpath(orderNumber), i);
		        count = driver.findElements(By.id("stopList,'" + i + "')]")).size();
		        try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        
		        addOrderNumber(By.xpath(orderNumber), i);
		   // WebElement errorMessage = driver.findElement(By.xpath(""//span[text()='The order number entered already exists on the manifest.']"));
		        WebElement errorMessage = driver.findElement(By.cssSelector("span[class='ui-growl-title']"));
		        String errorText = errorMessage.getText();
		        //System.out.println(errorText);
		        List<WebElement> list = driver.findElements(By.id("stopList,'" + i + "')]"));
		        //SoftAssert softAssert = new SoftAssert();
		        assertTrue(list.size() == count, errorText);
		        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		        	
		        
		        String createNewManifest = "//span[text()='Create Manifest']";
		        create(By.xpath(createNewManifest));
		        
		        try {
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
	
//	----------- Complete Manifest Creation ------------- 
	
	
		
	
	// Close Browser
	public void closeBrowser() {
	shutdown();
	}
	
}

 
  
 
