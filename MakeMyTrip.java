import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anil\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		//for lang advertise
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]/span[1]")).sendKeys("mumbai");	
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		WebElement from=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[normalize-space()='From']"))));
//		WebElement Efrom=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]/span[1]"))));
		from.click();
		
		Actions action = new Actions(driver);
		action.moveToElement(from).sendKeys("mumbai").sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		WebElement to=driver.findElement(By.xpath("//label[@for='toCity']"));
		to.sendKeys("pune");
		
		//Actions toCity = new Actions(driver);
		action.moveToElement(to).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
	
		driver.findElement(By.xpath("//div [@aria-label=\"Wed Aug 03 2022\"]")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='RETURN']")).click();
		//span[normalize-space()='RETURN']
		
		
		driver.findElement(By.xpath("//div [@aria-label=\"Fri Aug 12 2022\"]")).click();
		driver.findElement(By.xpath("//label[@for=\"travellers\"]")).click();
		driver.findElement(By.xpath("//li[@data-cy=\"adults-4\"]")).click();
		driver.findElement(By.xpath("//li[@data-cy=\"children-2\"]")).click();
		driver.findElement(By.xpath("//li[@data-cy=\"travelClass-2\"]")).click();
		driver.findElement(By.xpath("//button[@data-cy=\"travellerApplyBtn\"]")).click();
		driver.findElement(By.xpath("//p[@data-cy=\"submit\"]")).click();
		driver.close();
		
	}	
}
