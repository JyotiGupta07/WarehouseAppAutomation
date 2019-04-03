package WarehouseApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DriverPage extends GenericMethod {

	
	@Test
	public void openDriverListPage() throws InterruptedException {

		// Open Driver List Page
		navigateToPage("/driver-list/warehousing");
		Thread.sleep(5000);
	}
	
//------------------------ Driver Creation ----------------------	
	// -------- Open New Driver Modal Page ------------------
	@Test(priority =1)
	public void createDriver() throws InterruptedException {
			
		// Open New Driver Modal Page
			//String createDriverModal = "//*[@id=\"containerFluid\"]/drivers-list/div/h2/button";
			String createDriverModal = "//*[@id=\"containerFluid\"]/drivers-list/div/div[1]/div/button";
			newModalPage(By.xpath(createDriverModal));
			Thread.sleep(1000);
			
		// Click on First Name to enter first Name
	        String firstName = "firstname";
	        inputValue(By.id(firstName), "Joy");
	        
	    // Click on Last Name to enter first Name
	        String lastName = "lastname";
	        inputValue(By.id(lastName), "abc");
	        
	    // Click on Last Name to enter first Name
	        String alias = "alias";
	        inputValue(By.id(alias), "abcd");
	        
		
	   // Select Rank from Rank drop-down
	        String rankID = "rank";     
	        String rankValue ="Secondary"; 
	        selectDropdownValue(By.id(rankID), rankValue);  
	        
	     // Select Status from Status drop-down
	        String statusID = "status";     
	        String statusValue ="Active"; 
	        selectDropdownValue(By.id(statusID), statusValue);
	        
	        
	     // Select Adjustment from Adjustment drop-down
	        String adjustmentID = "adjustment";     
	        String adjustmentValue ="Yes"; 
	        selectDropdownValue(By.id(adjustmentID), adjustmentValue);
	        
	    // Select Employee from Employee drop-down
	        String employeeID = "emp";     
	        String employeeValue ="No"; 
	        selectDropdownValue(By.id(employeeID), employeeValue);
	     
	    // Select CDL from CDL drop-down
	        String cdlID = "cdl";     
	        String cdlValue ="No"; 
	        selectDropdownValue(By.id(cdlID), cdlValue);
	        
	    // Add User name
	        String userName = "username";
	        inputValue(By.id(userName), "abcd");
	        
	        
	 // Click on Save Driver to create New Driver  
	 // If Save Driver button is disabled should not click on button
	        String createNewDriver = ".btn.mobile-modal-btn-display:not(:disabled)";
	        create(By.cssSelector(createNewDriver));
	        // Wait for 5 Seconds to see Input Values	
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	
//------------------------ Driver Creation complete----------------------	
	
//------------------------ Update Driver ------------------------
    @Test(priority =2)
	public void updateDriver() throws InterruptedException {
	// Open Driver List Page
//	navigateToPage("/driver-list");
//	Thread.sleep(2000); 
	// Select Driver from Drop-Down
    String driverID = "driverNameSelect";     
    String driverValue ="Joy abc (abcd)"; 
    selectDropdownValue(By.id(driverID), driverValue);
    
    String clickValue = "//a[contains(.,'Joy abc')]";
    update(By.xpath(clickValue));
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
 // Add User name
    String userName = "username";
    currentTime(By.id(userName), "abcdef");
    
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    
    String updateDriver = "//span[text()='Save Driver']";
    create(By.xpath(updateDriver));
    
//    updateButton.click();
//
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
 }
    
 //---------------- Delete Driver--------------------------   
    @Test(priority = 3)
    public void deleteDriver() throws InterruptedException {
    	
    	// Open Driver List Page
    	navigateToPage("/driver-list");
    	Thread.sleep(2000); 
    	// Select Driver from Drop-Down
        String driverID = "driverNameSelect";     
        String driverValue ="Joy abc (abcd)"; 
        selectDropdownValue(By.id(driverID), driverValue);
        
        String clickValue = "//a[contains(.,'Joy abc')]";
        update(By.xpath(clickValue));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String deleteButton = "//span[text()='Delete Driver']";
        delete(By.xpath(deleteButton));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        clickOnAlert();
//        
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
	
}








