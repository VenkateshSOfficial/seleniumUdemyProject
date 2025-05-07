package assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class AssignmentWaits {
    WebDriver driver;
    ChromeOptions options;
    WebDriverWait explicityWait;

    public void ExplicitlyWaitToClickElement(By locator) {
        explicityWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicityWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void explicitlyWaitForElementToBeVisible(By locator) {
        explicityWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicityWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void selectDropDown(WebElement ele, String data) {
        Select select = new Select(ele);
        select.selectByValue(data);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        Assert.assertTrue(firstSelectedOption.isSelected());
    }

    @BeforeTest
    public void launchBrowser() {
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("guest");
        driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void execute() {
        driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#password")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
        By okButton = By.cssSelector("#okayBtn");
        ExplicitlyWaitToClickElement(okButton);
        driver.findElement(okButton).click();
        WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
        selectDropDown(dropdown, "consult");
        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.cssSelector("input#signInBtn")).click();
        By productPageName = By.xpath("//div[@class=\"container\"]/child::nav/a");
        explicitlyWaitForElementToBeVisible(productPageName);
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//i[@class='zmdi zmdi-shopping-cart']/parent::button"));
        System.out.println("Total products are : " + addToCartButtons.size());
        for(WebElement button:addToCartButtons){
            button.click();
        }
        WebElement checkoutButton = driver.findElement(By.cssSelector(".nav-item.active a"));
        String[] checkoutItems = checkoutButton.getText().split("\\(");
        String[] itemsData = checkoutItems[1].split("\\)");
        String cartDetails = itemsData[0].trim();
        System.out.println("Total items are : " + cartDetails);
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }
}
