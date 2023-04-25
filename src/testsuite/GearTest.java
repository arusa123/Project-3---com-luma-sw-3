package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utilities;

public class GearTest extends Utilities {
    @Before
    public void browserOpening() {
        openBrowser("Chrome", "https://magento.softwaretestingboard.com/");
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
//        Mouse Hover on Gear Menu
        mouseHoverOnElement(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-corner-all']/li[4]"));
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
//       Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

//        Verify the text ‘Overnight Duffle’
        verifyText(By.xpath("//span[contains(.,'Overnight Duffle')]"), "Overnight Duffle");

        //* Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("3");

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));

        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyText(By.xpath("//div[contains(@data-bind,'html: $parent.prepareMessageForHtml(message.text)')]"),
                "You added Overnight Duffle to your shopping cart.");
        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.linkText("shopping cart"));

        //* Verify the product name ‘Cronus Yoga Pant’
        verifyText(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"),
                "Overnight Duffle");
        //* Verify the Qty is ‘3’
        String actualQuantity = driver.findElement(By.xpath("//input[@class='input-text qty']")).getAttribute("value");
        Assert.assertEquals("Quantity ", "3", actualQuantity);

        //* Verify the product price ‘$135.00’
        verifyText(By.xpath("//span[@data-bind='text: getValue()'][normalize-space()='$135.00']"), "$135.00");

        //* Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys("5");

        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//button[@class='action update']"));

        //* Verify the product price ‘$225.00’
        Thread.sleep(1000);
        verifyText(By.xpath("(//span[@class='cart-price'])[2]"), "$225.00");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
