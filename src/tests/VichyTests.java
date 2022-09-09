package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VichyTests extends BaseTest {

    @BeforeClass
    public void openProductDetailPage() {
        driver.get("https://www.vichyusa.com/discover-vichy/whats-new/online-exclusives/summer-glow-duo-summerglowduo.html");
    }

    @Test
    public void findPDPdiv() {
        WebElement message = driver.findElement(By.cssSelector(".srd_msg")).findElement(By.xpath("//strong"));
        WebElement button1 = driver.findElement(By.cssSelector(".srd_msg .srd_a "));
        WebElement button2 = driver.findElements(By.cssSelector(".srd_msg .srd_a")).get(1);
        String messageString = message.getText();
        System.out.println(messageString);
        System.out.println(button1.getText());
        System.out.println(button2.getText());
    }

    @Test
    public void learnMoreModalCheck() {
        WebElement learnMorelink = driver.findElement(By.cssSelector("[aria-label='learn more about shoprunner'] [aria-haspopup]"));
        learnMorelink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
