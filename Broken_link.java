import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_link {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		for(WebElement link: links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int rescode=connection.getResponseCode(); 
			System.out.println(rescode);
			a.assertTrue(rescode<400, "the lik with text"+" "+ link.getText()+ " "+"is broken with code"+" "+ rescode);
			
			
		}
		a.assertAll();
		
		

	}

}
