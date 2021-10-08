package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		List<WebElement> table_row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int cnt = table_row.size();
		System.out.println("No of row size:"+cnt);
		

		List<WebElement> table_col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println("No of columns are:"+table_col.size());
		for(int i=2;i<table_row.size();i++) {
            
            WebElement data1 = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[1]"));
            System.out.println(data1.getText());
        }
		
		WebElement elem = driver.findElement(By.xpath("//*[text()='Define an HTML Table']"));
        
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elem);//to scroll down
		driver.quit();
		
	}

}
