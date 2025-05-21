package selenium4Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    WebDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void launchBrowser(){
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void execute(){
        WebElement name = driver.findElement(By.xpath("(//*[@name='name'])[1]"));
        String labelName = driver.findElement(with(By.tagName("label")).above(name)).getText();
        System.out.println(labelName);
        WebElement date = driver.findElement(By.xpath("//input[@type='date']"));
        driver.findElement(with(By.tagName("input")).below(date)).click();
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
