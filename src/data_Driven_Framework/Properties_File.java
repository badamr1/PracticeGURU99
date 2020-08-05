package data_Driven_Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Properties_File {

	public static void main(String[] args) throws IOException {

		WebDriver driver = null;

		Properties prop = new Properties();
		File f = new File("E:\\ad\\practice\\Selenium_Practice\\Input_Data\\config.properties");
		FileInputStream fis = new FileInputStream(f);

		prop.load(fis);
		String browser_name = prop.getProperty("browser");
		System.out.println(browser_name);

		if (browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\ad\\practice\\Selenium_Practice\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser_name.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\ad\\practice\\Selenium_Practice\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser_name.equals("IE")) {
			System.setProperty("webdriver.ie.driver","E:\\ad\\practice\\Selenium_Practice\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		driver.quit();
		
	}

}
