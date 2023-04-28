package org.amazon.cases;

import org.amazon.drivers.DriverSetup;
import org.amazon.pom.AmazonHomePage;
import org.amazon.pom.AmazonLoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AmazonTC extends DriverSetup{

	//@org.junit.Test(enabled = false)
	public void login() throws InterruptedException {
		AmazonLoginPage lp = new AmazonLoginPage(driversetup("chrome"));
		lp.nav_signin_page();
		lp.user_name("9490419487");
		lp.continuebtn();
		lp.password("@Rama1974*");
		Thread.sleep(500);
		lp.signin();
		Thread.sleep(500);
		System.out.println("Login Successfully");
		driverexit();

	}

	@Test
	public  static void searchitem_addtocart() throws InterruptedException, IOException {
		AmazonHomePage hp = new AmazonHomePage(driversetup("chrome"));
		Thread.sleep(500);
		hp.searchbutton();
		hp.getitemstext();
		hp.clickonfirstresult();
		driver.getWindowHandle();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(500);
		hp.add_cart_button();

		Thread.sleep(5000);
		hp.added_to_cart();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot to a file
		FileUtils.copyFile(screenshot, new File("C:\\Users\\sree_r\\Desktop\\eclipse-workspace\\" +
				"Amazon\\src\\main\\java\\org\\amazon\\screenshots\\" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png"));
		//hp.added_to_cart();
		driverexit();
	}



}
