package day12_senkronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {

    @Test
    public void enableTest() {

        //bu adrese gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //textBox'in etkin olmadigini(enabled) dogrulayin
        WebElement enableKutusu= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKutusu.isEnabled());//text box kutusu enable olmadigini test ettik

        //enable kutusuna tiklayin ve Textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));//BEKLEYECEGIMIZ ICIN BIR wait objesi olusturduk
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu)); // enable kutusu tiklanabilir oluncaya kadar bekle dedik  ,elementToBeClickable

        //its enable mesajinin goruntulendigini test edin
        WebElement itsEnabledYazisi= driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnabledYazisi.isDisplayed());

        //text box'in etkin oldugunu(enabled) dogrulayin
        Assert.assertTrue(enableKutusu.isEnabled()); //23. satirda etkin olmadigini test ettik



    }
}
