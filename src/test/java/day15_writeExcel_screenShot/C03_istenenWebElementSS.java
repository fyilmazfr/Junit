package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_istenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        //amazona gidip Nutella aratalim
        //sonuc sayisinin oldugu web elementin fotografini cekkelimm

        driver.get("https://www.amazon.com");
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYazielementSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");//kalici dosya
        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);//gecici dosya

        FileUtils.copyFile(temp,sonucYazielementSS);

    }
}
