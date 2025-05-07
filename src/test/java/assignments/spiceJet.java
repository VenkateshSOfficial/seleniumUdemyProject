package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class spiceJet {
    WebDriver driver;
    ChromeOptions options;
    Select select;

    @BeforeTest
    public void launchBrowser(){
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void execute() throws InterruptedException {
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-datepicker-current-day")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("div#divpaxinfo")).click();
        Thread.sleep(2000);
        int i=1;
        while(i<5){
            Thread.sleep(2000);
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);
        String adultsCount = driver.findElement(By.cssSelector("#divpaxinfo")).getText();
        Assert.assertEquals(adultsCount,"5 Adult");

        Thread.sleep(2000);
        select.selectByVisibleText("USD");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"USD");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
