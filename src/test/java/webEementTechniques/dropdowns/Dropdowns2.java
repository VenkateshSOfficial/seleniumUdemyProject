package webEementTechniques.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdowns2 {
    WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void execute() throws InterruptedException {
        driver.findElement(By.cssSelector("div#divpaxinfo")).click();
        Thread.sleep(5000);
        int i=1;
        while(i<5){
            Thread.sleep(2000);
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        String adultCount = driver.findElement(By.id("spanAudlt")).getText();
        System.out.println("The count is : " + adultCount);
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
