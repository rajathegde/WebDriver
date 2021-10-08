package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenshotExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver", "chromedriver");
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.simplilearn.com/");
				//System.setProperty("webdriver.gecko.driver", "geckodriver");
				//WebDriver driver1 = new GeckoDriverInfo();
				//driver1.get("https://www.simplilearn.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
				WebElement LoginLink = driver.findElement(By.linkText("Log in"));
				
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOf(LoginLink));
				
				LoginLink.click();
				
				WebElement UserName = driver.findElement(By.name("user_login"));
				UserName.sendKeys("abc@gmail.com");
				
				WebElement Password = driver.findElement(By.id("password"));
				Password.sendKeys("ABCdefg1234##");
				
				WebElement remember = driver.findElement(By.className("rememberMe"));
				remember.click();
				
				WebElement Login = driver.findElement(By.name("btn_login"));
				Login.click();
				
				WebElement Error = driver.findElement(By.id("msg_box"));
				String ActualMsg = Error.getText();
				String ExpectedMsg = "The email or password you have entered is invalid.";
				
			    TakesScreenshot tsObj = (TakesScreenshot) driver;
		        File image = tsObj.getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(image, new File("screenshot.png"));
				
				if(ActualMsg.equals(ExpectedMsg)) {
					System.out.println("Testcase passed");
				}else {
					System.out.println("Testcase Failed");
					
					
				}
				


	}

}
