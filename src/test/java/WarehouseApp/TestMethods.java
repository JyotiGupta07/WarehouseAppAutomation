package WarehouseApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TestMethods {
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


//Verify URL and move on particular page

	public void navigateToPage(String pageId) throws InterruptedException {
		String pageUrl = this.appUrl + pageId;
		driver.navigate().to(pageUrl);
		Thread.sleep(2000);
	}
	
	


public void openTruckListPage() throws InterruptedException {

	// Open Truck List Page
	navigateToPage("/truck-list");
	Thread.sleep(5000);
}
}