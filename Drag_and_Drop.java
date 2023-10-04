import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_and_Drop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame lazyloaded']")));	
		Actions a = new Actions(driver);
		WebElement S1 = driver.findElement(By.cssSelector("img[alt='The peaks of High Tatras']"));
		WebElement S2= driver.findElement(By.cssSelector("div[id='trash']"));
		a.dragAndDrop(S1, S2).build().perform();
		WebElement S3 =driver.findElement(By.cssSelector("img[alt='The chalet at the Green mountain lake']"));
		WebElement S4= driver.findElement(By.cssSelector("div[id='trash']"));
		a.dragAndDrop(S3, S4).build().perform();
		driver.close();
		

	}

}
