import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_to_cart_end_to_end {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		int j=0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		 String[] veggis= {"Brocolli","Walnuts","Beans","Tomato","Pomegranate","Mango"};
		  List<WebElement> products= driver.findElements(By.cssSelector("h4[class='product-name']"));
		  for(int i=0;i<products.size();i++)
		  {
			String [] name=  products.get(i).getText().split("-");
			String newname=name[0].trim();
			
			List itemlist = Arrays.asList(veggis);
			
			if(itemlist.contains(newname))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==veggis.length)
				{
					break;
				}
			}
		  }
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement dropdown=  driver.findElement(By.cssSelector("select[style='width: 200px;']"));
		Select drpdwn = new Select(dropdown);
		drpdwn.selectByValue("India");
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.quit();

	}

}
