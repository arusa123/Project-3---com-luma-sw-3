package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class MenTest extends Utilities {
    @Before
    public void browserOpening() {
        openBrowser("Chrome", "https://magento.softwaretestingboard.com/");
    }


    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
//             Mouse Hover on Men Menu
        mouseHoverOnElement(By.id("ui-id-5"));

//                * Mouse Hover on Bottoms
        mouseHoverOnElement(By.id("ui-id-18"));

//                * Click on Pants
        clickOnElement(By.linkText("Pants"));

//              Mouse Hover on product name Cronus Yoga Pant’ and click on size 32.
        mouseHoverOnElement(By.xpath("//div[@class='product details product-item-details']"));
        clickOnElement(By.xpath("//div[@class='swatch-attribute size']/div[1]/div"));

//                * Mouse Hover on product name Cronus Yoga Pant’ and click on colour Black
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("(//div[@class='swatch-attribute color'])[1]/div/div[1]"));

//        Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("(//div[@class='product-item-inner'])[1]/div/div[1]/form/button"));

        verifyText(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Cronus Yoga Pant to your shopping cart.");

//        Click on ‘shopping cart’ Link into  message
        clickOnElement(By.linkText("shopping cart"));

//        Verify the text ‘Shopping Cart.’
        Thread.sleep(2000);
        verifyText(By.xpath("//span[@class='base']"), "Shopping Cart");
//        Verify the product name ‘Cronus Yoga Pant’
        verifyText(By.xpath("(//a[contains(.,'Cronus Yoga Pant')])[2]"), "Cronus Yoga Pant");
//         Verify the product size ‘32’
        verifyText(By.xpath("//dd[contains(text(),'32')]"), "32");

//         Verify the product colour ‘Black’
        verifyText(By.xpath("//dd[contains(text(),'Black')]"), "Black");

    }
    @After
    public void browsercloose(){
        closeBrowser();
    }

}
