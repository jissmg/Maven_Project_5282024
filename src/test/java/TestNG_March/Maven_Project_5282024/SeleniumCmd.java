package TestNG_March.Maven_Project_5282024;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCmd {
	WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
	}
//@Test
//public void validateSignUp() {
//		String generatestring = RandomStringUtils.randomAlphabetic(12);
//		String email = generatestring + "@gmail.com";
//		// Filling Form
//		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("jis");
//		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("George");
//		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("jismaria@gmail.com");
//
//		driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("7052975194");
//
//		// Setting Up Password
//		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Password123");
//		driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys("Password123");
//
//		// Checking the check box
//		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
//
//		// Submit the form
//		driver.findElement(By.cssSelector("input[type='checkbox']")).submit();
//
//		String accountCreatedText = driver.findElement(By.cssSelector("#content h1")).getText();
//
//		Assert.assertEquals(accountCreatedText, "Your Account Has Been Created!",
//				"Account creation text did not match");
//		driver.findElement(By.cssSelector("div a[class='btn btn-primary']")).click();
//

	@Test(priority = 1)
	public void validateLoginUser() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div input[name='email']")).sendKeys("jismaria@gmail.com");
		driver.findElement(By.cssSelector("div input[name='password']")).sendKeys("Password123");
		driver.findElement(By.cssSelector("div input[type='submit']")).submit();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void checkForgotPassword() throws InterruptedException {
		String forgottenPassword = driver.findElement(By.cssSelector("#content form div:last-of-type a")).getText();
		Assert.assertEquals(forgottenPassword, "Forgotten Password", "Forgotten Password");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#content form div:last-of-type a")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void resetPasswordUsingEmail() throws InterruptedException {
		driver.findElement(By.cssSelector("#column-right>div a:nth-of-type(3)")).click();
		String forgotPassword = driver.findElement(By.cssSelector("#content h1")).getText();

		Assert.assertEquals(forgotPassword, "Forgot Your Password?", "Forgot Your Password?");

		driver.findElement(By.cssSelector("input#input-email.form-control")).sendKeys("jismaria@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div input[value='Continue']")).submit();
		Thread.sleep(3000);
		String passwordResetWithEmail = driver
				.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText();
		Assert.assertEquals(passwordResetWithEmail,
				"An email with a confirmation link has been sent your email address.",
				" An email with a confirmation link has been sent your email address.");
		Thread.sleep(3000);

	}

	@AfterMethod
	public void close() {
		// driver.close();
		driver.quit();
	}

}
