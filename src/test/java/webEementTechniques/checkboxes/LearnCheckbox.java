package webEementTechniques.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LearnCheckbox {
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
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@id='discount-checkbox']//child::input"));
        for(WebElement checkbox:checkboxes){
            if(!checkbox.isSelected()){
                Thread.sleep(1000);
                checkbox.click();
                Assert.assertTrue(checkbox.isSelected());
            }
        }

    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
