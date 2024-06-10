package TestNG_March.Maven_Project_5282024;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class MyFirstSeleniumTest {
	@Test
	public void validateLoginFunctionality() throws InterruptedException {
		// setup logic of driver
		WebDriverManager.edgedriver().setup();
		// Initialize a driver instance
		WebDriver driver = new EdgeDriver();

		// load a page URL
		driver.get("https://classic.freecrm.com/register/");
		Thread.sleep(3000);
		String generatestring= RandomStringUtils.randomAlphabetic(12);
    	String email=generatestring+"@gmail.com";
    	String username=generatestring;
		// identify elements on DOM using CSS 1st page
		//WebElement editionInput = driver.findElement(By.cssSelector("select#payment_plan_id"));
		WebElement editionInput1 = driver.findElement(By.cssSelector("select option[value='1']"));
		WebElement firstnameInput = driver.findElement(By.cssSelector("input[name='first_name']"));
		WebElement lastnameInput = driver.findElement(By.cssSelector("input[name='surname']"));
		WebElement emailInput = driver.findElement(By.cssSelector("div input[name='email']"));
		WebElement emailConfirmInput = driver.findElement(By.cssSelector("div input[name='email_confirm']"));
		WebElement usernameInput = driver.findElement(By.cssSelector("div input[name='username']"));
		WebElement passwordInput = driver.findElement(By.cssSelector("div input[name='password']"));
		WebElement passwordconfirmInput = driver.findElement(By.cssSelector("div input[name='passwordconfirm']"));
		WebElement agreeInput = driver.findElement(By.cssSelector("div input[type='checkbox']"));
		WebElement submitInput = driver.findElement(By.cssSelector("div[class='myButton']"));

		// perform action 1stpage
		editionInput1.click();
		firstnameInput.sendKeys("Ammu");
		lastnameInput.sendKeys("George");
		emailInput.sendKeys(email);
		emailConfirmInput.sendKeys(email);
		usernameInput.sendKeys(username);
		passwordInput.sendKeys("123ammu");
		passwordconfirmInput.sendKeys("123ammu");
		agreeInput.click();
		submitInput.click();

		// 2nd page
		
		WebElement companyInput = driver.findElement(By.cssSelector("input[name='company_name']"));
		WebElement phoneInput = driver.findElement(By.cssSelector("input[name='phone']"));
		WebElement faxInput = driver.findElement(By.cssSelector("input[name='fax']"));
		WebElement webInput = driver.findElement(By.cssSelector("input[name='website']"));
		WebElement comEmailInput = driver.findElement(By.cssSelector("input[name='company_email']"));
		WebElement descriptionInput = driver.findElement(By.cssSelector("div textarea[name='service']"));
		WebElement addressInput = driver.findElement(By.cssSelector("div textarea[name='address']"));
		WebElement cityInput = driver.findElement(By.cssSelector("div input[name='city']"));
		WebElement postInput = driver.findElement(By.cssSelector("div input[name='postcode']"));
		WebElement countryInput = driver.findElement(By.cssSelector("div select[name='country'] option[value='Canada']"));
		WebElement stateInput = driver.findElement(By.cssSelector("div input[name='state']"));
		WebElement selectInput = driver.findElement(By.cssSelector("label input[name='copy_address']"));
		WebElement subInput = driver.findElement(By.cssSelector("div[class='btnSubmit']"));
		
		companyInput.sendKeys("Chartwell");
		phoneInput.sendKeys("7052975194");
		faxInput.sendKeys("800625020");
		webInput.sendKeys("www.chartwell.com");
		comEmailInput.sendKeys("awolf@chartwell.in");
		descriptionInput.sendKeys("Dietary");
		addressInput.sendKeys("27 Allen Street");
		cityInput.sendKeys("Sault Ste. Marie");
		stateInput.sendKeys("Ontario");
		postInput.sendKeys("P6A 1V5");
		countryInput.click();
		selectInput.click();
		subInput.click();
		
		//page3
	
		WebElement firnameInput = driver.findElement(By.cssSelector("input[name='first_name']"));
		WebElement lanameInput = driver.findElement(By.cssSelector("input[name='surname']"));
		WebElement mailInput = driver.findElement(By.cssSelector("div input[name='email']"));
		WebElement mailConfirmInput = driver.findElement(By.cssSelector("div input[name='email_confirm']"));
		WebElement userInput = driver.findElement(By.cssSelector("div input[name='username']"));
		WebElement passInput = driver.findElement(By.cssSelector("div input[name='password']"));
		WebElement passconfirmInput = driver.findElement(By.cssSelector("div input[name='passwordconfirm']"));
		WebElement roleInput = driver.findElement(By.cssSelector("select option[value='3']"));
		//WebElement addInput = driver.findElement(By.cssSelector("div button[type='submit']"));
		WebElement completeInput = driver.findElement(By.cssSelector("div button[name='finish']"));
		
		firnameInput.sendKeys("Ammu");
		lanameInput.sendKeys("George");
		mailInput.sendKeys(email);
		mailConfirmInput.sendKeys(email);
		userInput.sendKeys(username);
		passInput.sendKeys("123ammu");
		passconfirmInput.sendKeys("123ammu");
		roleInput.click();
	//	addInput.click();
		completeInput.click();
		// close browser
	
		
	driver.close();
	}

}
