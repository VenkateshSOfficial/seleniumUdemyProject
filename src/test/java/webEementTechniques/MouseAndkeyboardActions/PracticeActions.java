package webEementTechniques.MouseAndkeyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeActions {
    WebDriver driver;
    ChromeOptions options;
    Actions actions;

    @BeforeTest
    public void launchBrowser(){
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void execute(){
        actions=new Actions(driver);
        WebElement accountsOption = driver.findElement(By.cssSelector("#nav-link-accountList"));
        // move to a specific element
        actions.moveToElement(accountsOption).perform();

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        actions.keyDown(Keys.SHIFT).sendKeys(searchBox,"hello").doubleClick().perform();
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
