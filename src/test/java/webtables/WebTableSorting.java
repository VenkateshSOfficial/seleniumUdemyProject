package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting{
    WebDriver driver;
    ChromeOptions options;


    @BeforeTest
    public void launchBrowser(){
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }

    @Test
    public void execute() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//*[@class='table table-bordered']//tr/th)[1]")).click();
        List<WebElement> allFruitsVeggiesNames = driver.findElements(By.xpath("//*[@class='table table-bordered']/tbody/tr/td[1]"));
        List<String> currentNames = allFruitsVeggiesNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println("The current names : " + currentNames);

        List<String> sortedNames = allFruitsVeggiesNames.stream()
                .map(WebElement::getText)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("The sorted names : " + sortedNames);

        Assert.assertEquals(currentNames,sortedNames, "Lists are not equal!");

        String itemName="rice";

        /*allFruitsVeggiesNames.stream().filter(element->element.getText().toLowerCase().contains(itemName))
                .map(PriceCalculation::getPrice)
                .forEach(x->System.out.println("The price of " + itemName + " is : " + x));*/

        List<String> price;
        do{
            List<WebElement> allNames = driver.findElements(By.xpath("//*[@class='table table-bordered']/tbody/tr/td[1]"));
            price= allNames.stream()
                    .filter(element -> element.getText().toLowerCase().contains(itemName))
                    .map(PriceCalculation::getPrice).collect(Collectors.toList());

             price.forEach(x->System.out.println("The price of " + itemName + " is : " + x));

            if(price.size()<1){
                driver.findElement(By.xpath("//*[@aria-label='Next']")).click();
            }
        }while (price.size()<1);

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
