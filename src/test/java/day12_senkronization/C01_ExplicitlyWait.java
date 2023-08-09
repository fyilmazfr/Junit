package day12_senkronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    @Test
    public void Test01ImplicitlyWaitTesti() {
        //IKI TANE metod olusturun implicitly ve explicitly
        //iki metod icinde asagidaki adimlari test edin
        //https://the-internet.herokuapp.com/dynamic_controls  gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //removo butonuna basin
        WebElement removobutonu= driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removobutonu.click();
        //it's gone mesajinin goruntulendigini dogrulayin
        WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());//cikan yazinin gorunur oldugunu test ettik
        //add butonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        //its back yazisinin gorundugunu test edin
        WebElement itsBackYazisi= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackYazisi.isDisplayed());



    }

    @Test
    public void Test02ExplctlyWaitTesti() {

        //https://the-internet.herokuapp.com/dynamic_controls  gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //removo butonuna basin
        WebElement removobutonu= driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removobutonu.click();
        //it's gone mesajinin goruntulendigini dogrulayin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));//wait objesi olusturduk
        /*
        WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        yazinin gorunur olmasini beklerken yazini locate'ini kullanmak sorun olusturur cunku henuz gorunmeyen
        bir yazinin locate edilmeside mumkun OLMAYABILIR.(hdml kodlari yazan dev farkli uygulamalar yapabilir)
        bu durumda bekleme islemive locate'i birlikte yapmaliyiz
         */
        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        //add butonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //its back yazisinin gorundugunu test edin
        WebElement itsBackYazisi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYazisi.isDisplayed());












    }
}
