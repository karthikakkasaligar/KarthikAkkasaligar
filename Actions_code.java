import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_code {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("input[placeholder='Search Amazon.in']"))).click().keyDown(Keys.SHIFT).sendKeys("earphones").build().perform();
		a.moveToElement(driver.findElement(By.xpath("//div[@class='nav-line-1-container']"))).build().perform();
		//driver.close();

	}

}
