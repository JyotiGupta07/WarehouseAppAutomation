package WarehouseApp;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TruckPage extends GenericMethod{
	
	WebDriver driver;
	@Test
	public void openTruckListPage() throws InterruptedException {

		// Open Truck List Page
		navigateToPage("/truck-list");
		Thread.sleep(5000);
	}
	
//------------------------- Truck creation ------------------------------	
	@Test(priority =1)
	public void createTruck() {
		
		String createTruckModal = "modalClose";
		newModalPage(By.id(createTruckModal));
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		// Click on Truck Name to enter Truck Name
        String truckName = "truckName";
        inputValue(By.id(truckName), "NissanTest");
        
    // Click on License Plate Number to enter plate number
        String licensePlateNumber = "licensePlateNumber";
        inputValue(By.id(licensePlateNumber), "abc123");  
        
    // Click on License Plate expiration to enter expiration date of license
        
     // Click on Date picker to select current date
		String dateWidget = "newManifestDeliveryDate";
		String datePicker = "/html/body/div[4]";
		currentDate(By.id(dateWidget), datePicker);
	
     //Wait for 5 Seconds to see today's date selected
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
     // Select Status from Status drop-down
      String statusID = "status";     
      String statusValue ="Active"; 
      selectDropdownValue(By.id(statusID), statusValue);
      
      
    // Select CDL Required from CDL Required drop-down
      String cdlID = "cdlRequired";     
      String cdlValue ="Active"; 
      selectDropdownValue(By.id(cdlID), cdlValue);
      
      
      
   // Click on Year to enter year
      String year = "licensePlateNumber";
      inputValue(By.id(year), "2019");    
    		



       
        
// // Click on Save Truck to create New Truck  
// // If Save Truck button is disabled should not click on button
//        String createNewDriver = ".btn.mobile-modal-btn-display:not(:disabled)";
//        create(By.cssSelector(createNewDriver));
//        // Wait for 5 Seconds to see Input Values	
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//	}
//


}}





