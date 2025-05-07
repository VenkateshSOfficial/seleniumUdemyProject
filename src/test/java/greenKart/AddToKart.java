package greenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddToKart {
    WebDriver driver;
    ChromeOptions options;
    WebDriverWait explicityWait;

    public void addItemsTokart() {
        String[] vegNames = {"Beans", "Brinjal", "Cauliflower", "Carrot"};
        List<WebElement> veggiesNames = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < veggiesNames.size(); i++) {
            String[] name = veggiesNames.get(i).getText().split("-");
            String vegetablesName = name[0].trim();
            if (Arrays.asList(vegNames).contains(vegetablesName)) {
//                System.out.println(vegetablesName);
                driver.findElements(By.cssSelector(".product-action button")).get(i).click();
            }
        }
    }

    public void explicitlyWait(By locator) {
        explicityWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicityWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    @BeforeTest
    public void launchBrowser() {
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @Test
    public void execute() throws InterruptedException {
        addItemsTokart();
        driver.findElement(By.cssSelector(".cart-icon img")).click();
        driver.findElement(By.xpath("//div[@class='cart-preview active']/child::div[2]/button")).click();
        By promoCode=(By.cssSelector(".promoCode"));
        explicitlyWait(promoCode);
        WebElement promoCodetextBox = driver.findElement(promoCode);
        promoCodetextBox.sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoWrapper button")).click();
        By promoValidationLocator = (By.cssSelector(".promoInfo"));
        explicitlyWait(promoValidationLocator);
        WebElement promoValidationText = driver.findElement(promoValidationLocator);
        System.out.println(promoValidationText.getText());
        Assert.assertTrue(promoValidationText.isDisplayed());
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
