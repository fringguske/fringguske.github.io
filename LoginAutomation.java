package AutomationScripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.JavascriptExecutor;

public class LoginAutomation {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
        System.setProperty("webdriver.edge.driver", "C:\\Users\\USER\\Desktop\\my data\\selenium drivers\\msedgedriver.exe");
     
        WebDriver driver = new EdgeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
		driver.get("https://www.booking.com");
		Thread.sleep(1000);
    
	WebElement changeCurrency=driver.findElement(By.cssSelector("button[aria-label='Prices in Kenyan Shilling'] span[class='e4adce92df']"));
	changeCurrency.click();
	Thread.sleep(1000);
	
	WebElement selectedCurrency=driver.findElement(By.xpath("//div[@data-testid='Suggested for you']//div[contains(@class,'ea1163d21f')][normalize-space()='USD']"));
	selectedCurrency.click();
	Thread.sleep(1000);
	
	WebElement SelectPlaceToGo=driver.findElement(By.id(":re:"));
	SelectPlaceToGo.sendKeys("New York");
	Thread.sleep(1500);
	
	WebElement SelectedPlaceToGo=driver.findElement(By.cssSelector("li[id='autocomplete-result-0'] div[class='abf093bdfe d2f04c9037']"));
	// Scroll the element into view
	// Get the height of the viewport
	Long windowHeight = (Long) ((JavascriptExecutor) driver).executeScript("return window.innerHeight");

	// Calculate the position to scroll to (3/4 of the screen)
	Double sizeValue=0.0625;
	Double scrollToPosition = windowHeight * sizeValue;

	// Scroll the element into view at 3/4 of the screen
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'nearest'});", SelectedPlaceToGo);
	Thread.sleep(1000);
	SelectedPlaceToGo.click();
	Thread.sleep(2000);
	
	WebElement SelectDates=driver.findElement(By.cssSelector("button[data-testid='date-display-field-start']"));
	SelectDates.click();
	String CheckInDate="20 March 2024";
	String CheckOutDate="25 March 2024";
	Thread.sleep(1000);
	WebElement SelectedStartDate=driver.findElement(By.cssSelector("span[aria-label='"+CheckInDate+"']"));
	//WebElement SelectedStartDate=driver.findElement(By.xpath("(//span[@aria-label='"+CheckInDate+"'])[1]"))
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'nearest'});", SelectedStartDate);
    Thread.sleep(1000);
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SelectedStartDate);
	SelectedStartDate.click();
	
	WebElement SelectedEndDate=driver.findElement(By.cssSelector("span[aria-label='"+CheckOutDate+"']"));
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SelectedEndDate);
	SelectedEndDate.click();
	
	WebElement NumberOfPeople=driver.findElement(By.cssSelector(".a83ed08757.ebbedaf8ac.ada2387af8"));
	NumberOfPeople.click();
	int NoOfadults=20;
	int NoOfchildren=0;
	//int ageOfChild=1;
	int NoOfRooms=2;
	Thread.sleep(1000);
	
	WebElement initializeNoOfAdults=driver.findElement(By.cssSelector(".a83ed08757.c21c56c305.f38b6daa18.d691166b09.ab98298258.deab83296e.bb803d8689.e91c91fa93"));
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", initializeNoOfAdults);
	WebElement settingNumberOfAdults=driver.findElement(By.xpath("(//button[@type='button'])[8]"));
	initializeNoOfAdults.click();
	int initializedValue=1;
	int i=NoOfadults-initializedValue;
	System.out.println(i);
	for (int v=0; v< i;v++) {
		settingNumberOfAdults.click();
	};
	
	WebElement settingNumberOfChildren=driver.findElement(By.xpath("(//button[@type='button'])[10]"));
	int j=NoOfchildren;
	for (int v=0; v< j;v++) {
		settingNumberOfChildren.click();
	};
	//WebElement Age=driver.findElement(By.xpath("(//select[@id=':r11:'])[1]"));
	//Age.click();
	
	//WebElement SelectedAge=driver.findElement(By.xpath("(//option[@value='0'])[1]"));
	//SelectedAge.click();
	int k=NoOfRooms-1;
	WebElement setNoOfRooms=driver.findElement(By.xpath("(//button[@type='button'])[12]"));
	for (int v=0; v< k;v++) {
		setNoOfRooms.click();
	};
	
	WebElement Done=driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 bf0537ecb5 ab98298258 d2529514af af7297d90d c213355c26'])[1]"));
	Done.click();
	
	WebElement Search=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
	Search.click();
	
	Thread.sleep(10000);
	driver.quit();
	}
}