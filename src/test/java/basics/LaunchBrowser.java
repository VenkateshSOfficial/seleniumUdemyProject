package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowser {
    WebDriver driver;
    String title;
    @BeforeMethod
    public void launchBrowser(){
        driver=new ChromeDriver();
        driver.get("https://www.udemy.com/home/my-courses/learning/");
        driver.manage().window().maximize();
    }
    @Test
    public void printBrowserTitle(){
        title = driver.getTitle();
        System.out.println("The title of the page is : " + title);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
