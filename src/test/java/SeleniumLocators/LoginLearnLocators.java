package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginLearnLocators {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void execute() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("kauhsikswaminathan6@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("chkboxTwo")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.signInBtn")).click();
        Thread.sleep(2000);
        String loginSuccessMessage = driver.findElement(By.cssSelector("div.login-container p")).getText();
        Assert.assertEquals(loginSuccessMessage,"You are successfully logged in.");
        System.out.println(loginSuccessMessage);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
