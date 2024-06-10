package TestNG_March.Maven_Project_5282024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class PurchaseAProduct {
	WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void validateLoginUser() {
		driver.findElement(By.cssSelector("div input[name='email']")).sendKeys("jismaria@gmail.com");
		driver.findElement(By.cssSelector("div input[name='password']")).sendKeys("Password123");
		driver.findElement(By.cssSelector("div input[type='submit']")).submit();
		driver.findElement(By.cssSelector("#account-account> ul li:first-of-type a")).click();
		driver.findElement(By.cssSelector("img[title='MacBook']")).click();
		driver.findElement(By.cssSelector("button#button-cart ")).click();

		String addToCartText=driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("MacBook",addToCartText, "MacBook");
		driver.findElement(By.cssSelector("span#cart-total ")).click();
		driver.findElement(By.cssSelector("ul li div p a:last-of-type")).click();
		//driver.findElement(By.cssSelector("#cart button[aria-expanded='true']")).click();

		String chechoutText=driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Checkout",chechoutText, "Checkout");
		driver.findElement(By.cssSelector("div input[value='new']")).click();
		
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("jis");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("George");
		driver.findElement(By.cssSelector("input[name='company']")).sendKeys("Chartwell");
		driver.findElement(By.cssSelector("input[name='address_1']")).sendKeys("Allen Street");
		driver.findElement(By.cssSelector("input[name='address_2']")).sendKeys("27");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Sault Ste. Marie");
		driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("P6A 1V5");
		WebElement selectElement = driver.findElement(By.cssSelector("#input-payment-country"));
		Select sc = new Select(selectElement);
		sc.selectByVisibleText("Canada");
	
		WebElement selectElement1 = driver.findElement(By.cssSelector("select[name='zone_id']"));
		Select select = new Select(selectElement1);
	
		select.selectByVisibleText("Ontario");
	
		driver.findElement(By.cssSelector("#button-payment-address")).click();
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		//driver.findElement(By.cssSelector("button-payment-method")).click();
	}
	@AfterMethod
	public void close() {
		driver.close();
		//driver.quit();
	}

	}
