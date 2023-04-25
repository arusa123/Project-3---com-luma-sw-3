package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utilities {
    @Before
    public void browserOpening() {
        openBrowser("Chrome", "https://magento.softwaretestingboard.com/");
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        Thread.sleep(2000);
//        * Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Women']"));
//                * Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));

        //                 Click on Jackets

        clickOnElement(By.id("ui-id-11"));

        List<WebElement> listOrder = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li/div/div/strong"));
        ArrayList<String> originalList = new ArrayList<>();
        for (WebElement e : listOrder) {
            originalList.add(e.getText());
        }
        System.out.println(originalList);
        Collections.sort(originalList);
        System.out.println(originalList);
//        Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='sorter']"), "Product Name ");


//           Verify the products name display in
//        alphabetical order
        List<WebElement> listSorted = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li/div/div/strong"));
        ArrayList<String> listAfterSorting = new ArrayList<>();
        for (WebElement e : listSorted) {
            listAfterSorting.add(e.getText());
        }
        System.out.println(listAfterSorting);

        Assert.assertEquals("List is not sorted Alphabetical order", originalList, listAfterSorting);
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(2000);

//        * Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Women']"));

//                * Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));

        //                 Click on Jackets


        clickOnElement(By.id("ui-id-11"));

        List<WebElement> listOrder = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']/span"));
        ArrayList<String> originalPriceList = new ArrayList<>();
        for (WebElement e : listOrder) {
            originalPriceList.add(e.getText());
        }
        System.out.println(originalPriceList);
        Collections.sort(originalPriceList);
        System.out.println(originalPriceList);

//           * Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='sorter']"), "Price ");
//         *Verify the products price display in
//        Low to High
        listOrder = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']/span"));
        ArrayList<String> listAfterPriceSort = new ArrayList<>();
        for (WebElement e : listOrder) {
            listAfterPriceSort.add(e.getText());
        }
        System.out.println(listAfterPriceSort);

        Assert.assertEquals("Price is not in Low to high", originalPriceList, listAfterPriceSort);
    }


}


