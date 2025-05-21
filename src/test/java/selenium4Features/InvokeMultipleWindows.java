package selenium4Features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class InvokeMultipleWindows {
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
    public void execute(){
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size());
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        System.out.println("The new title is : " + driver.getTitle());
        driver.switchTo().window(parentWindow);
        System.out.println("The old title is : " + driver.getTitle());

    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
