package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	String baseUrl = "https://parabank.parasoft.com";
	String driverPath = "C:\\Users\\sowja\\Downloads\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe";

	@BeforeTest
	public void first() {

		System.setProperty("webdriver.chrome.driver", driverPath);

		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void logon() {
		WebElement webelement = driver.findElement(By.name("username"));
		webelement.sendKeys("Fresh");
		WebElement webelement1 = driver.findElement(By.name("password"));
		webelement1.sendKeys("Start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement webelement2 = driver.findElement(By.xpath("//input[@value='Log In']"));
		webelement2.click();
	}

	@Test(priority = 1)
	public void openNewAccount() {
		driver.findElement(By.linkText("Open New Account")).click();
		WebElement webelement4 = driver.findElement(By.xpath("//select[@ng-model='types.selectedOption']"));

		Select accounttype = new Select(webelement4);
		accounttype.selectByVisibleText("CHECKING");

		WebElement webelement5 = driver.findElement(By.xpath("//select[@ng-model='accounts.selectedOption']"));

		Select account = new Select(webelement5);
		account.selectByVisibleText("15231");
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		System.out.println("Title of the page is :" + driver.getTitle());
		//AssertJUnit.assertEquals(driver.getTitle(), "ParaBank | Open Account");
		AssertJUnit.assertEquals("expected result is not actual result", driver.getTitle(), "ParaBank | Open Account1");;
	}
}
