package webEementTechniques.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDownStatic {

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
        // static dropdown with select tag
        WebElement dropdown = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select select=new Select(dropdown);
        Thread.sleep(5000);
        select.selectByIndex(2);
        System.out.println("The selected option is : " + select.getFirstSelectedOption().getText());
        Thread.sleep(5000);
        select.selectByValue("INR");
        System.out.println("The selected option is : " + select.getFirstSelectedOption().getText());
        Thread.sleep(5000);
        select.selectByVisibleText("USD");
        System.out.println("The selected option is : " + select.getFirstSelectedOption().getText());
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
