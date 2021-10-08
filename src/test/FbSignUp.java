package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement SignUp = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		SignUp.click();
		
        WebElement FirstName = driver.findElement(By.cssSelector("input[name=firstname]"));
        FirstName.sendKeys("John");
        
        List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']/option"));
        for(int i=1;i<months.size();i++) {
        	WebElement data= driver.findElement(By.xpath("//select[@id='month']/option[" + i + "]"));
        	System.out.println(data.getText());
        	
        	//System.out.println(months.get(i).getText());
        }
        
        
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select ddday = new Select(day);
		ddday.selectByVisibleText("8");
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select ddmonth = new Select(month);
		ddmonth.selectByIndex(3);
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select ddyear = new Select(year);
		ddyear.selectByValue("1996");
		
		WebElement MaleRadio = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		MaleRadio.click();
		//driver.quit();

	}

}
