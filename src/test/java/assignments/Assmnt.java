package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assmnt {
    WebDriver driver;
    ChromeOptions options;
    String val;


    @BeforeTest
    public void launchBrowser(){
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void exe(){
        val = driver.findElement(By.cssSelector("#checkBoxOption3")).getDomAttribute("value");
        val = val.substring(0, 1).toUpperCase() + val.substring(1);
        System.out.println("The value is : " + val);
        driver.findElement(By.cssSelector("#checkBoxOption3")).click();
        WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
        Select s=new Select(dropdown);
        s.selectByVisibleText(val);
        System.out.println(s.getFirstSelectedOption().getText());
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
