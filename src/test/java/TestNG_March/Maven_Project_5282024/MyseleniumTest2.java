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
        return "chrome"; //change to firefox or edge
    }

    

    @Test
    public void validateLoginFunctionality() throws InterruptedException {
    	String generatestring= RandomStringUtils.randomAlphabetic(12);
    	String firstname=generatestring;
    	String lastname=generatestring;
    	String email=generatestring+"@gmail.com";
    	String username=generatestring;
    	String password=generatestring;
        driver.get("https://classic.freecrm.com/register/");
        driver.findElement(By.cssSelector("div select[name='payment_plan_id']>option[value='1']")).click();// select drop down directly 
        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys(firstname);
        driver.findElement(By.cssSelector("input[name='surname']")).sendKeys(lastname);
        driver.findElement(By.cssSelector("div input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("div input[name='email_confirm']")).sendKeys(email);
        driver.findElement(By.cssSelector("div input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("div input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("div input[name='passwordconfirm']")).sendKeys(password);
        driver.findElement(By.cssSelector("div input[type='checkbox']")).click();
        Thread.sleep(3000);
       // driver.findElement(By.cssSelector("div[class='myButton']")).click();
        
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
