import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flight_Booking_end_to_end {

	public static void main(String[] args) {
		
		
				WebDriverManager.edgedriver().setup();
				WebDriver driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				driver.findElement(By.xpath("//input[@placeholder='Type to Select']")).sendKeys("Ind");
				List<WebElement> Options= driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
				for(WebElement Option :Options)
				{
					if(Option.getText().equalsIgnoreCase("India"))
					{
						Option.click();
						break;
					}
				}
				driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
				driver.findElement(By.cssSelector("a[value='BLR']")).click();
				driver.findElement(By.xpath("(//a[@value='HBX'])[2]")).click();
				driver.findElement(By.cssSelector("input[name='ctl00$mainContent$view_date1']")).click();
				List<WebElement> dates= driver.findElements(By.cssSelector("td[data-month='7']"));
				for(int i=0; i<dates.size(); i++)
				{
				String value =dates.get(i).getText();
				if(value.equalsIgnoreCase("29"))
				{
					dates.get(i).click();
					break;
				}
				}
				driver.findElement(By.id("divpaxinfo")).click();
				int j=1;
				while(j<2)
				{
					driver.findElement(By.id("hrefIncAdt")).click();
					j++;
				}
				int k=1;
				while(k<2)
				{
					driver.findElement(By.id("hrefIncChd")).click();
				k++;
				}
					driver.findElement(By.id("btnclosepaxoption")).click();
					driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
					driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
					WebElement staticdropdown=  driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
					Select dropdown = new Select(staticdropdown);
					dropdown.selectByValue("USD");
					driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
					driver.switchTo().alert().accept();
					driver.findElement(By.id("divpaxinfo")).click();
					int l=1;
					while(l<4)
					{
						driver.findElement(By.id("hrefIncAdt")).click();
						l++;
					}
					driver.findElement(By.id("btnclosepaxoption")).click();
					driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
					driver.close();

			}

	


	}

