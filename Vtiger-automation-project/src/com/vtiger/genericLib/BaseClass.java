package com.vtiger.genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass  {
	public static WebDriver driver;
	public DataUtility du = new DataUtility();
	
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void launchBrowser(String browser) {
		if(browser.equals("chrome")) {
		System.out.println("chrome broswer launch");
		System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\chromedriver\\\\\\\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
		System.out.println("firefox browser launch");
		System.setProperty("webdriver.gecko.driver", "D:\\\\\\\\chromedriver\\\\\\\\chromedriver.exe");
		driver = new FirefoxDriver();
		}else if(browser.equals("opera")) {
		System.out.println("opera browser launch");
		System.setProperty("webdriver.opera.driver", "D:\\\\\\\\chromedriver\\\\\\\\chromedriver.exe");
		driver = new OperaDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException {
		driver.get(du.getDataFromProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(du.getDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(du.getDataFromProperty("password"));
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod(alwaysRun=true)
	public void logout() {
		WebElement signOut = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		Actions act = new Actions(driver);
		act.moveToElement(signOut).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
}
