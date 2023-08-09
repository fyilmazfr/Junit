package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JsExecutor extends TestBase {
    @Test
    public void javascpritExecutorTest() throws InterruptedException {
        //amazona git
        driver.get("https://www.amazon.com");
        //asagida ki sign in butonu gorununceye kadar js ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;//cast yaptik
        WebElement signInButonu= driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);

        //sign in butonuna js ile clik yapalim
        jse.executeScript("arguments[0].click",signInButonu);


        Thread.sleep(3000);

    }
}
