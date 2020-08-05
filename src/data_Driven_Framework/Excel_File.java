package data_Driven_Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel_File {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;

		File f = new File("E:\\ad\\practice\\Selenium_Practice\\Input_Data\\Login_Data.xlsx");
		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");

		for (int row = 0; row <= sh.getLastRowNum(); row++) {

			String username = sh.getRow(row).getCell(0).getStringCellValue();
			System.out.println(username);
			String password = sh.getRow(row).getCell(1).getStringCellValue();
			System.out.println(password);

			System.setProperty("webdriver.chrome.driver","E:\\ad\\practice\\Selenium_Practice\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			driver.get("https://www.freecharge.in");
			driver.findElement(By.xpath("//a[@class = '_3mvx0']")).click();
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			
		}
		
		driver.quit();

	}

}
