import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		driver.findElement(By.cssSelector("button[onclick='myFunctionOne()']")).click();
		 System.out.println(driver.switchTo().alert().getText());
		 driver.switchTo().alert().accept();
		 driver.findElement(By.xpath("//button[text()='Confirm Alert Box']")).click();
		 System.out.println(driver.switchTo().alert().getText());
		 driver.switchTo().alert().dismiss();
		  driver.close();
		  
			
	}

}
