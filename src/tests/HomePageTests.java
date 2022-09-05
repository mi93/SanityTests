package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests {
    public WebDriver driver;

    @BeforeClass
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://sampleshop.inqa.pl/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkHomePageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Automation Sample Shop");
    }

    @Test
    public void openMansCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("category-3"))).pause(1000).moveToElement(driver.findElement(By.id("category-4"))).click().build().perform();

        WebElement we = driver.findElement(By.cssSelector("#js-product-list-header > div > h1"));
        Assert.assertEquals(we.getText(), "MENs");
        }


}
