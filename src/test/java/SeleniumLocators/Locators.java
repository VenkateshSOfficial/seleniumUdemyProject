package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators {
    WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void login() throws InterruptedException {
        driver.findElement(By.id("inputUsername")).sendKeys("kaushikswaminathan6@gmail.com");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshetty");
        driver.findElement(By.className("signInBtn")).click();

        /* building basics CSS using id and class name as below
        * build using class name -> tagname.class name
        * build using id -> tagname.id
        * general syntax -> tagname[attribute='value'] */

        /* building basics of xpath syntax as below
        *  xpath syntax -> //tagname[@attribute='value']
        *  xpath syntax -> //*[@attribute='value']     */

        /* CSS selector using he indexes as below
        * input[placeholder='Email']:nth-child(3)
        * we can use nth-child to find the indexes in the css selector */


        String errorText = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorText);
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("kaushik");
        driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//*[@placeholder='Email']")).clear();
        //driver.findElement(By.cssSelector("input[placeholder='Email']:nth-child(3)")).sendKeys("babbi@gmail.com");
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
