package assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment3 {
    WebDriver driver;
    ChromeOptions options;
    String value;

    public void selectDropdown(WebElement ele, String data){
        ele.click();
        Select s=new Select(ele);
        for(WebElement option:s.getOptions()){
            if(option.getText().equalsIgnoreCase(data)){
                s.selectByVisibleText(data);
//                System.out.println(s.getFirstSelectedOption().getText());
                Assert.assertEquals(s.getFirstSelectedOption().getText(),data);
                break;
            }
        }
    }

    public void switchToAlert(){
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
        Assert.assertTrue(text.contains(value));
    }

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
    public void practice(){
        value=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[3]")).getText();
        System.out.println("The value is : " + value);
        driver.findElement(By.cssSelector("#checkBoxOption3")).click();
        WebElement dropdownButton = driver.findElement(By.cssSelector("#dropdown-class-example"));
        selectDropdown(dropdownButton,value);
        driver.findElement(By.cssSelector("#name")).sendKeys(value);
        driver.findElement(By.cssSelector("#alertbtn")).click();
        switchToAlert();
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
