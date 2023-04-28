package org.amazon.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {

	public static WebDriver driver;
	   static String url ="https://www.amazon.in/";

	   public static WebDriver driversetup(String browser)
	   {
		   if(browser.equalsIgnoreCase("chrome"))
		   {
			   System.setProperty("webdriver.chrome.driver", "C:\\Users\\sree_r\\Desktop\\eclipse-workspace\\Amazon\\src\\main\\java\\org\\amazon\\drivers\\chromedriver_112.exe");

			   ChromeOptions ops = new ChromeOptions();
			   ops.addArguments("--remote-allow-origins=*");
			   ops.addArguments("--disable-notifications");
			   ops.addArguments("start-maximized");
			   driver = new ChromeDriver(ops);
			   driver.get(url);
			   return driver;
		   }
		   else if(browser.equalsIgnoreCase("edge"))
		   {
			   System.setProperty("webdriver.edge.driver", "C:\\Users\\sree_r\\Desktop\\eclipse-workspace\\Amazon\\src\\main\\java\\org\\amazon\\drivers\\msedgedriver.exe");
			   driver = new EdgeDriver();
			   driver.manage().window().maximize();

			   driver.get(url);
			   return driver;
		   }
		return null;

	   }

	   public static void driverexit()
	   {
		   driver.close();
		   driver.quit();
	   }

}
