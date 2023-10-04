import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action_on_Multiple_windows {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		 Set<String> window= driver.getWindowHandles();
		  Iterator<String> it= window.iterator();
		 String parentid=  it.next();
		 String childid= it.next();
		 driver.switchTo().window(childid);
		 Thread.sleep(2000);
		 driver.get("https://rahulshettyacademy.com/");
         String coursename= driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
         driver.switchTo().window(parentid);
         driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys(coursename);

	}

}
