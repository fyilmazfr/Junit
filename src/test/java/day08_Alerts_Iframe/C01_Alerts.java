package day08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01(){
        /*herhangi bir veb sitesine gidince veya bir websitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara
        alerts diyoruz.

      HTML alert :  eger bir alert inspect yapilabiliyorsa o alert otomastion ile kullanilabilir, bu tur alert'lere HTML alert denir
        ve bunlar icin eksta bir islem yapmaya gerek yoktur ,tum webelementmler gibi locate edip istedigimiz islemleri
         yapabiliriz.
         Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir.
         JS alert'ler locate edilmez
         seleniumda JS alert'ler icin ozel bir yontem gelistirilmistir

         https://the-internet.herokuapp.com/javascript_alerts
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //ALERT'te ok tusuna basin ve
        driver.switchTo().alert().accept();

        //driver.switchTo().alert().getText();
        //driver.switchTo().alert().sendKeys("yilmaz");
        //driver.switchTo().alert().dismiss(); CANCEL ICIN BUNU YAPARIZ

        //result kisminda "You successfully clicked an alert" yazdigini test edin
        String expectedResult="You successfully clicked an alert";
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYaziElementi.getText();

        Assert.assertEquals(expectedResult,actualResultYazisi);

    }
}


















