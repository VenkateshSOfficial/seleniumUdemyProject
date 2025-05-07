package webEementTechniques.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeAlerts {
    WebDriver driver;
    ChromeOptions options;
    Alert alert;

    public Alert switchToAlert(){
        alert = driver.switchTo().alert();
        return alert;
    }
    @BeforeTest
    public void launchBrowser(){
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test(priority = 0)
    public void execute() throws InterruptedException {
        driver.findElement(By.cssSelector("#alertbtn")).click();
        Thread.sleep(2000);
        System.out.println("The text is : " + switchToAlert().getText());
        Thread.sleep(2000);
        switchToAlert().accept();
    }
    @Test(priority = 1)
    public void execute1() throws InterruptedException {
        driver.findElement(By.cssSelector("input#name")).sendKeys("Kaushik");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#alertbtn")).click();
        Thread.sleep(2000);
        System.out.println("The text is : " + switchToAlert().getText());
        Thread.sleep(2000);
        switchToAlert().dismiss();
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
