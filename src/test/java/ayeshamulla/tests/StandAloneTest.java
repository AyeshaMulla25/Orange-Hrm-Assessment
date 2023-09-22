package ayeshamulla.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver",
				"C:\\Users\\ayesha.mulla_coditas\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://narayantomar47-trials710.orangehrmlive.com/auth/seamlessLogin");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("E31IWcW@nk");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('#menu-container').scrollTop=5000");
		driver.findElement(By.xpath("(//a[@data-automation-id='menu_onboarding_Onboarding'])[1]")).click();
        driver.switchTo().frame("noncoreIframe");
        driver.findElement(By.cssSelector("#addItemBtn i")).click();
        driver.findElement(By.id("OhrmJob_name")).sendKeys("Ayesha Mulla");
        driver.findElement(By.xpath("//input[@id='OhrmJob_owners']")).sendKeys("Ayesha");
        driver.findElement(By.xpath("//input[@id='OhrmJob_newHires']")).sendKeys("Automation tester");
        driver.findElement(By.xpath("//input[@id='jobDueDate']")).click();
        String month = driver.findElement(By.cssSelector(".select-dropdown")).getText();
		System.out.println(month);
		boolean isSeptember = month.contains("September");
		while(isSeptember)
		{
			driver.findElement(By.cssSelector("div[title='Next month'")).click();
			Thread.sleep(1000);
			month = driver.findElement(By.cssSelector(".select-dropdown")).getText();
			System.out.println(month);
			isSeptember = month.contains("September");
		}
		int count=driver.findElements(By.cssSelector(".picker__day.picker__day--infocus")).size();

		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.cssSelector(".picker__day.picker__day--infocus")).get(i).getText();
		if(text.equalsIgnoreCase("21"))
		{
		driver.findElements(By.cssSelector(".picker__day.picker__day--infocus")).get(i).click();
		break;
		}
		

	}}}


