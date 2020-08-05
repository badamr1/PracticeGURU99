package data_Driven_Framework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xml_File {

	public static void main(String[] args) throws DocumentException {
		
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver","E:\\ad\\practice\\Selenium_Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com");
		
		File f = new File("E:\\ad\\practice\\Selenium_Practice\\Input_Data\\properties.xml");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(f);
		
		String username = doc.selectSingleNode("//menu/username").getText();
		String password = doc.selectSingleNode("//menu/password").getText();
		
		driver.findElement(By.className("inputtext")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		driver.quit();
	}

}
