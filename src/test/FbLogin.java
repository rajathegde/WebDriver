package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement Header = driver.findElement(By.xpath("//h2"));
		
		if(Header.isDisplayed()) {
			System.out.println("Header is Displayed");
		}else {
			System.out.println("Header is not Displayed");
		}
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
		
		System.out.println(Email.getAttribute("placeholder"));
		Email.sendKeys("abcd@gmail.com");
		
		WebElement Password = driver.findElement(By.xpath("//input[@id='pass']"));
		Password.sendKeys("abcd@gmail.com");
		
		WebElement Login = driver.findElement(By.xpath("//button[@name='login']"));
		Login.click();
		
		driver.quit();

	}

}
