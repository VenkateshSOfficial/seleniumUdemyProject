package selenium4Features;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class WebElementScreenshots {
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
    public void execute() throws IOException {
        WebElement nameTextBox = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        nameTextBox.sendKeys("hello kaushik");
        File screenshotOfName = nameTextBox.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotOfName,new File("src/main/screenshots/name.png"));
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
