package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowser {
    WebDriver driver;
    String title;
    String currentUrl;

    @BeforeMethod
    public void launchBrowser(){

        /* Execute on Chrome driver */
        driver=new ChromeDriver();
        driver.get("https://www.udemy.com/home/my-courses/learning/");
        driver.manage().window().maximize();

        /* Execute on firefox driver */
        driver=new FirefoxDriver();
        driver.get("https://www.udemy.com/home/my-courses/learning/");
        driver.manage().window().maximize();

        /* Execute on edge driver */
        driver =new EdgeDriver();
        driver.get("https://www.udemy.com/home/my-courses/learning/");
        driver.manage().window().maximize();

    }
    @Test
    public void printBrowserTitle(){
        title = driver.getTitle();
        currentUrl = driver.getCurrentUrl();
        System.out.println("The title of the page is : " + title);
        System.out.println("The current title is : " + currentUrl);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
