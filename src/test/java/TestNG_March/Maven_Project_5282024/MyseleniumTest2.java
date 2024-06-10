package TestNG_March.Maven_Project_5282024;

import io.github.bonigarcia.wdm.WebDriverManager; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;

public class MyseleniumTest2 {

	private WebDriver driver;

	@BeforeMethod
	public void setupBrowser() {
		String browser = getBrowser();
		driver = getDriver(browser);
	}

	private String getBrowser() {
		// You can change the browser here to chrome, firefox, or edge
		return "chrome"; // change to firefox or edge
	}

	@Test
	public void validateLoginFunctionality() throws InterruptedException {
		Thread.sleep(3000);
		String generatestring = RandomStringUtils.randomAlphabetic(12);
		String firstname = generatestring;
		String lastname = generatestring;
		String email = generatestring + "@gmail.com";
		String username = generatestring;
		String password = generatestring;

		driver.get("https://classic.freecrm.com/register/");
		driver.findElement(By.cssSelector("div select[name='payment_plan_id']>option[value='1']")).click();// select
																											// drop down
																											// directly
		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys(firstname);
		driver.findElement(By.cssSelector("input[name='surname']")).sendKeys(lastname);
		driver.findElement(By.cssSelector("div input[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("div input[name='email_confirm']")).sendKeys(email);
		driver.findElement(By.cssSelector("div input[name='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("div input[name='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("div input[name='passwordconfirm']")).sendKeys(password);
		driver.findElement(By.cssSelector("div input[type='checkbox']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[class='myButton']")).click();
		//2nd page
		String company = generatestring;
		String companyweb = "www." + generatestring + ".com";
		String companyemail = generatestring + "@gmail.com";
		
		driver.findElement(By.cssSelector("input[name='company_name']")).sendKeys(company);
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("7052975194");
		driver.findElement(By.cssSelector("input[name='fax']")).sendKeys("800625020");
		driver.findElement(By.cssSelector("input[name='website']")).sendKeys(companyweb);
		driver.findElement(By.cssSelector("input[name='company_email']")).sendKeys(companyemail);
		driver.findElement(By.cssSelector("div textarea[name='service']")).sendKeys("Dietary");
		driver.findElement(By.cssSelector("div textarea[name='address']")).sendKeys("27 Allen Street");
		driver.findElement(By.cssSelector("div input[name='city']")).sendKeys("Sault Ste. Marie");
		driver.findElement(By.cssSelector("div input[name='postcode']")).sendKeys("P6A 1V5");
		driver.findElement(By.cssSelector("div input[name='state']")).sendKeys("Ontario");
		driver.findElement(By.cssSelector("div select[name='country'] option[value='Canada']")).click();
		driver.findElement(By.cssSelector("label input[name='copy_address']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[class='btnSubmit']")).click();
		//3rd page
		String newusername = generatestring+"123";
		String newpassword = generatestring;
		driver.findElement(By.cssSelector("div input[placeholder='First Name']")).sendKeys(firstname);
		driver.findElement(By.cssSelector("div input[placeholder='Last Name']")).sendKeys(lastname);
		driver.findElement(By.cssSelector("div input[placeholder='Email']")).sendKeys(email);
		driver.findElement(By.cssSelector("div input[placeholder='Confirm Email']")).sendKeys(email);
		driver.findElement(By.cssSelector("div input[placeholder='Username']")).sendKeys(newusername);
		driver.findElement(By.cssSelector("div input[name='password']")).sendKeys(newpassword);
		driver.findElement(By.cssSelector("div input[name='passwordconfirm']")).sendKeys(newpassword);
		driver.findElement(By.cssSelector("select option[value='3']")).click();
		//driver.findElement(By.cssSelector("div button[type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div button[name='finish']")).click();
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(newusername);
		driver.findElement(By.cssSelector("div input[name='password']")).sendKeys(newpassword);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void close() {
		if (driver != null) {
			driver.close();
		}
	}

	private WebDriver getDriver(String browser) {
		WebDriver driver;
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		return driver;
	}
}
