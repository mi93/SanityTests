package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VichyTests {

    private WebDriver driver;

    @BeforeClass
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vichyusa.com/discover-vichy/whats-new/online-exclusives/summer-glow-duo-summerglowduo.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void findPDPdiv() {
        //WebElement ShoprunnerLogo = driver.findElement(By.cssSelector(".srd_iconline > [aria-hidden]")); //czasem działa a czasem Unable to locate element: {"method":"css selector","selector":".srd_iconline > [aria-hidden]"}
        //WebElement ShoprunnerLogo = driver.findElement(By.xpath("//div[@id='srd_pd']//div[@class='srd_logo']"));
        //WebElement Free2DayShippingAndFreeReturnsDiv = driver.findElement(By.cssSelector("[aria-label] span [aria-hidden]"));
        //WebElement Free2DayShippingAndFreeReturnsDiv = driver.findElement(By.xpath("/html//div[@id='srd_pd']/div[@class='srd_iconline']//strong[.='FREE 2-Day Shipping & Free Returns']")); //to samo, czasem nie wyszukuje
        //String Free2DayShippingAndFreeReturnsText = Free2DayShippingAndFreeReturnsDiv.getText();
        //System.out.println(Free2DayShippingAndFreeReturnsText);
        ///Assert.assertEquals(Free2DayShippingAndFreeReturnsText, "FREE 2-Day Shipping & Free Returns");
        WebElement learnMorelink = driver.findElement(By.cssSelector("[aria-label='learn more about shoprunner'] [aria-haspopup]"));
        String learnMoreText = learnMorelink.getText();
        //System.out.println(learnMoreText);
        Assert.assertEquals(learnMoreText, "Learn More");
        WebElement signInLink = driver.findElement(By.cssSelector("button#sr_ec_signInSignOut > span"));
        String signInText = signInLink.getText();
        Assert.assertEquals(signInText, "Sign In" );


    }

    @Test
    public void learnMoreModalCheck() {
        WebElement learnMorelink = driver.findElement(By.cssSelector("[aria-label='learn more about shoprunner'] [aria-haspopup]"));
        learnMorelink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
