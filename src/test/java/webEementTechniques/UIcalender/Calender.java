package webEementTechniques.UIcalender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Calender {
    WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void test() throws InterruptedException {
        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".ui-datepicker-current-day")).click();
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
