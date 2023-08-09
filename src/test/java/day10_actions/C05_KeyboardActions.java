package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void tets01() throws InterruptedException {
        driver.get("https://www.amazon.fr");
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));

        //once arama kutusuna click yapip
        // sonra harf harf nutella yazisini yazdiralim
        // sonrada ENTER tusuna basalim

        Actions actions=new Actions(driver);
        actions.click(aramakutusu).perform();
        actions.keyDown(Keys.SHIFT).perform();//buyuk harf
        actions.sendKeys("n").//kucuk n yazdik ama shift'e basili oldugu icin buyuk N yazar arama kutusuna
        keyUp(Keys.SHIFT).//kucuk harf yaptik
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").sendKeys(Keys.ENTER).perform();


        Thread.sleep(3000);
    }
}
