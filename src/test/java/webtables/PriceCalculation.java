package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriceCalculation {
    public static String getPrice(WebElement ele) {
        return ele.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
