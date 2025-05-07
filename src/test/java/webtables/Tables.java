package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tables {
    WebDriver driver;
    ChromeOptions options;
    int a=0;

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
    public void prac(){
        List<WebElement> costs = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for(WebElement cost:costs){
            int temp=Integer.parseInt(cost.getText());
            a=a+temp;
        }
        System.out.println("The total sum is : " + a);
        String[] totalAmounts = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");
        String amount = totalAmounts[1].trim();
        System.out.println(amount);
        Assert.assertEquals(a,Integer.parseInt(amount));
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
