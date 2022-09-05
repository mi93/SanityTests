package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTests extends HomePageTests{

    @Test
    public void addItemToCart() {
        driver.get("http://sampleshop.inqa.pl/women/2-9-brown-bear-printed-sweater.html#/1-rozmiar-s");
        WebElement selectButton = driver.findElement(By.id("group_1"));
        Select selectSize = new Select(selectButton);
        selectSize.selectByVisibleText("M");
        WebElement selectedValueElement = selectSize.getFirstSelectedOption();
        String selectedValueString = selectedValueElement.getText();
        Assert.assertEquals(selectedValueString, "M");
//        WebElement addToCartButton = driver.findElement(By.
    }
}
