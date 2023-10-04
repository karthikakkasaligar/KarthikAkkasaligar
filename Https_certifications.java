import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Https_certifications {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions options =new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
	    System.out.println(driver.getTitle());
	    File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(f, new File("C:\\Users\\dell\\Downloads\\sample\\ss.png"));

	}

}
