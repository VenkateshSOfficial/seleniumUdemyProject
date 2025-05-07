package webEementTechniques.frames;

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

public class PracticeFrames {
    WebDriver driver;
    ChromeOptions options;

    public void switchToFrame(WebElement ele){
        driver.switchTo().frame(ele);
    }
    public void switchToFrame(int val){
        driver.switchTo().frame(val);
    }
    public void switchToFrame(String data){
        driver.switchTo().frame(data);
    }
    @BeforeTest
    public void launchBrowser(){
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }
    @Test
    public void execute(){
        WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
        switchToFrame(frame);
        WebElement draggable=driver.findElement(By.cssSelector("#draggable"));
        WebElement droppable = driver.findElement(By.cssSelector("#droppable"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
