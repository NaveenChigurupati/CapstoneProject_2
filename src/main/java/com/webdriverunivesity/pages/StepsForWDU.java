package com.webdriverunivesity.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsForWDU {
	WebDriver driver;

	public StepsForWDU(WebDriver driver) {
		this.driver=driver;
	}
	
	/*
	 * public void launchBrowser() {
	 * 
	 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
	 * driver.manage().window().maximize(); }
	 */
	
	
	public boolean verifyTitleOfPage() {
		return driver.findElement(By.xpath("//a[@class='navbar-brand']")).isDisplayed();
	}
	
	public void clickOniframe(String elementToBeClicked) {
		System.out.println("element is" + elementToBeClicked);
		
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		WebElement iframe=driver.findElement(By.id(elementToBeClicked));
		jsexecutor.executeScript("arguments[0].scrollIntoView(true);",iframe);
		iframe.click();
	}
	public boolean switch_to_that_tab() {
		ArrayList<String> tab= new ArrayList<String>(driver.getWindowHandles());
		tab.size();
		driver.switchTo().window(tab.get(1));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[\"WebdriverUniversity.com (IFrame)\"]"))).isDisplayed();
		
	}
	
	public void verifyImageChanges() throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slide-image-1"))).isDisplayed();
		//driver.findElement(By.xpath("//img[@id='slide-image-1']")).isDisplayed();
		WebElement rightArrow=driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-right']"));
		rightArrow.click();
        Thread.sleep(3000);
        WebElement image3=driver.findElement(By.id("slide-image-3"));
        image3.isDisplayed();
        
	   }
	
     public void close() {
    	 driver.close();
     }
	

}
